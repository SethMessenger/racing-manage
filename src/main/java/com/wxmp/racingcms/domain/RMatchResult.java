package com.wxmp.racingcms.domain;

import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.core.util.UuidGenerator;

public class RMatchResult {
    private String uuid;

    private Integer isDel;

    private String creater;

    private String updater;

    private Long createTime;

    private Long updateTime;

    /** 比赛类型 */
    private Integer matchType;

    /** 赛果 */
    private String matchResult;

    /** 胜后倍率 */
    private Double mutiAmount;

    /** 备注 */
    private String remark;

    /** 0新建，接收投注 1封板，停止下注' */
    private Integer matchStatus;

    public RMatchResult(){super();}

    /**
     * 构造
     * @param matchResult
     * @param mutiAmount
     * @param matchStatus
     * @param remark
     */
    public RMatchResult(String matchResult, Double mutiAmount, Integer matchStatus, String remark){
        this.uuid = UuidGenerator.getUUID32();
        this.isDel = 0;
        this.creater = RacingConstants.RACING_SYS_ACCOUNT;
        this.updater = creater;
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
        this.matchType = 1;
        this.matchResult = matchResult;
        this.mutiAmount = mutiAmount;
        this.matchStatus = matchStatus;
        this.remark = remark;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult == null ? null : matchResult.trim();
    }

    public Double getMutiAmount() {
        return mutiAmount;
    }

    public void setMutiAmount(Double mutiAmount) {
        this.mutiAmount = mutiAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(Integer matchStatus) {
        this.matchStatus = matchStatus;
    }
}