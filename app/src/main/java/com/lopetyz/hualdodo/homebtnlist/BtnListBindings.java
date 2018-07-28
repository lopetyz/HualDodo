package com.lopetyz.hualdodo.homebtnlist;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class BtnListBindings {

    @SuppressWarnings("unchecked")
    @BindingAdapter("app:items")
    public static void setItems(RecyclerView recyclerView, List<BtnItem> items) {
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        BtnListAdapter adapter = (BtnListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.replaceData(items);
        }
    }
}
