package com.andrijans.playground.presentation.showslist;

import com.andrijans.playground.framework.api.IApiService;
import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.interactor.SubscriptionBag;
import com.andrijans.playground.framework.api.model.ListMediaResult;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

import javax.inject.Inject;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class ShowsListInteractor implements MediaContract.ShowsInteractor {
    private SubscriptionBag subscriptionBag;
    private IApiService apiService;

    @Inject
    public ShowsListInteractor(SubscriptionBag subscriptionBag, IApiService apiService) {
        this.subscriptionBag = subscriptionBag;
        this.apiService = apiService;
    }

    @Override
    public void unsubscribe() {
        subscriptionBag.unsubscribe();
    }

    @Override
    public void getPopularShows(Listener<ListMediaResult> listener) {
        subscriptionBag.add(apiService.getPopularShows(),listener);
    }
}
