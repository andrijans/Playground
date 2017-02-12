package com.andrijans.playground.presentation.showslist;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.model.ListMediaResult;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.framework.contract.ILogger;
import com.andrijans.playground.presentation.common.contract.IMediaClickListener;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class ShowsListPresenterImpl implements MediaContract.ShowsPresenter {
    private MediaContract.View view;
    private MediaContract.ShowsInteractor interactor;
    private ILogger logger;
    private IMediaClickListener mediaClickListener;

    public ShowsListPresenterImpl(ILogger logger, MediaContract.ShowsInteractor interactor) {
        this.interactor = interactor;
        this.logger = logger;
    }

    @Override
    public void onCreate() {
        interactor.getPopularShows(new Listener<ListMediaResult>() {
            @Override
            public void onNext(ListMediaResult value) {
                view.setData(value.getResults());
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
}
