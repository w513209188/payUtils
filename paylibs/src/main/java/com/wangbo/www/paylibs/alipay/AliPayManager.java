package com.wangbo.www.paylibs.alipay;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.wangbo.www.paylibs.alipay.util.AuthResult;
import com.wangbo.www.paylibs.alipay.util.OrderInfoUtil2_0;
import com.wangbo.www.paylibs.alipay.util.PayResult;

import java.util.Map;

/**
 * 支付宝管理
 */
public class AliPayManager {

    private static AliPayManager aliPayManager;
    private AliPayUnSignOrderConfig aliPayUnSignOrderConfig;
    private AliPayConfig aliPayConfig;
    /**
     * 实例化获取单例
     * @return
     */
    public static AliPayManager getInstance(){
        synchronized (AliPayManager.class){
            if(aliPayManager==null){
                aliPayManager=new AliPayManager();
            }
        }
        return aliPayManager;
    }

    /**
     * 调起支付
     * @param aliPayConfig
     */
    public void sendPay(AliPayConfig aliPayConfig){
        this.aliPayConfig=aliPayConfig;
        payAliPay();
    }

    /**
     * 调起支付
     * @param aliPayUnSignOrderConfig
     */
    public void sendPay(AliPayUnSignOrderConfig aliPayUnSignOrderConfig){
        this.aliPayUnSignOrderConfig=aliPayUnSignOrderConfig;
        aliPayConfig=new AliPayConfig.Builder().with(aliPayUnSignOrderConfig.getmActivity()).setmCall(aliPayUnSignOrderConfig.getmCall()).setSignedOrder(getSignOrder(aliPayUnSignOrderConfig)).builder();
        payAliPay();
    }
    private String getSignOrder(AliPayUnSignOrderConfig mAliPayUnSignOrderConfig){
        boolean rsa2 =true;
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(mAliPayUnSignOrderConfig);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
        String sign = OrderInfoUtil2_0.getSign(params, mAliPayUnSignOrderConfig.getRSA2_PRIVATE(), rsa2);
        final String orderInfo = orderParam + "&" + sign;
        return orderInfo;
    }
    private void payAliPay(){


        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(aliPayConfig.getmActivity());
                Map<String, String> result = alipay.payV2(aliPayConfig.getSignedOrder(), true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 获取当前阿里支付宝的版本号
     */
    public String getSDKVersion() {
        PayTask payTask = new PayTask(aliPayConfig.getmActivity());
        String version = payTask.getVersion();
        return version;
    }
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    if( aliPayConfig.getmCall()==null){
                        Log.e("回调空","------");
                        return;
                    }

                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        aliPayConfig.getmCall().getPayAliPayStatus("支付成功",true);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        aliPayConfig.getmCall().getPayAliPayStatus("支付失败",false);
                    }
                    break;
                }
            }
        }
        };
}
