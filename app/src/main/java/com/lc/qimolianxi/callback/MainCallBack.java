package com.lc.qimolianxi.callback;

import com.lc.qimolianxi.bean.MainBean;

public interface MainCallBack {
    void OnSuccess(MainBean mainBean);

    void OnFail(String error);
}
