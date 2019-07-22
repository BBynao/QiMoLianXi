package com.lc.qimolianxi.model;

import com.lc.qimolianxi.api.MainServer;
import com.lc.qimolianxi.bean.MainBean;
import com.lc.qimolianxi.callback.MainCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpMainModel implements MainModel {

    @Override
    public void initData(final MainCallBack mainCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainServer.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MainServer mainServer = retrofit.create(MainServer.class);

        Observable<MainBean> call = mainServer.initData();

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainBean mainBean) {
                        mainCallBack.OnSuccess(mainBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.OnFail(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
