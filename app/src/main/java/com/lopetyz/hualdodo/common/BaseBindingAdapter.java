package com.lopetyz.hualdodo.common;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lopetyz on 2017/6/24.
 */

public abstract class BaseBindingAdapter<T extends ViewDataBinding, V> extends RecyclerView.Adapter<BindingViewHolder<T>> {

    protected List<V> mDatas;
    private LayoutInflater mInflater;

    public BaseBindingAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public abstract @LayoutRes int getLayoutResId();

    @Override
    public BindingViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        T binding = DataBindingUtil.inflate(mInflater, getLayoutResId(), parent, false);
        return new BindingViewHolder<>(binding);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
