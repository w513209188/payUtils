package com.wangbo.www.paylibs.wxpay;

import android.app.Activity;

/**
 * 微信支付配置
 */
public class WxPayConfig {
    //应用ID
    private String appId;
    //商户ID
    private String partnerid;
    //预支付交易会话ID
    private String prepayid;
    //扩展字段 暂填写固定值Sign=WXPay
    private String packagex;
    //随机字符串
    private String noncestr;
    //时间戳
    private String timestamp;
    //签名
    private String sign;
    //上下文
    private Activity activity;

    public String getAppId() {
        return appId;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public String getPackagex() {
        return packagex;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSign() {
        return sign;
    }

    public Activity getActivity() {
        return activity;
    }
    public static class Builder{
        private String appId;
        private String partnerid;
        private String prepayid;
        private String packagex;
        private String noncestr;
        private String timestamp;
        private String sign;
        private Activity activity;

        public Builder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder setPartnerid(String partnerid) {
            this.partnerid = partnerid;
            return this;
        }

        public Builder setPrepayid(String prepayid) {
            this.prepayid = prepayid;
            return this;
        }

        public Builder setPackagex(String packagex) {
            this.packagex = packagex;
            return this;
        }

        public Builder setNoncestr(String noncestr) {
            this.noncestr = noncestr;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setSign(String sign) {
            this.sign = sign;
            return this;
        }

        public Builder with(Activity activity) {
            this.activity = activity;
            return this;
        }
        public WxPayConfig builder(){
            WxPayConfig wxPayConfig=new WxPayConfig();
            wxPayConfig.activity=this.activity;
            wxPayConfig.appId=this.appId;
            wxPayConfig.noncestr=this.noncestr;
            wxPayConfig.packagex=this.packagex;
            wxPayConfig.prepayid=this.prepayid;
            wxPayConfig.sign=this.sign;
            wxPayConfig.timestamp=this.timestamp;
            wxPayConfig.partnerid=this.partnerid;
            return wxPayConfig;
        }
    }
}
