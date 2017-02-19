package com.andrijans.playground.presentation.common.views.contracts;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.entity.ListMediaResult;
import com.andrijans.playground.framework.api.entity.MediaItemDetails;
import com.andrijans.playground.presentation.common.contract.IBaseInteractor;
import com.andrijans.playground.presentation.common.contract.IBasePresenter;
import com.andrijans.playground.presentation.common.contract.IBaseView;
import com.andrijans.playground.presentation.common.contract.IMediaClickListener;

import java.util.List;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MediaContract {
    public interface View extends IBaseView {
        void bindPresenter(MediaContract.Presenter presenter);
        void setData(List<MediaItemDetails> data);
        void appendData(List<MediaItemDetails> data);
    }

    public interface Presenter extends IBasePresenter {
        void bindView(MediaContract.View view);
        void addMediaClickListener(IMediaClickListener mediaClickListener);
        void mediaItemClicked(MediaItemDetails details);
        void loadMore(int currentPage);
    }

    public interface MoviesPresenter extends Presenter{}

    public interface ShowsPresenter extends Presenter{}

    public interface ShowsInteractor extends IBaseInteractor {
        void getPopularShows(int page, Listener<List<MediaItemDetails>> listener);
    }

    public interface MoviesInteractor extends IBaseInteractor{
        void getNowPlayingMovies(int page, Listener<List<MediaItemDetails>> listener);
    }
}
