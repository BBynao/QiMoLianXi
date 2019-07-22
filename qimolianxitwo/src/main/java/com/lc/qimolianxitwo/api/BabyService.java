package com.lc.qimolianxitwo.api;

import com.lc.qimolianxitwo.bean.FoodBean;
import com.lc.qimolianxitwo.bean.LadyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BabyService {
    String url = "https://gank.io/api/data/福利/";
    @GET("20/1")
    Observable<LadyBean> initData();

    String Foodurl = "http://www.qubaobei.com/ios/cf/";
    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FoodBean> FoodinitData();
}
