package com.andrijans.playground.presentation.mainactivity;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.ListMoviesResult;
import com.andrijans.playground.presentation.common.contract.IBaseInteractor;
import com.andrijans.playground.presentation.common.contract.IBasePresenter;
import com.andrijans.playground.presentation.common.contract.IBaseView;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public class MainActivityContract {
    public interface View extends IBaseView {
        void navigateToMovies();
        void navigateToShows();
        void setSelectedNavigationPosition(int position);
    }

    public interface Presenter extends IBasePresenter {
        void navigationItemClicked(int position);

    }

    public interface Interactor extends IBaseInteractor {
        void getNowPlayingMovies(Listener<ListMoviesResult> listener);
    }
}
