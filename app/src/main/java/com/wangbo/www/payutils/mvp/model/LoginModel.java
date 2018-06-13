package com.wangbo.www.payutils.mvp.model;

import com.wangbo.www.payutils.api.BasicsApiService;
import com.wangbo.www.payutils.mvp.contranct.LoginContranct;
import com.wb.baselib.http.HttpManager;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class LoginModel implements LoginContranct.LoginModel {
    @Override
    public Observable<String> userLogin(String acc, String pwd) {
        Map map=new HashMap();
        map.put("tel",acc);
        return HttpManager.newInstance().getService(BasicsApiService.class).UserRegist(map);
    }
}
