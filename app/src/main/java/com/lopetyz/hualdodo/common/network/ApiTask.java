package com.lopetyz.hualdodo.common.network;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by lopetyz on 2017/7/25.
 */

public abstract class ApiTask<T> {
    private TypeToken mTypeToken;
    protected Call<T> mCall;

    public ApiTask() {
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        Type type = parameterizedType.getActualTypeArguments()[0];

        mTypeToken = TypeToken.get(type);
    }

    public abstract <V> Call<T> request(V params);

    public void cancel() {
        if (mCall != null && !mCall.isCanceled()) {
            mCall.cancel();
        }
    }

    //inherit to use rx functions
    public <V>Observable<T> requestRx(V params) {
        throw new IllegalArgumentException("eee");
    }

    public TypeToken getTypeToken() {
        return mTypeToken;
    }
}
