package com.andrijans.playground.presentation.main;

import com.andrijans.playground.framework.contract.ILogger;
import com.andrijans.playground.presentation.common.contract.MediaContract;
import com.andrijans.playground.presentation.common.di.ViewScope;
import com.andrijans.playground.presentation.moviesList.MoviesListInteractor;
import com.andrijans.playground.presentation.moviesList.MoviesListPresenterImpl;
import com.andrijans.playground.presentation.showslist.ShowsListInteractor;
import com.andrijans.playground.presentation.showslist.ShowsListPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */
@Module
public class MainActivityModule {
    private MainActivityContract.View view;

    public MainActivityModule(MainActivityContract.View view) {
        this.view = view;
    }

    @ViewScope
    @Provides
    MainActivityContract.View provideView() {
        return view;
    }

    @ViewScope
    @Provides
    MainActivityContract.Presenter provideMainActivityPresenter(MainActivityInteractor interactor) {
        return new MainActivityPresenterImpl(view, interactor);
    }

    @ViewScope
    @Provides
    MediaContract.ShowsPresenter provideShowsListPresenter(ILogger logger, MediaContract.ShowsInteractor interactor) {
        return new ShowsListPresenterImpl(logger,interactor);
    }

    @ViewScope
    @Provides
    MediaContract.MoviesPresenter provideMoviesListPresenter(ILogger logger,MediaContract.MoviesInteractor interactor) {
        return new MoviesListPresenterImpl(logger,interactor);
    }

    @ViewScope
    @Provides
    MediaContract.ShowsInteractor provideShowsListInteractor(ShowsListInteractor interactor) {
        return interactor;
    }

    @ViewScope
    @Provides
    MediaContract.MoviesInteractor provideMoviesInteractor(MoviesListInteractor interactor) {
        return interactor;
    }
}
