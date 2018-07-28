package com.lopetyz.hualdodo.homebtnlist;

import android.content.Context;

import com.lopetyz.hualdodo.activity.LifeCycleActivity;
import com.lopetyz.hualdodo.activity.RetrofitActivity;
import com.lopetyz.hualdodo.activity.RxLearningActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lopetyz on 2017/3/14.
 */

public class BtnListManager {

    private Context mContext;

    private List<BtnItem> mBtnItemList;

    public BtnListManager(Context context) {
        mContext = context;
        init();
    }

    private void init() {
        mBtnItemList = new ArrayList<>();
        mBtnItemList.add(new BtnItem(mContext, RxLearningActivity.class));
        mBtnItemList.add(new BtnItem(mContext, RetrofitActivity.class));
        mBtnItemList.add(new BtnItem(mContext, LifeCycleActivity.class));
    }

    public List<BtnItem> getBtnItemList() {
        return mBtnItemList;
    }
}
