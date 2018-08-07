package com.wxmp.racingapi.service;

import com.wxmp.racingapi.vo.form.WechatPayOrderForm;

/**
 * @author  xunbo.xu
 * @desc    接入支付业务
 * @date 18/7/18
 */
public interface PayService {


    void launchWechatH5Pay(String ip, WechatPayOrderForm form);

}
