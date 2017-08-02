package com.lopetyz.hualdodo.common.network;

/**
 * Created by lopetyz on 2017/7/25.
 */

public interface OnResponseListener<T> {
    void onSuccess(T object);
    void onError();
}
