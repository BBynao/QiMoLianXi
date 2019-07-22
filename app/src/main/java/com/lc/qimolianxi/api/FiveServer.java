package com.lc.qimolianxi.api;

import com.lc.qimolianxi.bean.FiveBean;
import com.lc.qimolianxi.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FiveServer {
    String url = "http://www.qubaobei.com/ios/cf/";
    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FiveBean> initData();

}
