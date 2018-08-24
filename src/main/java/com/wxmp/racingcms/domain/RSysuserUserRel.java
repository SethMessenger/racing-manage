package com.wxmp.racingcms.domain;

import com.wxmp.core.util.UuidGenerator;

public class RSysuserUserRel {
    private String uuid;

    private Integer isDel;

    private String creater;

    private String updater;

    private Long createTime;

    private Long updateTime;

    private String userUuid;

    private String sysuserUuid;

    /** 关联类型，0 后端运营账户一对多关联前端用户 1 运营用户关联客户端分销 */
    private Byte relType;

    private String remark;

    public RSysuserUserRel(String creater, String userUuid, String sysuserUuid, Byte relType, String remark) {
        this.uuid = UuidGenerator.getUUID32();
        this.isDel = 0;
        this.creater = creater;
        this.updater = creater;
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;

        this.userUuid = userUuid;
        this.sysuserUuid = sysuserUuid;
        this.relType = relType;
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

    public String getSysuserUuid() {
        return sysuserUuid;
    }

    public void setSysuserUuid(String sysuserUuid) {
        this.sysuserUuid = sysuserUuid == null ? null : sysuserUuid.trim();
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