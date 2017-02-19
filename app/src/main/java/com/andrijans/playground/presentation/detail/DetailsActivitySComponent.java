package com.andrijans.playground.presentation.detail;

import com.andrijans.playground.presentation.common.di.ViewScope;

import dagger.Subcomponent;

/**
 * Created by andrijanstankovic on 12/02/2017.
 */
@ViewScope
@Subcomponent(modules = {DetailsActivityModule.class})
public interface DetailsActivitySComponent {
    DetailsActivity inject(DetailsActivity activity);
}
