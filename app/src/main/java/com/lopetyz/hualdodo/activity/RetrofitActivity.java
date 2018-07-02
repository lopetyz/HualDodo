package com.lopetyz.hualdodo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.databinding.ActivityRetrofitBinding;

public class RetrofitActivity extends AppCompatActivity {

    private ActivityRetrofitBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit);

        mBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
