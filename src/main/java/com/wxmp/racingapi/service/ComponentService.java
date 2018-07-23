package com.wxmp.racingapi.service;

/**
 * @author  xunbo.xu
 * @desc    用于racingAPI的组件操作
 * @date 18/7/20
 */
public interface ComponentService {

    /**
     * 发送验证码短信
     * @param mobile
     * @param identifyCode
     * @return
     */
    Integer pushIdentifyShortMessage(String mobile, String identifyCode);


    /**
     * 找回验证码
     * @param mobile
     * @param identifyCode
     * @return
     */
    Integer pushFindCodeShortMessage(String mobile, String identifyCode);
}
