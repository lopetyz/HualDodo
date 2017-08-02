package com.lopetyz.hualdodo.homebtnlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.lopetyz.hualdodo.activity.CustomViewActivity;
import com.lopetyz.hualdodo.activity.RealmLearningActivity;
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
        mBtnItemList.add(new BtnItem(mContext, RxLearningActivity.class, "RxLearningActivity"));
        mBtnItemList.add(new BtnItem(mContext, CustomViewActivity.class, "CustomViewActivity"));
        mBtnItemList.add(new BtnItem(mContext, RealmLearningActivity.class, "RealmLearningActivity"));
        mBtnItemList.add(new BtnItem(mContext, RetrofitActivity.class, "RetrofitActivity"));
    }

    public List<BtnItem> getBtnItemList() {
        return mBtnItemList;
    }
}
