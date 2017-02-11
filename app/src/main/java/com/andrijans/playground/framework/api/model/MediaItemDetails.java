package com.andrijans.playground.framework.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MediaItemDetails extends BaseModel implements Serializable {

    public enum Type { Movie, Series}
    private Type type;

    private String overview;
    @SerializedName ("title")
    private String title;
    private int runtime = 0;
    private String tagline;
    private Double popularity;


    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        if (name != null) {
            return name;
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getTagline() {
        return tagline;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<>();

    /** property of series **/
    @SerializedName("name")
    private String name;
    @SerializedName("number_of_episodes")
    private Integer numberOfEpisodes;
    @SerializedName("number_of_seasons")
    private Integer numberOfSeasons;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("last_air_date")
    private String lastAirDate;

    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }
}
