package com.wxmp.racingapi.vo.form;

import com.wxmp.racingapi.vo.vo.UserPayDetailForm;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/15
 */
public class UserPayAllForm {

    /** 账户uuid */
    private String accountUuid;
    /** 赛程ID */
    private String matchUuid;
    /** 冠军赛下注明细 */
    private List<UserPayDetailForm> champs;
    /** 冠亚军赛下注明细 */
    private List<UserPayDetailForm> champSeconds;
    /** 竞速赛下注明细 */
    private List<UserPayDetailForm> speeds;

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

    public List<UserPayDetailForm> getChamps() {
        return champs;
    }

    public void setChamps(List<UserPayDetailForm> champs) {
        this.champs = champs;
    }

    public List<UserPayDetailForm> getChampSeconds() {
        return champSeconds;
    }

    public void setChampSeconds(List<UserPayDetailForm> champSeconds) {
        this.champSeconds = champSeconds;
    }

    public List<UserPayDetailForm> getSpeeds() {
        return speeds;
    }

    public void setSpeeds(List<UserPayDetailForm> speeds) {
        this.speeds = speeds;
    }
}
