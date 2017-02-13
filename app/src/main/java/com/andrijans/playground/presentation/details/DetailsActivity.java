package com.andrijans.playground.presentation.details;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.andrijans.playground.R;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.App;
import com.andrijans.playground.presentation.BaseActivity;
import com.andrijans.playground.presentation.common.utils.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity implements DetailsActivityContract.View {
    private static final String MEDIA_ITEM_INTENT_KEY = "MEDIA_ITEM_KEY";
    @Inject
    DetailsActivityContract.Presenter presenter;
    @BindView (R.id.iv_backdropImage) SimpleDraweeView mIvBackdropImage;
    @BindView (R.id.toolbar) Toolbar mToolbar;
    @BindView (R.id.ctl_collapsingToolbar) CollapsingToolbarLayout mCtlCollapsingToolbar;
    @BindView (R.id.content_details) NestedScrollView mContentDetails;
    @BindView (R.id.genre) TextView mGenre;
    @BindView (R.id.tv_overviewTitle) TextView mTvOverviewTitle;
    @BindView (R.id.tv_overview) TextView mTvOverview;
    @BindView (R.id.btn_rating) FloatingActionButton mBtnRating;

    public static Intent getCallingIntent(Context context, MediaItemDetails data) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(MEDIA_ITEM_INTENT_KEY, data);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
       initToolbar();

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

    @Override
    public void setBackdropImage(String imageUrl) {
        mIvBackdropImage.setImageURI(Utils.getBackdropUri(imageUrl));
    }

    @Override
    public void setMediaTitle(String title) {
        mCtlCollapsingToolbar.setTitle(title);
    }

    @Override
    public void setOverviewText(String text) {
        mTvOverview.setText(text);
    }

    @Override
    public void setGenres(String genres) {
        mGenre.setText(genres);
    }

    @Override
    public void setMediaRating(String rating) {
       mBtnRating.setImageBitmap(Utils.textAsBitmap(rating,40, ContextCompat.getColor(this,R.color.textPrimaryDark)));
    }

    @Override
    public void closeScreen() {
        finish();
    }

    private void initToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(view -> presenter.navigationBackButtonClicked());
    }
}
