package com.lopetyz.hualdodo.lifecyclelearning;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.orhanobut.logger.Logger;

public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        Logger.e("ON_RESUME: connectListener");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        Logger.e("ON_PAUSE: disconnectListener");
    }

}
