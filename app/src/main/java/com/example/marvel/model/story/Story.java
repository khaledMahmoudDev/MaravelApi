package com.example.marvel.model.story;

import com.example.marvel.model.character.ComicList;
import com.example.marvel.model.character.ComicSummary;
import com.example.marvel.model.character.EventList;
import com.example.marvel.model.character.Image;
import com.example.marvel.model.character.SeriesList;
import com.example.marvel.model.comic.CharacterList;
import com.example.marvel.model.comic.CreatorList;


public class Story {

    private int id;
    private String title;
    private String  description;
    private String modified;
    private String resourceURI;
    private String type;

    private Image thumbnail;
    private CreatorList creators;
    private CharacterList characters;
    private ComicList comics;
    private EventList events;
    private SeriesList series;
    private ComicSummary originalissue;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public ComicList getComics() {
        return comics;
    }

    public void setComics(ComicList comics) {
        this.comics = comics;
    }

    public EventList getEvents() {
        return events;
    }

    public void setEvents(EventList events) {
        this.events = events;
    }

    public SeriesList getSeries() {
        return series;
    }

    public void setSeries(SeriesList series) {
        this.series = series;
    }

    public ComicSummary getOriginalissue() {
        return originalissue;
    }

    public void setOriginalissue(ComicSummary originalissue) {
        this.originalissue = originalissue;
    }
}
