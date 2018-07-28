package com.lopetyz.hualdodo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.databinding.ActivityLifeCycleBinding;
import com.lopetyz.hualdodo.entity.User;
import com.lopetyz.hualdodo.lifecyclelearning.LiveDataActivity;
import com.lopetyz.hualdodo.lifecyclelearning.MyObserver;

public class LifeCycleActivity extends AppCompatActivity {

    ActivityLifeCycleBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_life_cycle);

        getLifecycle().addObserver(new MyObserver());

        mBinding.btnSub.setOnClickListener(v -> startActivity(new Intent(this, LiveDataActivity.class)));

        doBindingUser();
    }

    private void doBindingUser() {
        User user = new User();
        user.setAge(18);
        user.setName("郭晓婷");

        mBinding.setUser(user);

        mBinding.btnChange.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(mBinding.tietName.getText())) {
                user.setName(mBinding.tietName.getText().toString());
            }
        });
    }

}
