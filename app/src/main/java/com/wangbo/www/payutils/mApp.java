package com.wangbo.www.payutils;

import com.wb.baselib.BaseApplication;
import com.wb.baselib.http.HttpConfig;

public class mApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        new HttpConfig.HttpConfigBuilder()
                .setmBaseUrl("https://aozhou.shiduweb.com/")
                .setUseCustGson(false).build();
    }
}
