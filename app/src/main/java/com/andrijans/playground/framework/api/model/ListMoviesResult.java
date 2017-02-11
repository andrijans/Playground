package com.andrijans.playground.framework.api.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrijanstankovic on 10/02/2017.
 */

public class ListMoviesResult {
    private List<BaseModel> results=new ArrayList<>();

    public List<BaseModel> getResults() {
        return results;
    }

    public void setResults(List<BaseModel> results) {
        this.results = results;
    }
}
