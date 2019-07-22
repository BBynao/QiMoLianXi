package com.lc.qimolianxi.view;

import com.lc.qimolianxi.bean.MainBean;

public interface MainView  {
    void OnSuccess(MainBean mainBean);

    void OnFail(String error);
}
