package com.andrijans.playground.presentation.common.contract;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.BaseModel;
import com.andrijans.playground.framework.api.model.ListMoviesResult;

import java.util.List;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MediaContract {
    public interface View extends IBaseView {
        void bindPresenter(MediaContract.Presenter presenter);
        void setData(List<BaseModel> data);
    }

    public interface Presenter extends IBasePresenter {
        void bindView(MediaContract.View view);
    }

    public interface ShowsInteractor extends IBaseInteractor{}

    public interface MoviesInteractor extends IBaseInteractor{
        void getNowPlayingMovies(Listener<ListMoviesResult> listener);
    }
}
