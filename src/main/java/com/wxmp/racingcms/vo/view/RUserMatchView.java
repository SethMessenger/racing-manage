package com.wxmp.racingcms.vo.view;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/14
 */
public class RUserMatchView {

    private String userUuid;
    private String matchResultUuid;
    private String matchResult;
    private Long counts;
    private Integer countsIndex;
    private String amountTime;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getMatchResultUuid() {
        return matchResultUuid;
    }

    public void setMatchResultUuid(String matchResultUuid) {
        this.matchResultUuid = matchResultUuid;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }

    public Integer getCountsIndex() {
        return countsIndex;
    }

    public void setCountsIndex(Integer countsIndex) {
        this.countsIndex = countsIndex;
    }

    public String getAmountTime() {
        return amountTime;
    }

    public void setAmountTime(String amountTime) {
        this.amountTime = amountTime;
    }
}
