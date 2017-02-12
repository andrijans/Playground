package com.andrijans.playground.presentation.details;

import com.andrijans.playground.framework.api.model.MediaItemDetails;

/**
 * Created by andrijanstankovic on 12/02/2017.
 */

public class DetailsActivityPresenterImpl implements DetailsActivityContract.Presenter{
    private DetailsActivityContract.View view;
    private MediaItemDetails data;

    public DetailsActivityPresenterImpl(DetailsActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindModel(MediaItemDetails data) {
        this.data=data;
    }
}
