package com.wangbo.www.paylibs.alipay;

import android.app.Activity;
import android.util.Log;

import com.wangbo.www.paylibs.alipay.call.AliPayStatusCall;

/**
 * 支付宝支付服务器配置
 */
public class AliPayConfig {
    private Activity mActivity;
    //签名的订单，服务器返回唯一的
    private String signedOrder;
    private AliPayStatusCall mCall;

    public Activity getmActivity() {
        return mActivity;
    }
    public String getSignedOrder() {
        return signedOrder;
    }

    public AliPayStatusCall getmCall() {
        return mCall;
    }

    public static class Builder{
        private Activity mActivity;
        //签名的订单，服务器返回唯一的
        private String signedOrder;
        private AliPayStatusCall mCall;

        public Builder() {
        }

        public Builder setmCall(AliPayStatusCall mCall) {
            this.mCall = mCall;
            return this;
        }

        public Builder with(Activity mActivity) {
            this.mActivity = mActivity;
            return this;
        }
        public Builder setSignedOrder(String signedOrder) {
            this.signedOrder = signedOrder;
            return this;
        }
        public AliPayConfig builder(){
            AliPayConfig alPayConfig=new AliPayConfig();
            alPayConfig.mActivity=this.mActivity;
            alPayConfig.signedOrder=this.signedOrder;
            alPayConfig.mCall=this.mCall;
            return alPayConfig;
        }
    }
}
