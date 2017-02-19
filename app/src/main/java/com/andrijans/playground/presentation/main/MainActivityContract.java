package com.andrijans.playground.presentation.main;

import com.andrijans.playground.framework.api.entity.MediaItemDetails;
import com.andrijans.playground.presentation.common.contract.IBasePresenter;
import com.andrijans.playground.presentation.common.contract.IBaseView;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

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

}
