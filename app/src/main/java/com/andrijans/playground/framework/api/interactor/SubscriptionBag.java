package com.andrijans.playground.framework.api.interactor;

import com.andrijans.playground.framework.contract.IResultThread;
import com.andrijans.playground.framework.contract.IWorkerThread;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public class SubscriptionBag {
    private IWorkerThread workerThread;
    private IResultThread resultThread;
    private CompositeDisposable disposables = new CompositeDisposable();

    public SubscriptionBag(IWorkerThread workerThread, IResultThread resultThread) {
        this.workerThread = workerThread;
        this.resultThread = resultThread;
    }

    public <T> void add(Observable<T> observable, DisposableObserver<T> subscriber) {
        this.disposables.add(observable
                .subscribeOn(workerThread.getScheduler())
                .observeOn(resultThread.getScheduler())
                .subscribeWith(subscriber)
        );
    }

    public void unsubscribe() {
        this.disposables.clear();
    }

    public IWorkerThread getWorkerThread() {
        return workerThread;
    }

    public IResultThread getResultThread() {
        return resultThread;
    }
}
