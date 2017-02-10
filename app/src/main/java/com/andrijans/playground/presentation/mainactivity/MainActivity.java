package com.andrijans.playground.presentation.mainactivity;

import android.os.Bundle;

import com.andrijans.playground.R;
import com.andrijans.playground.presentation.App;
import com.andrijans.playground.presentation.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    @Inject
    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.onCreate();
    }

    @Override
    protected void injectView() {
        App.getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }
}
