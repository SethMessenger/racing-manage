package com.wxmp.racingcms.domain;

import com.wxmp.core.util.UuidGenerator;

public class RSaleCard {
    private String uuid;

    private Integer isDel;

    private String creater;

    private String updater;

    private Long createTime;

    private Long updateTime;

    private Byte status;

    private Byte type;

    private Integer amount;

    private String createSysuserUuid;

    private String saleUserUuid;

    private Long saleTime;

    private String remark;

    private String cardNo;

    public RSaleCard() {
    }

    public RSaleCard(String creater, Byte type, Integer amount, String createSysuserUuid, String remark) {
        this.uuid = UuidGenerator.getUUID32();
        this.isDel = 0;
        this.creater = creater;
        this.updater = creater;
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
        this.status = 0;
        this.type = type;
        this.amount = amount;
        this.createSysuserUuid = createSysuserUuid;
        this.saleUserUuid = "";
        this.saleTime = 0L;
        this.remark = remark;
        this.cardNo = UuidGenerator.getStringRandom(8);
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCreateSysuserUuid() {
        return createSysuserUuid;
    }

    public void setCreateSysuserUuid(String createSysuserUuid) {
        this.createSysuserUuid = createSysuserUuid == null ? null : createSysuserUuid.trim();
    }

    public String getSaleUserUuid() {
        return saleUserUuid;
    }

    public void setSaleUserUuid(String saleUserUuid) {
        this.saleUserUuid = saleUserUuid == null ? null : saleUserUuid.trim();
    }

    public Long getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Long saleTime) {
        this.saleTime = saleTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}