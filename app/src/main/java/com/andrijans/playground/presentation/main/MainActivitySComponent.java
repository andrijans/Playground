package com.andrijans.playground.presentation.main;

import com.andrijans.playground.presentation.common.di.ViewScope;

import dagger.Subcomponent;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */
@ViewScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySComponent {
    MainActivity inject(MainActivity activity);
}
