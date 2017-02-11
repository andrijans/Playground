package com.andrijans.playground.presentation.common.di;

import com.andrijans.playground.framework.api.ApiModule;
import com.andrijans.playground.framework.api.AuthenticationInterceptor;
import com.andrijans.playground.presentation.mainactivity.MainActivityModule;
import com.andrijans.playground.presentation.mainactivity.MainActivitySComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */
@Singleton
@Component (modules = {
        AppModule.class,
        ApiModule.class})
public interface AppComponent {
    MainActivitySComponent plus(MainActivityModule module);

    AuthenticationInterceptor inject(AuthenticationInterceptor authenticationInterceptor);
}
