package com.andrijans.playground.presentation.common.executors;

import com.andrijans.playground.framework.contract.IResultThread;

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
