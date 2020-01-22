package com.example.marvel.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.marvel.Assets;
import com.example.marvel.network.DataStatus;
import com.example.marvel.model.character.Character;
import com.example.marvel.repostory.CharacterDataSourceFactory;

public class MainViewModel extends ViewModel {

    LiveData<PagedList<Character>> listLiveData;
    LiveData<PageKeyedDataSource<Integer, Character>> dataSourceLiveData;

    public LiveData<PagedList<Character>> getCharacterList(String querString, DataStatus dataStatus) {
        CharacterDataSourceFactory dataSourceFactory = new CharacterDataSourceFactory(querString, dataStatus);
        dataSourceLiveData = dataSourceFactory.getPageKeyedDataSourceMutableLiveData();
        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(Assets.PAGE_LIMIT)
                .build();

        listLiveData =new LivePagedListBuilder(dataSourceFactory,config).build();
        return listLiveData;

    }


}
