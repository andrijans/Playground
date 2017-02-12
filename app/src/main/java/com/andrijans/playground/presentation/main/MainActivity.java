package com.andrijans.playground.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andrijans.playground.R;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.App;
import com.andrijans.playground.presentation.BaseActivity;
import com.andrijans.playground.presentation.common.contract.MediaContract;
import com.andrijans.playground.presentation.common.views.MediaListView;
import com.andrijans.playground.presentation.common.views.NonSwipeableViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainActivityContract.View {
    @BindView (R.id.toolbar) Toolbar mToolbar;
    @BindView (R.id.vp_main) NonSwipeableViewPager mVpMain;
    @BindView (R.id.activity_main) RelativeLayout mActivityMain;
    @BindView (R.id.ivProfileImage) ImageView mIvProfileImage;
    @BindView (R.id.tvName) TextView mTvName;
    @BindView (R.id.view) View mView;
    @BindView (R.id.rv_menu) RecyclerView mRvMenu;
    @BindView (R.id.ll_navigation) LinearLayout mLlNavigation;
    @BindView (R.id.drawer_layout) DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationAdapter navigationAdapter;
    private MediaListView moviesListView;
    private MediaListView showsListView;

    @Inject
    MainActivityContract.Presenter presenter;
    @Inject
    MediaContract.MoviesPresenter moviesListPresenter;
    @Inject
    MediaContract.ShowsPresenter showsListPresenter;


    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void injectView() {
        App.get(this).getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initDrawer();

        moviesListView = new MediaListView(this);
        moviesListView.bindPresenter(moviesListPresenter);

        showsListView = new MediaListView(this);
        showsListView.bindPresenter(showsListPresenter);

        moviesListPresenter.bindView(moviesListView);
        showsListPresenter.bindView(showsListView);

        presenter.bindChildPresenters(moviesListPresenter,showsListPresenter);

        mVpMain.setAdapter(new MainPagerAdapter(new View[]{moviesListView, showsListView}));

        presenter.onCreate();
        moviesListPresenter.onCreate();
        showsListPresenter.onCreate();
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        moviesListPresenter.onPause();
        showsListPresenter.onPause();
        super.onPause();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = setupDrawerToggle();
        mDrawerToggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this, R.color.textPrimary));
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void initDrawer() {

        mRvMenu.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        navigationAdapter = new NavigationAdapter(presenter, getResources().getStringArray(R.array.navigation));
        mRvMenu.setAdapter(navigationAdapter);
    }

    private void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void navigateToMovies() {
        mVpMain.setCurrentItem(0);
        closeDrawer();
    }

    @Override
    public void navigateToShows() {
        mVpMain.setCurrentItem(1);
        closeDrawer();
    }

    @Override
    public void setSelectedNavigationPosition(int position) {
        navigationAdapter.setSelectedPosition(position);
    }

    @Override
    public void navigateToDetailsScreen(MediaItemDetails details, boolean shouldFinish) {
        navigator.navigateToDetailsScreen(MainActivity.this,details,shouldFinish);
    }
}
