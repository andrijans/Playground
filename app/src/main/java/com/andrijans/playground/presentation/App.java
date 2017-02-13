package com.andrijans.playground.presentation;

import android.app.Application;
import android.content.Context;

import com.andrijans.playground.presentation.common.di.AppComponent;
import com.andrijans.playground.presentation.common.di.AppModule;
import com.andrijans.playground.presentation.common.di.DaggerAppComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public class App extends Application {
    private static AppComponent appComponent;
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        app = this;
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App get(Context context) {
        if (context != null) return (App) context.getApplicationContext();
        else return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
