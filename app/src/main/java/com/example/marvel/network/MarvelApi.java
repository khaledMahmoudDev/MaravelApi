package com.example.marvel.network;

import com.example.marvel.model.character.CharacterDataWrapper;
import com.example.marvel.model.comic.ComicDataWrapper;
import com.example.marvel.model.event.EventDataWrapper;
import com.example.marvel.model.series.SeriesDataWrapper;
import com.example.marvel.model.story.StoryDataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelApi {


    @GET("v1/public/characters")
    Call<CharacterDataWrapper> getCharacters(
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("nameStartsWith") String nameStartWith,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset);


    @GET("/v1/public/comics/{comicId}")
    Call<ComicDataWrapper> getComic(@Path("comicId") int comicId,
                                    @Query("ts") String ts,
                                    @Query("apikey") String apiKey,
                                    @Query("hash") String hash,
                                    @Query("limit") Integer limit,
                                    @Query("offset") Integer offset);

    @GET("/v1/public/series/{seriesId}")
    Call<SeriesDataWrapper> getSeries(@Path("seriesId") int seriesId,
                                      @Query("ts") String ts,
                                      @Query("apikey") String apiKey,
                                      @Query("hash") String hash,
                                      @Query("limit") Integer limit,
                                      @Query("offset") Integer offset);

    @GET("/v1/public/stories/{storyId}")
    Call<StoryDataWrapper> getStory(@Path("storyId") int storyId,
                                    @Query("ts") String ts,
                                    @Query("apikey") String apiKey,
                                    @Query("hash") String hash,
                                    @Query("limit") Integer limit,
                                    @Query("offset") Integer offset);


    @GET("/v1/public/events/{eventId}")
    Call<EventDataWrapper> getEvent(@Path("eventId") int eventId,
                                    @Query("ts") String ts,
                                    @Query("apikey") String apiKey,
                                    @Query("hash") String hash,
                                    @Query("limit") Integer limit,
                                    @Query("offset") Integer offset);


}
