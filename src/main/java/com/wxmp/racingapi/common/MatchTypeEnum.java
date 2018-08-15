package com.wxmp.racingapi.common;

/**
 * @author xunbo.xu
 * @desc    暂时替换r_match_info表格内容
 * @date 18/8/15
 */
public enum  MatchTypeEnum {

    /** 冠军赛 */
    CHAMPS(1, 5.7D, "冠军赛6辆车, 5.4回报率，冠军结算"),
    /**  */
    CHAMP_SECONDS(2, 2.7D, "冠亚军赛, 2.7回报率，可押注两部赛车为冠亚军,冠亚军无优先级"),
    /** 竞速赛 */
    SPEEDS(3, 1.86D, "竞速赛，1.86回报率, 对其中的两辆赛车进行押注，押注其中的一辆赛车获胜");

    /**  */
    private int matchType;
    /** 备注 */
    private String remark;
    /** 赔率 */
    private double racingMuti;

    private MatchTypeEnum(){}
    private MatchTypeEnum(int matchType, double racingMuti, String remark){
        this.matchType = matchType;
        this.racingMuti = racingMuti;
        this.remark = remark;
    }

    public int getMatchType() {
        return matchType;
    }

    public void setMatchType(int matchType) {
        this.matchType = matchType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getRacingMuti() {
        return racingMuti;
    }

    public void setRacingMuti(double racingMuti) {
        this.racingMuti = racingMuti;
    }
}
