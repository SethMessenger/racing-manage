package com.wxmp.racingapi.vo.dto;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/9/5
 */
public class UserMatchLogDTO {

    private String logUuid;
    private long createTime;
    private String matchResultUuid;
    private long coinAmount;
    private int coinIndex;
    private int matchType;
    private double mutiAmount;
    private String matchResult;

    public String getLogUuid() {
        return logUuid;
    }

    public void setLogUuid(String logUuid) {
        this.logUuid = logUuid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMatchResultUuid() {
        return matchResultUuid;
    }

    public void setMatchResultUuid(String matchResultUuid) {
        this.matchResultUuid = matchResultUuid;
    }

    public long getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(long coinAmount) {
        this.coinAmount = coinAmount;
    }

    public int getCoinIndex() {
        return coinIndex;
    }

    public void setCoinIndex(int coinIndex) {
        this.coinIndex = coinIndex;
    }

    public int getMatchType() {
        return matchType;
    }

    public void setMatchType(int matchType) {
        this.matchType = matchType;
    }

    public double getMutiAmount() {
        return mutiAmount;
    }

    public void setMutiAmount(double mutiAmount) {
        this.mutiAmount = mutiAmount;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }
}
