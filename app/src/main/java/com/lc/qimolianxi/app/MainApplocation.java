package com.lc.qimolianxi.app;

import android.app.Application;

public class MainApplocation extends Application {
    private static MainApplocation applocation;

    @Override
    public void onCreate() {
        super.onCreate();
        applocation = this;
    }

    public static MainApplocation getApplocation() {
        return applocation;
    }
}
