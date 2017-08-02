package com.lopetyz.hualdodo.homebtnlist;

import android.content.Context;

import com.lopetyz.hualdodo.BR;
import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.common.BaseBindingAdapter;
import com.lopetyz.hualdodo.common.BindingViewHolder;
import com.lopetyz.hualdodo.databinding.BtnItemBinding;

/**
 * Created by lopetyz on 2017/6/24.
 */

public class BtnListAdapterNew extends BaseBindingAdapter<BtnItemBinding, BtnItem> {

    public BtnListAdapterNew(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        BtnItem item = mDatas.get(position);
        holder.getBinding().setVariable(BR.btnItem, item);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.btn_item;
    }
}
