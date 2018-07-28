package com.lopetyz.hualdodo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.annotations.BindBtnItem;

@BindBtnItem(value = "RetrofitActivity")
public class RetrofitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofit);

    }
}
