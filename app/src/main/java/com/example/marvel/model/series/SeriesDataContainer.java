package com.example.marvel.model.series;


import java.util.ArrayList;

public class SeriesDataContainer {

    private int offset;
    private int limit;
    private int total;
    private int count;
    private ArrayList<Series> results;

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

    public ArrayList<Series> getResults() {
        return results;
    }

    public void setResults(ArrayList<Series> results) {
        this.results = results;
    }
}
