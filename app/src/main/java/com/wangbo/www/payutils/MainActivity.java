package com.wangbo.www.payutils;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wangbo.www.paylibs.alipay.AliPayConfig;
import com.wangbo.www.paylibs.alipay.AliPayManager;
import com.wangbo.www.paylibs.alipay.call.AliPayStatusCall;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button pay_bt=this.findViewById(R.id.pay_bt);
    }
}
