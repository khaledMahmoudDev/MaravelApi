package com.example.marvel.model.comic;

import com.example.marvel.model.character.ComicSummary;
import com.example.marvel.model.character.EventList;
import com.example.marvel.model.character.Image;
import com.example.marvel.model.character.SeriesSummary;
import com.example.marvel.model.character.StoryList;
import com.example.marvel.model.character.Url;

import java.util.ArrayList;

public class Comic {

    private int id;
    private int digitalId;
    private String title;
    private double issueNumber;
    private String variantDescription;
    private String  description;
    private String modified;
    private String  isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;
    private ArrayList<TextObject> textObjects;
    private String resourceURI;
    private ArrayList<Url> urls;
    private SeriesSummary series;
    private ArrayList<ComicSummary> variants;
    private ArrayList<ComicSummary> collections;
    private ArrayList<ComicSummary> collectedIssues;
    private ArrayList<ComicDate> dates;
    private ArrayList<ComicPrice> prices;
    private Image thumbnail;
    private ArrayList<Image> images;
    private CreatorList creators;
    private CharacterList characters;
    private StoryList stories;
    private EventList events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(double issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(ArrayList<TextObject> textObjects) {
        this.textObjects = textObjects;
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

    public SeriesSummary getSeries() {
        return series;
    }

    public void setSeries(SeriesSummary series) {
        this.series = series;
    }

    public ArrayList<ComicSummary> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<ComicSummary> variants) {
        this.variants = variants;
    }

    public ArrayList<ComicSummary> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<ComicSummary> collections) {
        this.collections = collections;
    }

    public ArrayList<ComicSummary> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(ArrayList<ComicSummary> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public ArrayList<ComicDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<ComicDate> dates) {
        this.dates = dates;
    }

    public ArrayList<ComicPrice> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<ComicPrice> prices) {
        this.prices = prices;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
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

    public EventList getEvents() {
        return events;
    }

    public void setEvents(EventList events) {
        this.events = events;
    }
}
