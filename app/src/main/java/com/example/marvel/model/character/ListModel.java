package com.example.marvel.model.character;

import java.io.Serializable;
import java.util.ArrayList;

public class ListModel implements Serializable {


    private int available;
    private int returned;
    private String collectionURI;
    private ArrayList<SummaryModel> items;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public ArrayList<SummaryModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<SummaryModel> items) {
        this.items = items;
    }
}
