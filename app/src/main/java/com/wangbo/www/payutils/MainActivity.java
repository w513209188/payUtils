package com.wangbo.www.payutils;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wangbo.www.payutils.mvp.contranct.LoginContranct;
import com.wangbo.www.payutils.mvp.presenter.LoginPresenter;
import com.wb.baselib.base.activity.MvpActivity;

public class MainActivity extends MvpActivity<LoginPresenter> implements LoginContranct.LoginView {
    private Button button;
    @Override
    protected LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }
    @Override
    protected void initView(Bundle bundle) {
        setContentView(R.layout.layout_login);
        Log.e("进来了","------");
        button=getViewById(R.id.pay_bt);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.pay_bt:
                mPresenter.userLogin("13333333333","");
                break;
        }
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void showErrorMsg(String s) {

    }

    @Override
    public void showLoadV(String s) {

    }

    @Override
    public void closeLoadV() {

    }
}
