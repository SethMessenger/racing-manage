package com.wxmp.racingapi.vo.vo;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/4
 */
public class UserPayDetailForm {

    /** 下注对象 */
    private String wins;
    /** 下注金额 */
    private long amount;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }
}
