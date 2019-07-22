package com.lc.qimolianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.lc.qimolianxi.adapter.FiveAdapter;
import com.lc.qimolianxi.bean.FiveBean;
import com.lc.qimolianxi.model.ImpFiveModel;
import com.lc.qimolianxi.presenter.ImpFivePresenter;
import com.lc.qimolianxi.view.FiveView;

import java.util.ArrayList;
import java.util.List;

public class FiveActivity extends AppCompatActivity implements View.OnClickListener, FiveView {

    private RecyclerView mRev;
    /**
     * 操作
     */
    private Button mBtnCaozuo;
    /**
     * 删除
     */
    private Button mBtnDelete;
    /**
     * 完成
     */
    private Button mBtnOk;
    /**
     * 下一个
     */
    private Button mBtnNext;
    private ImpFivePresenter impFivePresenter;
    private ArrayList<FiveBean.DataBean> mList;
    private FiveAdapter fiveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        impFivePresenter = new ImpFivePresenter(new ImpFiveModel(), this);
        initView();
        iniData();
    }

    private void initView() {
        mRev = (RecyclerView) findViewById(R.id.rev);
        mBtnCaozuo = (Button) findViewById(R.id.btn_caozuo);
        mBtnCaozuo.setOnClickListener(this);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnDelete.setOnClickListener(this);
        mBtnOk = (Button) findViewById(R.id.btn_ok);
        mBtnOk.setOnClickListener(this);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(this);
    }

    private void iniData() {
        impFivePresenter.initData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_caozuo:
                fiveAdapter.setVisiabe(true);
                fiveAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_delete:
                if (fiveAdapter.isVisiabe()){
                    for (int i = 0; i < mList.size(); i++) {
                        FiveBean.DataBean dataBean = mList.get(i);
                        if (dataBean.isVisble()){
                            mList.remove(i);
                            i--;
                        }
                    }
                    fiveAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.btn_ok:
                fiveAdapter.setVisiabe(false);
                fiveAdapter.notifyDataSetChanged();

                break;
            case R.id.btn_next:
                break;
        }
    }

    @Override
    public void OnSuccess(FiveBean fiveBean) {
        mRev.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        List<FiveBean.DataBean> data = fiveBean.getData();
        mList.addAll(data);
        fiveAdapter = new FiveAdapter(this, mList);
        mRev.setAdapter(fiveAdapter);
    }

    @Override
    public void OnFail(String error) {

    }
}
