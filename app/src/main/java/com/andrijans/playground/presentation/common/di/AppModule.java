package com.andrijans.playground.presentation.common.di;

import android.app.Application;

import com.andrijans.playground.domain.abstraction.IOThread;
import com.andrijans.playground.domain.abstraction.IResultThread;
import com.andrijans.playground.domain.abstraction.IWorkerThread;
import com.andrijans.playground.domain.abstraction.UIThread;
import com.andrijans.playground.framework.api.interactor.SubscriptionBag;
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

    @Provides
    @Singleton
    Application getApplication() {
        return app;
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }


    @Provides
    @Singleton
    IWorkerThread provideWorkerThread() {
        return new IOThread();
    }

    @Provides
    @Singleton
    IResultThread provideResultThread() {
        return new UIThread();
    }

    @Provides
    SubscriptionBag provideInteractorSubscription(IWorkerThread workerThread, IResultThread resultThread) {
        return new SubscriptionBag(workerThread, resultThread);
    }
}
