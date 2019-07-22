package com.lc.qimolianxi.presenter;

import com.lc.qimolianxi.bean.FiveBean;
import com.lc.qimolianxi.callback.FiveCallBack;
import com.lc.qimolianxi.model.FiveModel;
import com.lc.qimolianxi.view.FiveView;

public class ImpFivePresenter implements FivePresenter, FiveCallBack {
    private FiveModel model;
    private FiveView view;

    public ImpFivePresenter(FiveModel model, FiveView view) {
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
    public void OnSuccess(FiveBean fiveBean) {
        if (view != null) {
            view.OnSuccess(fiveBean);
        }
    }

    @Override
    public void OnFail(String error) {
        if (view != null) {
            view.OnFail(error);
        }

    }
}
