package com.lopetyz.hualdodo.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lopetyz on 2017/7/29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public <T extends ViewDataBinding> T getViewDataBinding() {
        return DataBindingUtil.setContentView(this, getLayoutId());
    }

    @LayoutRes
    protected abstract int getLayoutId();

    public <T> void executeTask(Call<T> call) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

            }
        });
    }

    public <T> void cancelTask(Call<T> call) {
        if (call.isExecuted() || call.isCanceled()) {
            return;
        }
        call.cancel();
    }
}
