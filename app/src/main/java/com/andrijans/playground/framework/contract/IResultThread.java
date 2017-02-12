package com.andrijans.playground.framework.contract;

import io.reactivex.Scheduler;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public interface IResultThread {
    Scheduler getScheduler();
}
