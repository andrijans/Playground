package com.andrijans.playground.presentation.mainactivity;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public class MainActivityPresenterImpl implements MainActivityContract.Presenter {
    MainActivityContract.View view;

    public MainActivityPresenterImpl(MainActivityContract.View view) {
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
}
