package com.andrijans.playground.presentation.common.di;

import android.app.Application;

import com.andrijans.playground.framework.api.interactor.SubscriptionBag;
import com.andrijans.playground.framework.contract.ILogger;
import com.andrijans.playground.framework.contract.IResultThread;
import com.andrijans.playground.framework.contract.IWorkerThread;
import com.andrijans.playground.framework.monitoring.Logger;
import com.andrijans.playground.presentation.Navigator;
import com.andrijans.playground.presentation.common.executors.IOThread;
import com.andrijans.playground.presentation.common.executors.UIThread;

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
    ILogger provideLogger() {
        return new Logger();
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
