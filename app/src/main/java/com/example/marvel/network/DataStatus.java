package com.example.marvel.network;

import com.example.marvel.model.comic.Comic;
import com.example.marvel.model.event.Event;
import com.example.marvel.model.series.Series;
import com.example.marvel.model.story.Story;

import java.util.ArrayList;

public interface DataStatus {

    void onSucess(String status);
    void onComicSucess(String status, ArrayList<Comic> comicList);
    void onEventSucess(String status, ArrayList<Event> eventArrayList);
    void onSeriesSucess(String status, ArrayList<Series> seriesArrayList);
    void onStoriesSucess(String status ,ArrayList<Story> storyArrayList);

    void onFailure(String status);
}
