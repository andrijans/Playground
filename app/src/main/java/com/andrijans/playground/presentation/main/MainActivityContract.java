package com.andrijans.playground.presentation.main;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.ListMediaResult;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.common.contract.IBaseInteractor;
import com.andrijans.playground.presentation.common.contract.IBasePresenter;
import com.andrijans.playground.presentation.common.contract.IBaseView;
import com.andrijans.playground.presentation.common.contract.MediaContract;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public class MainActivityContract {
    public interface View extends IBaseView {
        void navigateToMovies();
        void navigateToShows();
        void setSelectedNavigationPosition(int position);
        void navigateToDetailsScreen(MediaItemDetails details, boolean shouldFinish);
    }

    public interface Presenter extends IBasePresenter {
        void navigationItemClicked(int position);
        void bindChildPresenters(MediaContract.MoviesPresenter moviesPresenter, MediaContract.ShowsPresenter showsPresenter);

    }

    public interface Interactor extends IBaseInteractor {
        void getNowPlayingMovies(Listener<ListMediaResult> listener);
    }
}
