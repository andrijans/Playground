package com.andrijans.playground.framework.api.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrijanstankovic on 10/02/2017.
 */

public class ListMediaResult {
    private List<MediaItemDetails> results=new ArrayList<>();

    public List<MediaItemDetails> getResults() {
        return results;
    }

    public void setResults(List<MediaItemDetails> results) {
        this.results = results;
    }
}
