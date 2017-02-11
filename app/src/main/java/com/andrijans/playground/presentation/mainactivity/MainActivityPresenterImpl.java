package com.andrijans.playground.presentation.mainactivity;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.ListMoviesResult;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public class MainActivityPresenterImpl implements MainActivityContract.Presenter {
    MainActivityContract.View view;
    MainActivityContract.Interactor interactor;

    public MainActivityPresenterImpl(MainActivityContract.View view, MainActivityContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        interactor.getNowPlayingMovies(new Listener<ListMoviesResult>() {
            @Override
            public void onNext(ListMoviesResult value) {
                super.onNext(value);
            }
        });
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
    public void navigationItemClicked(int position) {
        switch (position) {
            case 0:
                view.setSelectedNavigationPosition(position);
                view.navigateToMovies();
                break;
            case 1:
                view.setSelectedNavigationPosition(position);
                view.navigateToShows();
                break;
        }
    }
}
