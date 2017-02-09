package com.andrijans.playground.presentation.common.contract;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public interface IBasePresenter {
    void onCreate();
    void onResume();
    void onPause();
    void onDestroy();
}
