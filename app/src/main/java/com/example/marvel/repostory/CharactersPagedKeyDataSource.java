package com.example.marvel.repostory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.marvel.Assets;
import com.example.marvel.network.DataStatus;
import com.example.marvel.model.character.Character;
import com.example.marvel.model.character.CharacterDataWrapper;
import com.example.marvel.network.RetrofitClient;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersPagedKeyDataSource extends PageKeyedDataSource<Integer, Character> {
    private String qureyString;
    private DataStatus dataStatus;

    public CharactersPagedKeyDataSource(String qureyString, DataStatus dataStatus) {
        this.qureyString = qureyString;
        this.dataStatus = dataStatus;
    }



    private Long timeStamp = new Date().getTime();
    private Integer offset = Assets.OFFSET;
    private int limit = Assets.PAGE_LIMIT;


    private String hash = Assets.md5(timeStamp.toString() + Assets.PRIVATE_API_KEY + Assets.PUBLIC_API_KEY);



    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Character> callback) {

        Log.d("hash",timeStamp.toString()+Assets.PUBLIC_API_KEY+hash);
        RetrofitClient.getInstance().getApi().getCharacters(timeStamp.toString()
                ,Assets.PUBLIC_API_KEY
                ,hash
                ,qureyString
                ,Assets.PAGE_LIMIT
                ,Assets.OFFSET).enqueue(
                new Callback<CharacterDataWrapper>() {
                    @Override
                    public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                        if (response.body() != null)
                        {

                           offset += limit;
                            callback.onResult(response.body().getData().getResults(),null,offset);
                            Log.d("hashstatus","good");
                            dataStatus.onSucess("Data Received well");

                        }else
                        {

                            Log.d("hashstatus",call.request().url().toString());

                        }

                    }

                    @Override
                    public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                        Log.d("hashstatus",call.request().url().toString());
                        dataStatus.onFailure("failed to load data");

                    }
                }
        );
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Character> callback) {

        RetrofitClient.getInstance().getApi().getCharacters(
                timeStamp.toString(),
                Assets.PUBLIC_API_KEY,
                hash,
                qureyString,
                Assets.PAGE_LIMIT,
                params.key
                ).enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                if (response.body() != null)
                {
                    dataStatus.onSucess("Data Received well");
                    if (params.key > limit)
                    {
                        offset = offset -limit;
                    }
                    else
                    {
                        offset = 0;
                    }
                 //   Integer off = (params.key > Assets.PAGE_LIMIT) ? params.key- Assets.PAGE_LIMIT : null;
                    callback.onResult(response.body().getData().getResults(),offset);
                }
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                dataStatus.onFailure("failed to load data");

            }
        });

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Character> callback) {

        RetrofitClient.getInstance().getApi().getCharacters(
                timeStamp.toString(),
                Assets.PUBLIC_API_KEY,
                hash,
                qureyString,
                Assets.PAGE_LIMIT,
                params.key).enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                if (response.body() != null)
                {
                    dataStatus.onSucess("Data Received well");
                    if (response.body().getData().getTotal() - response.body().getData().getCount() > limit)
                    {
                        offset = offset+limit;
                    }else
                    {
                        offset = offset + response.body().getData().getTotal() - response.body().getData().getCount();
                    }

                    callback.onResult(response.body().getData().getResults(),offset);
                }
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                dataStatus.onFailure("failed to load data");

            }
        });

    }
}
