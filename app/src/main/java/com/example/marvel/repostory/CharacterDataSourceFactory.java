package com.example.marvel.repostory;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.marvel.network.DataStatus;
import com.example.marvel.model.character.Character;

public class CharacterDataSourceFactory extends DataSource.Factory {
    private String qureyString;
    DataStatus dataStatus;

    public CharacterDataSourceFactory(String qureyString, DataStatus dataStatus) {
        this.qureyString = qureyString;
        this.dataStatus = dataStatus;
    }

    private MutableLiveData<PageKeyedDataSource<Integer, Character>> pageKeyedDataSourceMutableLiveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource create() {

        CharactersPagedKeyDataSource dataSource = new CharactersPagedKeyDataSource(qureyString,dataStatus);
        pageKeyedDataSourceMutableLiveData.postValue(dataSource);


        return dataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Character>> getPageKeyedDataSourceMutableLiveData() {
        return pageKeyedDataSourceMutableLiveData;
    }


}
