package com.example.marvel.repostory;

import com.example.marvel.Assets;
import com.example.marvel.network.DataStatus;
import com.example.marvel.model.comic.Comic;
import com.example.marvel.model.comic.ComicDataWrapper;
import com.example.marvel.model.event.Event;
import com.example.marvel.model.event.EventDataWrapper;
import com.example.marvel.model.series.Series;
import com.example.marvel.model.series.SeriesDataWrapper;
import com.example.marvel.model.story.Story;
import com.example.marvel.model.story.StoryDataWrapper;
import com.example.marvel.network.RetrofitClient;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsRepo {

    DataStatus dataStatus;

    public DetailsRepo(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    private Long timeStamp = new Date().getTime();

    private String hash = Assets.md5(timeStamp.toString() + Assets.PRIVATE_API_KEY + Assets.PUBLIC_API_KEY);


    public void getEvent(int eventId) {
        final ArrayList<Event> eventArrayList = new ArrayList<>();

        RetrofitClient.getInstance().getApi().getEvent(eventId,
                timeStamp.toString()
                , Assets.PUBLIC_API_KEY
                , hash
                , Assets.PAGE_LIMIT
                , Assets.OFFSET).enqueue(new Callback<EventDataWrapper>() {
            @Override
            public void onResponse(Call<EventDataWrapper> call, Response<EventDataWrapper> response) {
                if (response.body() != null) {
                    eventArrayList.addAll(response.body().getData().getResults());
                    dataStatus.onEventSucess("done", eventArrayList);
                }
            }

            @Override
            public void onFailure(Call<EventDataWrapper> call, Throwable t) {

                dataStatus.onSucess("failed");
            }
        });
    }

    public void getSeries(int seriesId) {
        final ArrayList<Series> seriesArrayList = new ArrayList<>();

        RetrofitClient.getInstance().getApi().getSeries(seriesId,
                timeStamp.toString()
                , Assets.PUBLIC_API_KEY
                , hash
                , Assets.PAGE_LIMIT
                , Assets.OFFSET).enqueue(new Callback<SeriesDataWrapper>() {
            @Override
            public void onResponse(Call<SeriesDataWrapper> call, Response<SeriesDataWrapper> response) {
                if (response.body() != null) {
                    seriesArrayList.addAll(response.body().getData().getResults());
                    dataStatus.onSeriesSucess("done",seriesArrayList);
                }
            }

            @Override
            public void onFailure(Call<SeriesDataWrapper> call, Throwable t) {

                dataStatus.onSucess("failed");
            }
        });

    }

    public void getStory(int storyId) {
        final ArrayList<Story> storyArrayList = new ArrayList<>();
        RetrofitClient.getInstance().getApi().getStory(storyId,
                timeStamp.toString()
                , Assets.PUBLIC_API_KEY
                , hash
                , Assets.PAGE_LIMIT
                , Assets.OFFSET).enqueue(new Callback<StoryDataWrapper>() {
            @Override
            public void onResponse(Call<StoryDataWrapper> call, Response<StoryDataWrapper> response) {
                if (response.body() != null) {
                    storyArrayList.addAll(response.body().getData().getResults());
                    dataStatus.onStoriesSucess("done",storyArrayList);
                }
            }

            @Override
            public void onFailure(Call<StoryDataWrapper> call, Throwable t) {
                dataStatus.onSucess("failed");

            }
        });

    }

    public void getCommic(int comicId) {

        final ArrayList<Comic> comicList = new ArrayList<>();

        RetrofitClient.getInstance().getApi().getComic(comicId,
                timeStamp.toString()
                , Assets.PUBLIC_API_KEY
                , hash
                , Assets.PAGE_LIMIT
                , Assets.OFFSET).enqueue(new Callback<ComicDataWrapper>() {
            @Override
            public void onResponse(Call<ComicDataWrapper> call, Response<ComicDataWrapper> response) {
                if (response.body() != null) {
                    comicList.addAll(response.body().getData().getResults());
                    dataStatus.onComicSucess("done",comicList);
                }
            }

            @Override
            public void onFailure(Call<ComicDataWrapper> call, Throwable t) {
                dataStatus.onSucess("failed");

            }
        });
    }


}
