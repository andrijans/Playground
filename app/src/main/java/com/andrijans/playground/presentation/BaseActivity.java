package com.andrijans.playground.presentation;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    protected Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectView();
    }

    protected abstract void injectView();
}
