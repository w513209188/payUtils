package com.wangbo.www.payutils.mvp.contranct;

import com.wb.baselib.base.mvp.BaseModel;
import com.wb.baselib.base.mvp.BasePreaenter;
import com.wb.baselib.base.mvp.BaseView;

import io.reactivex.Observable;

public interface LoginContranct {
    interface LoginView extends BaseView{

    }
    interface LoginModel extends BaseModel{
        Observable<String> userLogin(String acc,String pwd);
    }
    abstract class LoginPresenter extends BasePreaenter<LoginView,LoginModel>{
        public abstract void userLogin(String acc,String pwd);
    }
}
