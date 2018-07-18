package com.wxmp.racingcms.domain;

import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.core.util.UuidGenerator;

public class RMatchLog {
    private String uuid;

    private Integer isDel;

    private String creater;

    private String updater;

    private Long createTime;

    private Long updateTime;
    /** 赛程uuid */
    private String matchResultUuid;
    /** 用户uuid */
    private String userUuid;
    /** 账户入账类型，0押注金币, 1系统发奖金币 */
    private Integer logType;
    /**  */
    private Long coinAmount;
    /**  */
    private String remark;
    /**  */
    private Integer coinIndex;

    public RMatchLog(){super();}

    public RMatchLog(String matchResultUuid, String userUuid, Integer logType, Long coinAmount, Integer coinIndex, String remark){
        this.uuid = UuidGenerator.getUUID32();
        this.isDel = 0;
        this.creater = RacingConstants.RACING_SYS_ACCOUNT;
        this.updater = creater;
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
        this.matchResultUuid = matchResultUuid;
        this.userUuid = userUuid;
        this.logType = logType;
        this.coinAmount = coinAmount;
        this.coinIndex = coinIndex;
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

    public String getMatchResultUuid() {
        return matchResultUuid;
    }

    public void setMatchResultUuid(String matchResultUuid) {
        this.matchResultUuid = matchResultUuid == null ? null : matchResultUuid.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Long getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(Long coinAmount) {
        this.coinAmount = coinAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCoinIndex() {
        return coinIndex;
    }

    public void setCoinIndex(Integer coinIndex) {
        this.coinIndex = coinIndex;
    }
}