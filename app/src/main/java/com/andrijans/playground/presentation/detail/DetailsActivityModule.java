package com.andrijans.playground.presentation.detail;

import com.andrijans.playground.presentation.common.di.ViewScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrijanstankovic on 12/02/2017.
 */
@Module
public class DetailsActivityModule {
    private DetailsActivityContract.View view;

    public DetailsActivityModule(DetailsActivityContract.View view) {
        this.view = view;
    }

    @ViewScope
    @Provides
    DetailsActivityContract.View provideView(){return view;}

    @ViewScope
    @Provides
    DetailsActivityContract.Presenter providePresenter(){return new DetailsActivityPresenterImpl(view);}
}
