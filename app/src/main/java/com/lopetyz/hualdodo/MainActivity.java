package com.lopetyz.hualdodo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.lopetyz.hualdodo.databinding.ActivityMainBinding;
import com.lopetyz.hualdodo.homebtnlist.BtnListAdapter;
import com.lopetyz.hualdodo.homebtnlist.BtnListManager;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(mBinding.toolbar);

        mBinding.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        mBinding.content.recycleView.setLayoutManager(new LinearLayoutManager(this));
        BtnListManager manager = new BtnListManager(this);
        mBinding.setBtnItems(manager.getBtnItemList());
        BtnListAdapter btnListAdapter = new BtnListAdapter(this);
        mBinding.content.recycleView.setAdapter(btnListAdapter);
//        mBinding.content.setBtnItems(manager.getBtnItemList());
//        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
//        BtnListAdapter btnListAdapter = new BtnListAdapter(this, manager.getBtnItemList());
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(btnListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
