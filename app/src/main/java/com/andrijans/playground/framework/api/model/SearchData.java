package com.andrijans.playground.framework.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SearchData {

    @SerializedName ("page")
    private Integer page;
    @SerializedName("results")
    private List<MediaItemDetails> results = new ArrayList<>();
    @SerializedName("total_results")
    private Integer totalResults;
    @SerializedName("total_pages")
    private Integer totalPages;

    private int moviesTotalPages;
    private int seriesTotalPages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MediaItemDetails> getResults() {
        return results;
    }

    public void setResults(List<MediaItemDetails> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public int getMoviesTotalPages() {
        return moviesTotalPages;
    }

    public void setMoviesTotalPages(int moviesTotalPages) {
        this.moviesTotalPages = moviesTotalPages;
    }

    public int getSeriesTotalPages() {
        return seriesTotalPages;
    }

    public void setSeriesTotalPages(int seriesTotalPages) {
        this.seriesTotalPages = seriesTotalPages;
    }
}