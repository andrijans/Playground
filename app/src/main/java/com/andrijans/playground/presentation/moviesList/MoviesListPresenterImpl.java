package com.andrijans.playground.presentation.moviesList;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.ListMediaResult;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.framework.contract.ILogger;
import com.andrijans.playground.presentation.common.contract.IMediaClickListener;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MoviesListPresenterImpl implements MediaContract.MoviesPresenter {
    private MediaContract.View view;
    private MediaContract.MoviesInteractor interactor;
    private ILogger logger;
    private IMediaClickListener mediaClickListener;
    private List<MediaItemDetails> data = new ArrayList<>();
    private int currentPage = 1;

    public MoviesListPresenterImpl(ILogger logger, MediaContract.MoviesInteractor interactor) {
        this.interactor = interactor;
        this.logger = logger;
    }

    @Override
    public void bindView(MediaContract.View view) {
        this.view = view;
    }

    @Override
    public void addMediaClickListener(IMediaClickListener mediaClickListener) {
        this.mediaClickListener = mediaClickListener;
    }

    @Override
    public void mediaItemClicked(MediaItemDetails details) {
        mediaClickListener.mediaItemClicked(details);
    }

    @Override
    public void loadMore(int currentPage) {
        this.currentPage = currentPage;
        interactor.getNowPlayingMovies(currentPage, new Listener<ListMediaResult>() {
            @Override
            public void onNext(ListMediaResult value) {
                data.addAll(value.getResults());
                view.appendData(value.getResults());
            }

            @Override
            public void onError(Throwable e) {
                logger.e(e);
            }
        });
    }

    @Override
    public void onCreate() {
        interactor.getNowPlayingMovies(currentPage, new Listener<ListMediaResult>() {
            @Override
            public void onNext(ListMediaResult value) {
                data = value.getResults();
                view.setData(data);
            }

            @Override
            public void onError(Throwable e) {
                logger.e(e);
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
