package com.lopetyz.hualdodo.lifecyclelearning;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.databinding.ActivityLiveDataBinding;
import com.orhanobut.logger.Logger;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class LiveDataActivity extends AppCompatActivity {

    private ActivityLiveDataBinding mBinding;

    private NameViewModel mModel;

    private Queue<String> mNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_live_data);

        mBinding.btnUpdate.setOnClickListener(v -> updateName());

        mModel = ViewModelProviders.of(this).get(NameViewModel.class);
        final Observer<String> nameObserver = s -> mBinding.tvData.setText(s);
        mModel.getCurrentName().observe(this, nameObserver);

        initNameQueue();
    }

    private void initNameQueue() {
        mNames = new ArrayBlockingQueue<>(FAVORITE.values().length);
        for (FAVORITE favorite : FAVORITE.values()) {
            mNames.add(favorite.name);
        }
    }

    private void updateName() {
        String current = mNames.poll();
        mModel.getCurrentName().setValue(current);
        mNames.add(current);
        Logger.e("queue size: " + mNames.size());
    }


    @SuppressWarnings("SpellCheckingInspection")
    enum FAVORITE {

        GUOXIAOTING("郭晓婷"),
        HUBINGQING("胡冰卿");

        private String name;

        FAVORITE(String name) {
            this.name = name;
        }
    }
}
