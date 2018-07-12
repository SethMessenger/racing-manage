package com.wxmp.racingcms.domain;

import com.wxmp.core.util.UuidGenerator;

public class RUserCoinLog {
    private String uuid;

    private Integer isDel;

    private String creater;

    private String updater;

    private Long createTime;

    private Long updateTime;

    /** 用户唯一标志 */
    private String userUuid;

    /** 用户账户uuid */
    private String userCoinUuid;

    /** 账户入账类型，0金币出账，1金币入账 2人民币入账 3人民币出账（不允许） */
    private Integer logType;

    /** 入账金额 */
    private Long coinAmount;

    /** 备注 */
    private String remark;

    /**
     * 构造
     * @param userUuid      当前用户uuid
     * @param userCoinUuid  用户账户uuid
     * @param logType       账户入账类型，0金币出账，1金币入账 2人民币入账 3人民币出账（不允许）
     * @param coinAmount    入账金额
     * @param remark        备注
     */
    public RUserCoinLog(String userUuid, String userCoinUuid, Integer logType, Long coinAmount, String remark){
        this.uuid = UuidGenerator.getUUID32();
        this.isDel = 0;
        this.creater = userUuid;
        this.updater = userUuid;
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
        this.userUuid = userUuid;
        this.userCoinUuid = userCoinUuid;
        this.logType = logType;
        this.coinAmount = coinAmount;
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

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getUserCoinUuid() {
        return userCoinUuid;
    }

    public void setUserCoinUuid(String userCoinUuid) {
        this.userCoinUuid = userCoinUuid == null ? null : userCoinUuid.trim();
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
}