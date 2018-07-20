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
     * 用户手机注册
     * @param mobile
     * @param code
     * @return
     */
    UserAccountView registerUser(String mobile, String code);

    /**
     * 校验用户注册信息
     * @param form
     * @return
     */
    boolean checkUserAccount(UserRegisForm form);

    /**
     * 获取用户信息
     * @param userUuid
     * @return
     */
    UserAccountView getUserInfo(String userUuid);

    /**
     * 为当前用户获取验证码
     * @param mobile
     * @return
     */
    String identifyCode(String mobile);

}
