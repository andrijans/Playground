package com.andrijans.playground.presentation.showslist;

import com.andrijans.playground.framework.api.IApiService;
import com.andrijans.playground.framework.api.interactor.SubscriptionBag;
import com.andrijans.playground.presentation.common.contract.MediaContract;

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
}
