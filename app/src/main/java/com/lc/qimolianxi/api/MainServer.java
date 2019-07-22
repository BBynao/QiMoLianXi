package com.lc.qimolianxi.api;

import com.lc.qimolianxi.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MainServer {
    String url = "https://gank.io/api/data/福利/";
    @GET("20/1")
    Observable<MainBean> initData();

}
