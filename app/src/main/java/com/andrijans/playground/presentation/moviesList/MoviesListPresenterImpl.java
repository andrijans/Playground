package com.andrijans.playground.presentation.moviesList;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.ListMoviesResult;
import com.andrijans.playground.presentation.common.contract.MediaContract;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MoviesListPresenterImpl implements MediaContract.Presenter {
    MediaContract.View view;
    MediaContract.MoviesInteractor interactor;

    public MoviesListPresenterImpl(MediaContract.MoviesInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void bindView(MediaContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        interactor.getNowPlayingMovies(new Listener<ListMoviesResult>() {
            @Override
            public void onNext(ListMoviesResult value) {
                view.setData(value.getResults());
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
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
}
