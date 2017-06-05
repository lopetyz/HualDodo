package com.lopetyz.hualdodo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Hualei on 2017/6/5.
 */

public class HualApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
