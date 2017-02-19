package com.andrijans.playground.framework.api.entity;

import com.andrijans.playground.framework.api.entity.common.ListResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrijanstankovic on 10/02/2017.
 */

public class ListMediaResult extends ListResult<List<MediaItemDetails>> {
    private List<MediaItemDetails> results = new ArrayList<>();


    @Override
    public List<MediaItemDetails> getResults() {
        return results;
    }

    @Override
    public void setResults(List<MediaItemDetails> results) {
        this.results = results;
    }
}
