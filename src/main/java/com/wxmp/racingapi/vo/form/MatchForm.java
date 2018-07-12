package com.wxmp.racingapi.vo.form;

/**
 * @author xunbo.xu
 * @desc    赛程请求信息<br/>
 * {"accountUuid":"accountUuid", "userUuid":"userUuid", "matchUuid":"matchUuid"}
 * @date 18/7/9
 */
public class MatchForm {

    private String accountUuid;
    private String userUuid;
    private String matchUuid;

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getMatchUuid() {
        return matchUuid;
    }

    public void setMatchUuid(String matchUuid) {
        this.matchUuid = matchUuid;
    }
}
