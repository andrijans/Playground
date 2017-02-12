package com.andrijans.playground.presentation.main;

import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.common.contract.IMediaClickListener;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public class MainActivityPresenterImpl implements MainActivityContract.Presenter, IMediaClickListener {
    MainActivityContract.View view;
    MediaContract.MoviesPresenter moviesPresenter;
    MediaContract.ShowsPresenter showsPresenter;

    public MainActivityPresenterImpl(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

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

    @Override
    public void bindChildPresenters(MediaContract.MoviesPresenter moviesPresenter, MediaContract.ShowsPresenter showsPresenter) {
        this.moviesPresenter = moviesPresenter;
        this.showsPresenter = showsPresenter;
        this.moviesPresenter.addMediaClickListener(this);
        this.showsPresenter.addMediaClickListener(this);
    }

    @Override
    public void mediaItemClicked(MediaItemDetails data) {
        view.navigateToDetailsScreen(data, false);
    }
}
