package com.andrijans.playground.framework.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GenreResult {
    @SerializedName ("genres")
    private List<Genre> genreList = new ArrayList<>();

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}