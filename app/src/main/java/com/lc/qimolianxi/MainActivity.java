package com.lc.qimolianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.lc.qimolianxi.adapter.MainAdapter;
import com.lc.qimolianxi.bean.MainBean;
import com.lc.qimolianxi.bean.MainGreenDaoBean;
import com.lc.qimolianxi.db.MainDBUtil;
import com.lc.qimolianxi.model.ImpMainModel;
import com.lc.qimolianxi.presenter.ImpMainPresenter;
import com.lc.qimolianxi.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private Toolbar mToolbar;
    private RecyclerView mRev;
    private ImpMainPresenter impMainPresenter;
    private ArrayList<MainBean.ResultsBean> mList;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        impMainPresenter = new ImpMainPresenter(new ImpMainModel(), this);
        initView();
        initData();

    }

    private void initData() {
        impMainPresenter.initData();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRev = (RecyclerView) findViewById(R.id.rev);
        mToolbar.setTitle("首页");
        mRev.setLayoutManager(new LinearLayoutManager(this));
        registerForContextMenu(mRev);
    }

    @Override
    public void OnSuccess(MainBean mainBean) {
        mList = new ArrayList<>();
        List<MainBean.ResultsBean> results = mainBean.getResults();
        mList.addAll(results);
        mainAdapter = new MainAdapter(this, mList);
        mRev.setAdapter(mainAdapter);
        mRev.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        mainAdapter.setOnClickListener(new MainAdapter.OnClickListener() {
            @Override
            public void OnClick(int position) {
                MainGreenDaoBean mainGreenDaoBean = new MainGreenDaoBean();
                MainBean.ResultsBean resultsBean = mList.get(position);
                mainGreenDaoBean.setId(null);
                mainGreenDaoBean.setDesc(resultsBean.getDesc());
                mainGreenDaoBean.setType(resultsBean.getType());
                mainGreenDaoBean.setUrl(resultsBean.getUrl());
                long inser = MainDBUtil.getDbUtil().inser(mainGreenDaoBean);
                if (inser > 0) {
                    Toast.makeText(MainActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "收藏失败/已收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainAdapter.setOnLongClickListener(new MainAdapter.OnLongClickListener() {

            private int po;

            @Override
            public void OnLongClick(int position) {
                po = position;
            }
        });

    }

    @Override
    public void OnFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"收藏列表");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                startActivity(new Intent(MainActivity.this,GreenActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(1,1,1,"下一个");
        menu.add(1,2,1,"修改");
        menu.add(1,3,1,"删除");
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                startActivity(new Intent(MainActivity.this,FiveActivity.class));
                break;
            case 2:

                break;
            case 3:

                break;
        }
        return super.onContextItemSelected(item);
    }
}
