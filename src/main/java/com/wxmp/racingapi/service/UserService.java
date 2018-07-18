package com.wxmp.racingapi.service;

import com.wxmp.racingapi.vo.form.UserRegisForm;
import com.wxmp.racingapi.vo.view.UserAccountView;

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
    UserAccountView registerUser(UserRegisForm form);

    /**
     * 获取用户信息
     * @param userUuid
     * @return
     */
    UserAccountView getUserInfo(String userUuid);

}
