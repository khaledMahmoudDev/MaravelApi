package com.example.marvel.model.event;

import com.example.marvel.model.character.ComicList;
import com.example.marvel.model.character.EventSummary;
import com.example.marvel.model.character.Image;
import com.example.marvel.model.character.SeriesList;
import com.example.marvel.model.character.StoryList;
import com.example.marvel.model.character.Url;
import com.example.marvel.model.comic.CharacterList;
import com.example.marvel.model.comic.CreatorList;

import java.util.ArrayList;

public class Event {

    private int id;
    private String title;

    private String  description;
    private String modified;
    private String resourceURI;
    private ArrayList<Url> urls;
    private String start;
    private String end;
    private Image thumbnail;
    private CreatorList creators;
    private CharacterList characters;
    private StoryList stories;
    private ComicList comics;
    private SeriesList series;
    private EventSummary next;
    private EventSummary previous;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public ArrayList<Url> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<Url> urls) {
        this.urls = urls;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CreatorList getCreators() {
        return creators;
    }

    public void setCreators(CreatorList creators) {
        this.creators = creators;
    }

    public CharacterList getCharacters() {
        return characters;
    }

    public void setCharacters(CharacterList characters) {
        this.characters = characters;
    }

    public StoryList getStories() {
        return stories;
    }

    public void setStories(StoryList stories) {
        this.stories = stories;
    }

    public ComicList getComics() {
        return comics;
    }

    public void setComics(ComicList comics) {
        this.comics = comics;
    }

    public SeriesList getSeries() {
        return series;
    }

    public void setSeries(SeriesList series) {
        this.series = series;
    }

    public EventSummary getNext() {
        return next;
    }

    public void setNext(EventSummary next) {
        this.next = next;
    }

    public EventSummary getPrevious() {
        return previous;
    }

    public void setPrevious(EventSummary previous) {
        this.previous = previous;
    }
}
