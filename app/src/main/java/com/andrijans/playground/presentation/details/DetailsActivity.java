package com.andrijans.playground.presentation.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.andrijans.playground.R;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.App;
import com.andrijans.playground.presentation.BaseActivity;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity implements DetailsActivityContract.View {
    private static final String MEDIA_ITEM_INTENT_KEY = "MEDIA_ITEM_KEY";
    @Inject
    DetailsActivityContract.Presenter presenter;

    public static Intent getCallingIntent(Context context, MediaItemDetails data) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(MEDIA_ITEM_INTENT_KEY, data);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter.bindModel((MediaItemDetails) getIntent().getSerializableExtra(MEDIA_ITEM_INTENT_KEY));
        presenter.onCreate();
    }

    @Override
    protected void injectView() {
        App.get(this)
                .getAppComponent()
                .plus(new DetailsActivityModule(this))
                .inject(this);
    }

}
