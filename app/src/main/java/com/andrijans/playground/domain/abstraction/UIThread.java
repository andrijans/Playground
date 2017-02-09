package com.andrijans.playground.domain.abstraction;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public class UIThread implements IResultThread {
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
