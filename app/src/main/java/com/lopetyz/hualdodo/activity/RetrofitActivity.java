package com.lopetyz.hualdodo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lopetyz.hualdodo.R;
import com.lopetyz.hualdodo.common.network.OnResponseListener;
import com.lopetyz.hualdodo.common.network.RetrofitClient;
import com.lopetyz.hualdodo.databinding.ActivityRetrofitBinding;
import com.lopetyz.hualdodo.entity.Repo;
import com.lopetyz.hualdodo.service.GitHubService;
import com.orhanobut.logger.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private ActivityRetrofitBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit);

        mBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doSomething();
            }
        });
    }

    private void doSomething() {
        GitHubService service = RetrofitClient.getInstance(GitHubService.class);
        service.getApi().listRepos("lopetyz").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                Logger.d(response.body());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RetrofitActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
