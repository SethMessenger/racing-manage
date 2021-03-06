package com.wxmp.racingcms.domain;

import com.wxmp.core.util.MD5Utils;
import com.wxmp.core.util.UuidGenerator;
import com.wxmp.racingapi.vo.form.UserRegisForm;
import org.apache.commons.lang.StringUtils;

public class RUser {
    private String uuid;

    private Integer isDel;

    private String creater;

    private String updater;

    private Long createTime;

    private Long updateTime;

    private String userName;

    private String userNickname;

    private String mobile;

    private String wechat;

    private String email;

    private String password;

    private String openId;

    private String other;

    public RUser() {
        super();
    }

    public RUser(String creater, UserRegisForm form) {
        this.uuid = UuidGenerator.getUUID32();
        this.isDel = 0;
        this.creater = creater;
        this.updater = creater;
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
        this.userName = form.getUserName();
        this.userNickname = form.getUserNickName();
        this.mobile = form.getMobile();
        if(StringUtils.isNotEmpty(form.getPwd())){
            this.password = MD5Utils.getPwd(form.getPwd());
        }else {
            /** MD5(666666) */
            this.password = "f379eaf3c831b04de153469d1bec345e";
        }
        this.openId = form.getOpenId();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}