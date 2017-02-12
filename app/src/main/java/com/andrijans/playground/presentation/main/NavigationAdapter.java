package com.andrijans.playground.presentation.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrijans.playground.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ItemViewHolder> {
    Context context;
    String[] titles;
    MainActivityContract.Presenter presenter;
    private int selectedPosition = 0;

    public NavigationAdapter(MainActivityContract.Presenter presenter, String[] titles) {
        this.presenter = presenter;
        this.titles = titles;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.mTitle.setText(titles[position]);
        holder.setPosition(position);
        if (position == selectedPosition) {
            holder.mTitle.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        } else {
            holder.mTitle.setTextColor(context.getResources().getColor(R.color.textPrimaryDark));
        }
    }

    public void setSelectedPosition(int selectedPosition) {
        int previousSelected = this.selectedPosition;
        this.selectedPosition = selectedPosition;
        notifyItemChanged(previousSelected);
        notifyItemChanged(selectedPosition);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private int position;
        @BindView (R.id.tv_title) TextView mTitle;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @OnClick (R.id.ll_root)
        void doClick() {
            presenter.navigationItemClicked(position);
        }
    }
}
