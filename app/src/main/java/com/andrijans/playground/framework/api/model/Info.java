package com.andrijans.playground.framework.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Info implements Serializable {
    @SerializedName ("patch")
    private String patch;
    @SerializedName ("classes")
    private List<String> classes = new ArrayList<>();
    @SerializedName ("sets")
    private List<String> sets = new ArrayList<>();
    @SerializedName ("types")
    private List<String> types = new ArrayList<>();
    @SerializedName ("factions")
    private List<String> factions = new ArrayList<>();
    @SerializedName ("qualities")
    private List<String> qualities = new ArrayList<>();
    @SerializedName ("races")
    private List<String> races = new ArrayList<>();
    @SerializedName ("locales")
    private List<String> locales = new ArrayList<>();

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public List<String> getSets() {
        return sets;
    }

    public void setSets(List<String> sets) {
        this.sets = sets;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getFactions() {
        return factions;
    }

    public void setFactions(List<String> factions) {
        this.factions = factions;
    }

    public List<String> getQualities() {
        return qualities;
    }

    public void setQualities(List<String> qualities) {
        this.qualities = qualities;
    }

    public List<String> getRaces() {
        return races;
    }

    public void setRaces(List<String> races) {
        this.races = races;
    }

    public List<String> getLocales() {
        return locales;
    }

    public void setLocales(List<String> locales) {
        this.locales = locales;
    }
}