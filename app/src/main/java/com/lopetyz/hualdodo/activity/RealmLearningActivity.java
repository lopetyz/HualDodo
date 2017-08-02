package com.lopetyz.hualdodo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.databinding.ActivityRealmLearningBinding;

import io.realm.Realm;

/**
 * Created by lopetyz on 2017/7/15.
 */

public class RealmLearningActivity extends AppCompatActivity {

    private ActivityRealmLearningBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_realm_learning);
        init();
    }

    private void init() {
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onSubmitClick() {
            if (TextUtils.isEmpty(mBinding.textInputName.getText().toString().trim())) {
                Toast.makeText(RealmLearningActivity.this, "Please input name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(mBinding.textInputAge.getText().toString().trim())) {
                Toast.makeText(RealmLearningActivity.this, "Please input name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(mBinding.textInputSex.getText().toString().trim())) {
                Toast.makeText(RealmLearningActivity.this, "Please input name", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}
