package com.andrijans.playground.presentation.common.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.andrijans.playground.R;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.common.adapters.MediaListAdapter;
import com.andrijans.playground.presentation.common.views.adapters.PagingRecyclerOnScrollListener;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MediaListView extends RelativeLayout implements MediaContract.View {
    @BindView (R.id.rv_shows) RecyclerView mRvShows;

    MediaContract.Presenter presenter;
    MediaListAdapter adapter;

    public MediaListView(Context context) {
        super(context);
        initView();
    }

    public MediaListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MediaListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @RequiresApi (api = Build.VERSION_CODES.LOLLIPOP)
    public MediaListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.view_shows_list, this, true);
        ButterKnife.bind(v);
    }

    @Override
    public void bindPresenter(MediaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setData(List<MediaItemDetails> data) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mRvShows.setLayoutManager(layoutManager);
        mRvShows.addOnScrollListener(new PagingRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                presenter.loadMore(currentPage);
            }
        });
        adapter = new MediaListAdapter(presenter, data);
        mRvShows.setAdapter(adapter);

    }

    @Override
    public void appendData(List<MediaItemDetails> data) {
        adapter.appendData(data);
    }
}
