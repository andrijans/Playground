package com.andrijans.playground.presentation.common.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrijans.playground.R;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.common.utils.Utils;
import com.andrijans.playground.presentation.common.views.contracts.MediaContract;
import com.facebook.drawee.view.SimpleDraweeView;

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
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.item_media, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mIvPoster.setImageURI(Utils.getPosterUri(data.get(position).getPosterPath()));
        holder.mIvPoster.setOnClickListener(view -> presenter.mediaItemClicked(data.get(position)));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView (R.id.iv_poster) SimpleDraweeView mIvPoster;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
