package com.wxmp.racingapi.service.impl;

import com.wxmp.racingapi.service.ComponentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  xunbo.xu
 * @desc    用于racingAPI的组件操作
 * @date 18/7/20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ComponentServiceImpl implements ComponentService{


    /**
     * 发送验证码短信
     *
     * @param mobile
     * @param identifyCode
     * @return
     */
    @Override
    public Integer pushIdentifyShortMessage(String mobile, String identifyCode) {

        return null;
    }
}
