package com.andrijans.playground.framework.api.model;

import com.google.gson.annotations.SerializedName;

public class Cast {
    @SerializedName ("cast_id")
    private Integer castId;
    @SerializedName ("character")
    private String character;
    @SerializedName ("credit_id")
    private String creditId;
    @SerializedName ("id")
    private Integer id;
    @SerializedName ("name")
    private String name;
    @SerializedName ("order")
    private Integer order;

    public Integer getCastId() {
        return castId;
    }

    public void setCastId(Integer castId) {
        this.castId = castId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}