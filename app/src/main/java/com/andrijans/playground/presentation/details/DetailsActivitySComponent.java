package com.andrijans.playground.presentation.details;

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
