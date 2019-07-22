package com.lc.qimolianxi.callback;

import com.lc.qimolianxi.bean.FiveBean;

public interface FiveCallBack {
    void OnSuccess(FiveBean fiveBean);
    void OnFail(String error);
}
