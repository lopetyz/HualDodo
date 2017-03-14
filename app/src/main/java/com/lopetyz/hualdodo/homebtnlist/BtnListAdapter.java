package com.lopetyz.hualdodo.homebtnlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lopetyz.hualdodo.BR;
import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.databinding.BtnItemBinding;

import java.util.List;

/**
 * Created by lopetyz on 2017/3/14.
 */

public class BtnListAdapter extends RecyclerView.Adapter<BtnListAdapter.BtnItemHolder<BtnItemBinding>> {

    private LayoutInflater mInflater;
    private List<BtnItem> mItemList;

    public BtnListAdapter(Context context, List<BtnItem> itemList) {
        mItemList = itemList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public BtnItemHolder<BtnItemBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        BtnItemBinding binding;
        binding = DataBindingUtil.inflate(mInflater, R.layout.btn_item, parent, false);
        return new BtnItemHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(BtnItemHolder<BtnItemBinding> holder, int position) {
        BtnItem item = mItemList.get(position);
        holder.getBinding().setVariable(BR.btnItem, item);
//        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class BtnItemHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private T mBinding;

        BtnItemHolder(T binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        T getBinding() {
            return mBinding;
        }
    }
}
