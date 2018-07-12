package com.wxmp.racingapi.service.impl;

import com.wxmp.racingapi.service.UserService;
import com.wxmp.racingapi.vo.form.UserRegisForm;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.service.RUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  xunbo.xu
 * @desc
 * @date 18/7/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private RUserService rUserService;

    /**
     * 用户注册
     * @return
     */
    @Override
    public RUser registerUser(UserRegisForm form) {
        RUser user = new RUser("front_api", form);
        if(this.rUserService.add(user) > 0){
            return user;
        }else {
            return null;
        }
    }

}
