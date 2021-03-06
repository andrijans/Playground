package com.andrijans.playground.presentation.detail;

import com.andrijans.playground.framework.api.entity.Genre;
import com.andrijans.playground.framework.api.entity.GenreResult;
import com.andrijans.playground.framework.api.entity.MediaItemDetails;
import com.andrijans.playground.presentation.common.constants.Constants;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by andrijanstankovic on 12/02/2017.
 */

public class DetailsActivityPresenterImpl implements DetailsActivityContract.Presenter {
    private DetailsActivityContract.View view;
    private MediaItemDetails data;
    private GenreResult genres = new Gson().fromJson(Constants.GENRES, GenreResult.class);

    public DetailsActivityPresenterImpl(DetailsActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.setMediaTitle(data.getTitle());
        view.setBackdropImage(data.getBackdropPath());
        view.setOverviewText(data.getOverview());

        String genres = getGenreString(data.getGenreIds()).toString();
        view.setGenres(genres);

        view.setMediaRating(String.valueOf(data.getVoteAverage()));
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindModel(MediaItemDetails data) {
        this.data = data;
    }

    @Override
    public void navigationBackButtonClicked() {
        view.closeScreen();
    }

    private StringBuilder getGenreString(List<Integer> genreList) {
        StringBuilder genreTxt = new StringBuilder();
        if (!genreList.isEmpty()) {
            for (Integer id : genreList) {
                for (Genre genre : genres.getGenreList()) {
                    if (id.equals(genre.getId())) {
                        if (genreTxt.toString().equals("")) {
                            genreTxt.append(genre.getName());
                        } else {
                            genreTxt.append(" | ").append(genre.getName());
                        }
                    }
                }
            }
        }
        return genreTxt;
    }
}
