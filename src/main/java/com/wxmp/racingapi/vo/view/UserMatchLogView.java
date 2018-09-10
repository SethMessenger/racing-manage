package com.wxmp.racingapi.vo.view;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/9/5
 */
public class UserMatchLogView {

    private String matchResultUuid;
    private Integer matchType;
    private long amount;
    private long wins;
    private String matchTime;

    public UserMatchLogView(String matchResultUuid, Integer matchType, long amount, long wins, String matchTime) {
        this.matchResultUuid = matchResultUuid;
        this.matchType = matchType;
        this.amount = amount;
        this.wins = wins;
        this.matchTime = matchTime;
    }

    public String getMatchResultUuid() {
        return matchResultUuid;
    }

    public void setMatchResultUuid(String matchResultUuid) {
        this.matchResultUuid = matchResultUuid;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }
}
