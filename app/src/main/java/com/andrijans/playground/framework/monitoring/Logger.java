package com.andrijans.playground.framework.monitoring;

import com.andrijans.playground.framework.contract.ILogger;

import timber.log.Timber;

/**
 * Created by andrijanstankovic on 12/02/2017.
 */

public class Logger implements ILogger {
    public Logger() {
        //Empty
    }

    @Override
    public void d(String message) {
        Timber.d(message);
    }

    @Override
    public void d(Throwable t) {
        Timber.d(t);
    }

    @Override
    public void e(String message) {
        Timber.e(message);
    }

    @Override
    public void e(Throwable t) {
        Timber.e(t);
    }
}
