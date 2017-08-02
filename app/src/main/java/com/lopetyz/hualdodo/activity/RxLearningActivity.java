package com.lopetyz.hualdodo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.databinding.ActivityRxLearningBinding;
import com.lopetyz.hualdodo.rxlearning.RxLearning;

public class RxLearningActivity extends AppCompatActivity {

    private ActivityRxLearningBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_rx_learning);

        mBinding.btnRx.setOnClickListener(v -> {
            doRxSomething();
            doSomething();
        });

        dosss(2, v -> {
            doRxSomething();
            doSomething();
        });
    }

    private void doRxSomething() {
        RxLearning.doRxSimple();
    }
    private void doSomething() {

    }

    private void dosss(int s, View.OnClickListener listener) {

    }
}
