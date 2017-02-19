package com.andrijans.playground.framework.api.interactor;

import com.andrijans.playground.framework.api.IApiService;
import com.andrijans.playground.framework.api.entity.common.ListResult;
import com.andrijans.playground.framework.contract.ILogger;
import com.andrijans.playground.presentation.common.contract.IBaseInteractor;

import io.reactivex.Observable;

/**
 * Created by andrijanstankovic on 19/02/2017.
 */

public abstract class BaseInteractor implements IBaseInteractor {
    protected IApiService apiService;
    protected ILogger logger;
    protected SubscriptionBag subscriptionBag;

    public BaseInteractor(IApiService apiService, ILogger logger, SubscriptionBag subscriptionBag) {
        this.apiService = apiService;
        this.logger = logger;
        this.subscriptionBag = subscriptionBag;
    }

    protected <T> Observable addMapAndError(Observable<? extends ListResult<T>> observable) {
        return observable
                .doOnError(error -> logger.e(error))
                .map(ListResult::getResults);
    }

    protected <T> Observable addError(Observable<T> observable) {
        return observable
                .doOnError(error -> logger.e(error));
    }

    protected <T> void applyErrorAndSubscribe(Observable<T> observable, Listener<T> listener) {
        subscriptionBag.add(addError(observable), listener);
    }

    protected <T> void applyMapErrorAndSubscribe(Observable<? extends ListResult<T>> observable, Listener<T> listener) {
        subscriptionBag.add(addMapAndError(observable), listener);
    }

    @Override
    public void unsubscribe() {
        subscriptionBag.unsubscribe();
    }
}
