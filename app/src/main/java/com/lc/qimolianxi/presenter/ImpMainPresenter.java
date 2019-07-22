package com.lc.qimolianxi.presenter;

import com.lc.qimolianxi.bean.MainBean;
import com.lc.qimolianxi.callback.MainCallBack;
import com.lc.qimolianxi.model.MainModel;
import com.lc.qimolianxi.view.MainView;

public class ImpMainPresenter implements MainPresenter, MainCallBack {
    private MainModel model;
    private MainView view;

    public ImpMainPresenter(MainModel model, MainView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void initData() {
        if (model != null) {
            model.initData(this);
        }
    }

    @Override
    public void OnSuccess(MainBean mainBean) {
        if (view != null) {
            view.OnSuccess(mainBean);
        }
    }

    @Override
    public void OnFail(String error) {
        if (view != null) {
            view.OnFail(error);
        }
    }
}
