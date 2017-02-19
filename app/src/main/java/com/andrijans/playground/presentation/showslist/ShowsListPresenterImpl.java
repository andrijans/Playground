package com.andrijans.playground.presentation.showslist;

import com.andrijans.playground.framework.api.interactor.Listener;
import com.andrijans.playground.framework.api.entity.ListMediaResult;
import com.andrijans.playground.framework.api.entity.MediaItemDetails;
import com.andrijans.playground.framework.contract.ILogger;
import com.andrijans.playground.presentation.common.contract.IMediaClickListener;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class ShowsListPresenterImpl implements MediaContract.ShowsPresenter {
    private MediaContract.View view;
    private MediaContract.ShowsInteractor interactor;
    private ILogger logger;
    private IMediaClickListener mediaClickListener;
    private List<MediaItemDetails> data = new ArrayList<>();
    private int currentPage = 1;

    public ShowsListPresenterImpl(ILogger logger, MediaContract.ShowsInteractor interactor) {
        this.interactor = interactor;
        this.logger = logger;
    }

    @Override
    public void onCreate() {
        interactor.getPopularShows(currentPage, new Listener<List<MediaItemDetails>>() {
            @Override
            public void onNext(List<MediaItemDetails> value) {
                addMediaType(value);
                data = value;
                view.setData(data);
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

    @Override
    public void loadMore(int currentPage) {
        this.currentPage = currentPage;
        interactor.getPopularShows(this.currentPage, new Listener<List<MediaItemDetails>>() {
            @Override
            public void onNext(List<MediaItemDetails> value) {
                addMediaType(value);
                data.addAll(value);
                view.appendData(value);
            }
        });
    }

    private List<MediaItemDetails> addMediaType(List<MediaItemDetails> data){
        for (MediaItemDetails details:data){details.setType(MediaItemDetails.Type.Series);}
        return data;
    }
}
