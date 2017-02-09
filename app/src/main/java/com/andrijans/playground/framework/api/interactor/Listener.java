package com.andrijans.playground.framework.api.interactor;

import io.reactivex.Observer;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public class Listener<T> extends DisposableObserver<T> implements Observer<T> {

    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
