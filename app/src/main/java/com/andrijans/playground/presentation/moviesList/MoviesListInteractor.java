package com.andrijans.playground.presentation.moviesList;

import com.andrijans.playground.framework.api.IApiService;
import com.andrijans.playground.framework.api.entity.MediaItemDetails;
import com.andrijans.playground.framework.api.interactor.BaseInteractor;
import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.interactor.SubscriptionBag;
import com.andrijans.playground.framework.contract.ILogger;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MoviesListInteractor extends BaseInteractor implements MediaContract.MoviesInteractor {

    @Inject
    public MoviesListInteractor(IApiService apiService, ILogger logger, SubscriptionBag subscriptionBag) {
        super(apiService, logger, subscriptionBag);
    }

    @Override
    public void getNowPlayingMovies(int page, Listener<List<MediaItemDetails>> listener) {
        applyMapErrorAndSubscribe(apiService.getNowPlaying(page), listener);
    }

}
