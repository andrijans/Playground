package com.andrijans.playground.framework.api.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CastResult {
    @SerializedName ("id")
    private Integer id;
    @SerializedName("cast")
    private List<Cast> cast = new ArrayList<Cast>();

    public List<Cast> getCast() {
        return cast;
    }
}