package com.wangbo.www.payutils.mvp.presenter;

import android.util.Log;

import com.wangbo.www.payutils.mvp.contranct.LoginContranct;
import com.wangbo.www.payutils.mvp.model.LoginModel;
import com.wb.baselib.http.HttpManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
public class LoginPresenter extends LoginContranct.LoginPresenter {
    public LoginPresenter(LoginContranct.LoginView iView) {
        this.mView=iView;
        this.mModel=new LoginModel();
    }

    @Override
    public void userLogin(String acc, String pwd) {

        HttpManager.newInstance().commonRequest(mModel.userLogin(acc, pwd), new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.e("获取的",value);
            }

            @Override
            public void onError(Throwable e) {
            Log.e("失败",e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
