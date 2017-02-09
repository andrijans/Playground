package com.andrijans.playground.presentation.mainactivity;

import com.andrijans.playground.presentation.common.di.ViewScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */
@Module
public class MainActivityModule {
    private MainActivityContract.View view;

    public MainActivityModule(MainActivityContract.View view) {
        this.view = view;
    }

    @ViewScope
    @Provides
    MainActivityContract.View provideView() {
        return view;
    }

    @ViewScope
    @Provides
    MainActivityContract.Presenter provideMainActivityPresenter(){return new MainActivityPresenterImpl(view);}
}
