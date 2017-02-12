package com.andrijans.playground.presentation.common.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andrijans.playground.R;
import com.andrijans.playground.framework.api.model.BaseModel;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.common.contract.MediaContract;
import com.andrijans.playground.presentation.common.utils.Utils;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class MediaListAdapter extends RecyclerView.Adapter<MediaListAdapter.ViewHolder> {
    private Context context;
    private List<MediaItemDetails> data;
    private MediaContract.Presenter presenter;

    public MediaListAdapter(MediaContract.Presenter presenter, List<MediaItemDetails> data) {
        this.data = data;
        this.presenter=presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.item_media, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(Utils.getPosterUri(data.get(position).getPosterPath())).into(holder.mIvPoster);
        holder.mIvPoster.setOnClickListener(view -> presenter.mediaItemClicked(data.get(position)));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView (R.id.iv_poster) ImageView mIvPoster;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
