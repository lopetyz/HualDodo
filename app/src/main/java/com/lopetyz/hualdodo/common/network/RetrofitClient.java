package com.lopetyz.hualdodo.common.network;


import com.orhanobut.logger.Logger;

import java.net.ConnectException;
import java.util.LinkedHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by lopetyz on 2017/7/25.
 */

public class RetrofitClient {
    private static LinkedHashMap<String, BaseService> mInstances = new LinkedHashMap<>();
    private static LinkedHashMap<String, Retrofit> mRetrofitMap = new LinkedHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends BaseService> T getInstance(Class<T> subClass) {
        String className = subClass.getName();
        T service = (T) mInstances.get(className);

        if (service == null) {
            try {
                service = (T) subClass.getClassLoader().loadClass(subClass.getName()).newInstance();
                mInstances.put(className, service);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return service;
    }

    public static <T, V> void execute(ApiTask<T> task, V params, OnResponseListener<T> listener) {
        Call<T> call = task.request(params);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                T res = response.body();
                if (res != null) {
                    listener.onSuccess(res);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                listener.onError();
            }
        });
    }

    public static <T, V> Observable<T> executeRx(ApiTask<T> task, V params, OnResponseListener<T> listener) {
        return task.requestRx(params);
    }

    public static <T, V> void executeWithRx(ApiTask<T> task, V params, OnResponseListener<T> listener) {
        Observable<T> observable = task.requestRx(params);
        observable.subscribe(new Observer<T>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull T t) {
                listener.onSuccess(t);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Logger.e("------error: " + e.getClass().getName());
                if (e.getCause() instanceof ConnectException) {
                    Logger.e(e.getCause().getMessage());
                }
                listener.onError();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
