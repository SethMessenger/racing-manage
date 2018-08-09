package com.wxmp.racingapi.vo.form;

import com.wxmp.racingapi.vo.vo.UserPayDetailForm;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc    用户下注对象<br/>
 * {"accountUuid":"accountUuid", "amount":100, "matchUuid":"matchUuid", "wins":"winsId"}
 * @date 18/7/9
 */
public class UserPayForm {

    /** 账户uuid */
    private String accountUuid;
    /** 赛程ID */
    private String matchUuid;
    /** 下注明细 */
    private List<UserPayDetailForm> details;

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getMatchUuid() {
        return matchUuid;
    }

    public void setMatchUuid(String matchUuid) {
        this.matchUuid = matchUuid;
    }

    public List<UserPayDetailForm> getDetails() {
        return details;
    }

    public void setDetails(List<UserPayDetailForm> details) {
        this.details = details;
    }
}
