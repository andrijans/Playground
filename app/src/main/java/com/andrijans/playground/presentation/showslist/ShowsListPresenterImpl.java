package com.andrijans.playground.presentation.showslist;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.ListMoviesResult;
import com.andrijans.playground.presentation.common.contract.MediaContract;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class ShowsListPresenterImpl implements MediaContract.ShowsPresenter {
    private MediaContract.View view;
    private MediaContract.ShowsInteractor interactor;

    public ShowsListPresenterImpl(MediaContract.ShowsInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        interactor.getPopularShows(new Listener<ListMoviesResult>() {
            @Override
            public void onNext(ListMoviesResult value) {
                view.setData(value.getResults());
            }
        });
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {
        interactor.unsubscribe();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindView(MediaContract.View view) {
        this.view = view;
    }
}
