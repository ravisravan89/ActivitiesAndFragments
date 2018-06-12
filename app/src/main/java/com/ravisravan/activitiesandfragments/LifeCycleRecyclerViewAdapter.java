package com.ravisravan.activitiesandfragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ravisravankumar on 11/06/18.
 */

public class LifeCycleRecyclerViewAdapter extends RecyclerView.Adapter<LifeCycleRecyclerViewAdapter.LifeCycleViewHolder> {

    private ArrayList<String> lifeCycleMethodNamesArrayList;
    private final long FADE_DURATION = 1500;

    public LifeCycleRecyclerViewAdapter(ArrayList<String> lifeCycleMethodNamesArrayList) {
        this.lifeCycleMethodNamesArrayList = lifeCycleMethodNamesArrayList;
    }
    @Override
    public LifeCycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lifecycle_recycler_itemview, parent, false);

        return new LifeCycleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LifeCycleViewHolder holder, int position) {
        holder.lifecycle_method_tv.setText(lifeCycleMethodNamesArrayList.get(position));
        setScaleAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return lifeCycleMethodNamesArrayList.size();
    }

    public class LifeCycleViewHolder extends RecyclerView.ViewHolder {

        public TextView lifecycle_method_tv;

        public LifeCycleViewHolder(View itemView) {
            super(itemView);
            lifecycle_method_tv = itemView.findViewById(R.id.lifecycle_method_tv);
        }
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }
}
