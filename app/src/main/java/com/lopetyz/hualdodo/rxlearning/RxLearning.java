package com.lopetyz.hualdodo.rxlearning;

import android.util.Log;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by lopetyz on 2017/3/20.
 */

public class RxLearning {

    public static void doRxSimple() {
        Flowable.fromCallable(() -> "Flowable.fromCallable").subscribe(s -> Log.i("hualtest" , s));

        Observable.fromCallable(() -> "Observable.fromCallable").subscribe(s -> Log.i("hualtest" , s));

        Maybe.fromCallable(() -> "Maybe.fromCallable").subscribe(s -> Log.i("hualtest" , s));
        Maybe.fromAction(() -> Log.i("hualtest" , "Maybe.fromAction")).subscribe();
        Maybe.fromRunnable(() -> Log.i("hualtest" , "Maybe.fromRunnable")).subscribe();

        Single.fromCallable(() -> "Hello Single").subscribe(s -> Log.i("hualtest" , s));

        Completable.fromCallable(() -> Log.i("hualtest" , "Ignored!")).subscribe();
        Completable.fromAction(() -> Log.i("hualtest" , "Completable.fromAction")).subscribe();
        Completable.fromRunnable(() -> Log.i("hualtest" , "Completable.fromRunnable")).subscribe();
    }
}
