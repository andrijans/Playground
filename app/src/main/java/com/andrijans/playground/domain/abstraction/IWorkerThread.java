package com.andrijans.playground.domain.abstraction;

import io.reactivex.Scheduler;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public interface IWorkerThread {
    Scheduler getScheduler();
}
