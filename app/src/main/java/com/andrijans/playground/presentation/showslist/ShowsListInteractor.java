package com.andrijans.playground.presentation.showslist;

import com.andrijans.playground.framework.api.IApiService;
import com.andrijans.playground.framework.api.entity.ListMediaResult;
import com.andrijans.playground.framework.api.entity.MediaItemDetails;
import com.andrijans.playground.framework.api.entity.common.ListResult;
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

public class ShowsListInteractor extends BaseInteractor implements MediaContract.ShowsInteractor {

    @Inject
    public ShowsListInteractor(IApiService apiService, ILogger logger, SubscriptionBag subscriptionBag) {
        super(apiService, logger, subscriptionBag);
    }

    @Override
    public void getPopularShows(int page, Listener<List<MediaItemDetails>> listener) {
        applyMapErrorAndSubscribe(apiService.getPopularShows(page),listener);
    }
}
