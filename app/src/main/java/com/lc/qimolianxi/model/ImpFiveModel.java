package com.lc.qimolianxi.model;

import com.lc.qimolianxi.api.FiveServer;
import com.lc.qimolianxi.bean.FiveBean;
import com.lc.qimolianxi.callback.FiveCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpFiveModel implements FiveModel {
    @Override
    public void initData(final FiveCallBack fiveCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FiveServer.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FiveServer fiveServer = retrofit.create(FiveServer.class);
        Observable<FiveBean> call = fiveServer.initData();
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FiveBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FiveBean fiveBean) {
                        fiveCallBack.OnSuccess(fiveBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        fiveCallBack.OnFail(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
