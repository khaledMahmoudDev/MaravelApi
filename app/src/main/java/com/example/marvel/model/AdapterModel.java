package com.example.marvel.model;

import com.example.marvel.model.character.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterModel implements Serializable {
    String name;
    String thumbnail;
    ArrayList<Image> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
