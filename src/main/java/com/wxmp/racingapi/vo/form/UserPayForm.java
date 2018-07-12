package com.wxmp.racingapi.vo.form;

/**
 * @author xunbo.xu
 * @desc    用户下注对象<br/>
 * {"accountUuid":"accountUuid", "amount":100, "matchUuid":"matchUuid", "wins":"winsId"}
 * @date 18/7/9
 */
public class UserPayForm {

    /** 账户uuid */
    private String accountUuid;
    /** 下注金额 */
    private long amount;
    /** 赛程ID */
    private String matchUuid;
    /** 下注对象 */
    private String wins;

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getMatchUuid() {
        return matchUuid;
    }

    public void setMatchUuid(String matchUuid) {
        this.matchUuid = matchUuid;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }
}
