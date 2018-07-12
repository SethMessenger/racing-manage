package com.wxmp.racingapi.vo.view;

import com.wxmp.racingapi.common.ErrorCodeEnum;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.domain.RUserCoin;

/**
 * @author xunbo.xu
 * @desc    api用户展示层
 * @date 18/7/8
 */
public class UserAccountView {

    public UserAccountView(RUser user, RUserCoin userCoin){
        if(null != user && null != userCoin){
            this.userUuid = user.getUuid();
            this.userName = user.getUserName();
            this.userNickname = user.getUserNickname();
            this.mobile = user.getMobile();
            this.wechat = user.getWechat();
            this.email = user.getEmail();
            this.openId = user.getOpenId();
            this.accountUuid = userCoin.getUuid();
            this.coins = userCoin.getTotal();
        }
    }

    private String userUuid;

    private String userName;

    private String userNickname;

    private String mobile;

    private String wechat;

    private String email;

    private String openId;

    private String accountUuid;

    private long coins;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }
}
