package com.lc.qimolianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lc.qimolianxi.adapter.GreenAdapter;
import com.lc.qimolianxi.bean.MainGreenDaoBean;
import com.lc.qimolianxi.db.MainDBUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GreenActivity extends AppCompatActivity {

    private RecyclerView mRev;
    private ArrayList<MainGreenDaoBean> mList;
    private GreenAdapter greenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green);
        initView();
    }

    private void initView() {

        mRev = (RecyclerView) findViewById(R.id.rev);
        mRev.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        List<MainGreenDaoBean> mainGreenDaoBeans = MainDBUtil.getDbUtil().queryAll();
        mList.addAll(mainGreenDaoBeans);
        greenAdapter = new GreenAdapter(this, mList);
        mRev.setAdapter(greenAdapter);

    }
}
