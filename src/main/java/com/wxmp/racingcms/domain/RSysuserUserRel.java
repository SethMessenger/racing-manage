package com.wxmp.racingcms.domain;

public class RSysuserUserRel {
    private String uuid;

    private Integer isDel;

    private String creater;

    private String updater;

    private Long createTime;

    private Long updateTime;

    private String userUuid;

    private String sysuserUuid;

    private String sysuserUserUuid;

    private Byte relType;

    private String remark;

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

    public String getSysuserUuid() {
        return sysuserUuid;
    }

    public void setSysuserUuid(String sysuserUuid) {
        this.sysuserUuid = sysuserUuid == null ? null : sysuserUuid.trim();
    }

    public String getSysuserUserUuid() {
        return sysuserUserUuid;
    }

    public void setSysuserUserUuid(String sysuserUserUuid) {
        this.sysuserUserUuid = sysuserUserUuid == null ? null : sysuserUserUuid.trim();
    }

    public Byte getRelType() {
        return relType;
    }

    public void setRelType(Byte relType) {
        this.relType = relType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}