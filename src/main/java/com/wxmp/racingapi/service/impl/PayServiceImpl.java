package com.wxmp.racingapi.service.impl;

import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.core.util.wx.LogUtils;
import com.wxmp.racingapi.common.WxPayApi;
import com.wxmp.racingapi.common.WxPayApiConfig;
import com.wxmp.racingapi.common.WxPayUtils;
import com.wxmp.racingapi.service.PayService;
import com.wxmp.racingapi.vo.agent.H5ScencInfo;
import com.wxmp.racingapi.vo.agent.H5ScencInfo.H5;
import com.wxmp.racingapi.vo.form.WechatPayOrderForm;

import java.io.IOException;
import java.util.Map;

/**
 * @author  xunbo.xu
 * @desc    接入支付业务
 * @date 18/7/18
 */
public class PayServiceImpl implements PayService{

    @Override
    public void launchWechatH5Pay(String ip, WechatPayOrderForm form) {
        H5ScencInfo sceneInfo = new H5ScencInfo();

        H5 h5_info = new H5();
        h5_info.setType("Wap");
        //此域名必须在商户平台--"产品中心"--"开发配置"中添加
        h5_info.setWap_url("https://www.zzw777.com");
        h5_info.setWap_name("腾讯充值");
        sceneInfo.setH5_info(h5_info);
        //WxPayApiConfig wxPayApiConfig=getApiConfig();
        Map<String, String> params= WxPayApiConfig.New()
                .setAppId(RacingConstants.RACING_WECHAT_APPID)//APPID
                .setMchId(RacingConstants.RACING_WECHAT_MCHID)//商户号
                .setBody("racing pay  -By Seth")
                .setSpbillCreateIp(ip)//必须使用正确的客户端IP
                .setTotalFee(String.valueOf(form.getOrderAmount() * 100))//总金额，单位为分
                .setTradeType(WxPayApi.TradeType.MWEB)
                .setNotifyUrl("http://notifyURL")
                .setPaternerKey("partnerKey")
                .setOutTradeNo(String.valueOf(System.currentTimeMillis()))
                .setSceneInfo("{\"h5_info\": {\"type\":\"IOS\",\"app_name\": \"mtgg\",\"package_name\": \"com.tencent.tmgp.sgame\"}}")
                .setAttach("IJPay H5支付测试  -By Javen")
                .build();
        String xmlResult = WxPayApi.pushOrder(false,params);
        Map<String, String> result = WxPayUtils.xmlToMap(xmlResult);

        String return_code = result.get("return_code");
        String return_msg = result.get("return_msg");
        if (!WxPayUtils.codeIsOK(return_code)) {
            LogUtils.console("return_code>"+return_code+" return_msg>"+return_msg);
            throw new RuntimeException(return_msg);
        }
        String result_code = result.get("result_code");
        if (!WxPayUtils.codeIsOK(result_code)) {
            LogUtils.console("result_code>"+result_code+" return_msg>"+return_msg);
            throw new RuntimeException(return_msg);
        }
        // 以下字段在return_code 和result_code都为SUCCESS的时候有返回

        String prepay_id = result.get("prepay_id");
        String mweb_url = result.get("mweb_url");

        LogUtils.console("prepay_id:"+prepay_id+" mweb_url:"+mweb_url);
//        try {
//            response.sendRedirect(mweb_url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
