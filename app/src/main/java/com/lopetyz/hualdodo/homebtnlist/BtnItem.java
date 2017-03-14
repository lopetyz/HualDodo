package com.lopetyz.hualdodo.homebtnlist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by lopetyz on 2017/3/14.
 */

public class BtnItem {

    private Context mContext;
    private Class mClass;
    private String mButtonName;

    public BtnItem(Context context, Class cls, String buttonName) {
        mContext = context;
        mClass = cls;
        mButtonName = buttonName;
    }

    public String getButtonName() {
        return mButtonName;
    }

    public void startActivity() {
        if (mClass ==null) {
            Log.e("hualtest", "NullPointerException: mClass is null");
            return;
        }
        mContext.startActivity(new Intent(mContext, mClass));
    }
}
