package com.andrijans.playground.presentation.executors;

import com.andrijans.playground.framework.contract.IWorkerThread;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public class IOThread implements IWorkerThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
