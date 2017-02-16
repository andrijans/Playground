package com.andrijans.playground.presentation.moviesList;

import com.andrijans.playground.framework.api.IApiService;
import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.interactor.SubscriptionBag;
import com.andrijans.playground.framework.api.model.ListMediaResult;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

import javax.inject.Inject;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MoviesListInteractor implements MediaContract.MoviesInteractor {
    private SubscriptionBag subscriptionBag;
    private IApiService apiService;

    @Inject
    public MoviesListInteractor(SubscriptionBag subscriptionBag, IApiService apiService) {
        this.subscriptionBag = subscriptionBag;
        this.apiService = apiService;
    }

    @Override
    public void getNowPlayingMovies(int page, Listener<ListMediaResult> listener) {
        subscriptionBag.add(apiService.getNowPlaying(page), listener);
    }

    @Override
    public void unsubscribe() {
        subscriptionBag.unsubscribe();
    }
}
