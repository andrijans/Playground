package com.andrijans.playground.presentation.common.contract;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.BaseModel;
import com.andrijans.playground.framework.api.model.ListMediaResult;
import com.andrijans.playground.framework.api.model.MediaItemDetails;

import java.util.List;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MediaContract {
    public interface View extends IBaseView {
        void bindPresenter(MediaContract.Presenter presenter);
        void setData(List<MediaItemDetails> data);
    }

    public interface Presenter extends IBasePresenter {
        void bindView(MediaContract.View view);
        void addMediaClickListener(IMediaClickListener mediaClickListener);
        void mediaItemClicked(MediaItemDetails details);
    }

    public interface MoviesPresenter extends Presenter{}

    public interface ShowsPresenter extends Presenter{}

    public interface ShowsInteractor extends IBaseInteractor{
        void getPopularShows(Listener<ListMediaResult> listener);
    }

    public interface MoviesInteractor extends IBaseInteractor{
        void getNowPlayingMovies(Listener<ListMediaResult> listener);
    }
}
