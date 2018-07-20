package com.wxmp.racingapi.service.impl;

import com.wxmp.core.agent.ComponentAgent;
import com.wxmp.racingapi.service.ComponentService;
import com.wxmp.racingapi.vo.agent.ShortMessageRes;
import com.wxmp.racingcms.mapper.RMatchResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RMatchResultMapper matchResultMapper;

    /**
     * 发送验证码短信
     *
     * @param mobile
     * @param identifyCode
     * @return
     */
    @Override
    public Integer pushIdentifyShortMessage(String mobile, String identifyCode) {
        ShortMessageRes res = ComponentAgent.sendShortMessage(mobile, identifyCode);
        if(null != res){
            return 1;
        }else {
            return 0;
        }
    }
}
