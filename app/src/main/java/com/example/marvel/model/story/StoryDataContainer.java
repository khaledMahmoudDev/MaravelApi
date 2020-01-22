package com.example.marvel.model.story;


import java.util.ArrayList;

public class StoryDataContainer {

    private int offset;
    private int limit;
    private int total;
    private int count;
    private ArrayList<Story> results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Story> getResults() {
        return results;
    }

    public void setResults(ArrayList<Story> results) {
        this.results = results;
    }
}
