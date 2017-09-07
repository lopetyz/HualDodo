package com.lopetyz.hualdodo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.databinding.ActivityCustomViewBinding;
import com.lopetyz.hualdodo.widget.CountDownTimerView;

public class CustomViewActivity extends AppCompatActivity {

    private ActivityCustomViewBinding mBinding;

    private CountDownTimerView mCountDownTimerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_custom_view);
    }
}
