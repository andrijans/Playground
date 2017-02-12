package com.andrijans.playground.presentation.main;

import com.andrijans.playground.framework.api.IApiService;
import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.interactor.SubscriptionBag;
import com.andrijans.playground.framework.api.model.ListMediaResult;

import javax.inject.Inject;

/**
 * Created by andrijanstankovic on 10/02/2017.
 */

public class MainActivityInteractor implements MainActivityContract.Interactor {
    protected SubscriptionBag subscriptionBag;
    protected IApiService apiService;

    @Inject
    public MainActivityInteractor(SubscriptionBag subscriptionBag, IApiService apiService) {
        this.subscriptionBag = subscriptionBag;
        this.apiService = apiService;
    }


    @Override
    public void getNowPlayingMovies(Listener<ListMediaResult> listener) {
        subscriptionBag.add(apiService.getNowPlaying(),listener);
    }

    @Override
    public void unsubscribe() {
        subscriptionBag.unsubscribe();
    }
}
