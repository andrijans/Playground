package com.andrijans.playground.presentation.common.di;

import android.app.Application;

import com.andrijans.playground.presentation.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */
@Module
public class AppModule {
    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides @Singleton Application getApplication(){return app;}

    @Provides @Singleton Navigator provideNavigator(){return new Navigator();}
}
