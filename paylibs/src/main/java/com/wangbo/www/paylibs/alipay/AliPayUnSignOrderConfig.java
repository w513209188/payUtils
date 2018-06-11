package com.wangbo.www.paylibs.alipay;

import android.app.Activity;

import com.wangbo.www.paylibs.alipay.call.AliPayStatusCall;

/**
 * 支付宝支付脱离服务器配置
 */
public class AliPayUnSignOrderConfig {
    //上下文
    private Activity mActivity;
    //回调
    private AliPayStatusCall mCall;
    //签约合作者身份ID
    private String partner;
    //商户网站唯一订单号
    private String outTradeNo;
    //商品名称
    private String subject;
    //商品详情
    private String body;
    //商品金额
    private String price;
    //服务器异步通知页面路径
    private String callbackUrl;
    //时间戳
    private String timestamp;
    //私钥
    private String RSA2_PRIVATE;
    //应用Id
    private String APPID;

    public String getAPPID() {
        return APPID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getRSA2_PRIVATE() {
        return RSA2_PRIVATE;
    }

    public Activity getmActivity() {
        return mActivity;
    }

    public AliPayStatusCall getmCall() {
        return mCall;
    }

    public String getPartner() {
        return partner;
    }


    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getPrice() {
        return price;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }
    public static class Bulider{
        private Activity mActivity;
        private AliPayStatusCall mCall;
        private String partner;
        private String outTradeNo;
        private String subject;
        private String body;
        private String price;
        private String callbackUrl;
        private String RSA2_PRIVATE;
        private String APPID;
        private String timestamp;

        public Bulider setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Bulider setAPPID(String APPID) {
            this.APPID = APPID;
            return this;
        }

        public Bulider setRSA2_PRIVATE(String RSA2_PRIVATE) {
            this.RSA2_PRIVATE = RSA2_PRIVATE;
            return this;
        }

        public Bulider with(Activity mActivity) {
            this.mActivity = mActivity;
            return this;
        }

        public Bulider setmCall(AliPayStatusCall mCall) {
            this.mCall = mCall;
            return this;
        }

        public Bulider setPartner(String partner) {
            this.partner = partner;
            return this;
        }


        public Bulider setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public Bulider setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Bulider setBody(String body) {
            this.body = body;
            return this;
        }

        public Bulider setPrice(String price) {
            this.price = price;
            return this;
        }

        public Bulider setCallbackUrl(String callbackUrl) {
            this.callbackUrl = callbackUrl;
            return this;
        }
        public AliPayUnSignOrderConfig builder(){
            AliPayUnSignOrderConfig config=new AliPayUnSignOrderConfig();
            config.body=this.body;
            config.callbackUrl=this.callbackUrl;
            config.mActivity=this.mActivity;
            config.mCall=this.mCall;
            config.outTradeNo=this.outTradeNo;
            config.partner=this.partner;
            config.price=this.price;
            config.subject=this.subject;
            config.RSA2_PRIVATE=this.RSA2_PRIVATE;
            config.APPID=this.APPID;
            config.timestamp=this.timestamp;
            return config;
        }
    }
}
