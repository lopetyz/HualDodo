package com.lopetyz.hualdodo;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by lopetyz on 2017/7/15.
 */

public class HualDodoApplication extends MultiDexApplication {
    private static HualDodoApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static Context getAppContex() {
        return sInstance.getApplicationContext();
    }
}
