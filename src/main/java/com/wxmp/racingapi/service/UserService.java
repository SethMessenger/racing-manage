package com.wxmp.racingapi.service;

import com.wxmp.racingapi.vo.form.UserRegisForm;
import com.wxmp.racingcms.domain.RUser;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/10
 */
public interface UserService {

    /**
     * 用户注册
     * @return
     */
    RUser registerUser(UserRegisForm form);

}
