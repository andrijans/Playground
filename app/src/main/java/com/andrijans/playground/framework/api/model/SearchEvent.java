package com.andrijans.playground.framework.api.model;

public class SearchEvent {
    private String query;

    public SearchEvent(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}