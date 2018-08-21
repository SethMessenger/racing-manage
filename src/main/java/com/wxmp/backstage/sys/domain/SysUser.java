package com.wxmp.backstage.sys.domain;

import com.wxmp.core.util.DateUtil;
import com.wxmp.core.util.UuidGenerator;
import com.wxmp.core.util.wx.MD5Util;
import com.wxmp.racingcms.vo.view.SysUserView;

import java.util.Date;

/**
 * @title : 系统管理用户
 * @description : 
 * @author : SethMessenger
 * @createtime : 2018年3月9日 下午5:32:25
*/
public class SysUser {
    
	/** 主键id */
	private String id;
	/** 用户名 */
	private String account;
	/** 密码 */
	private String pwd;
	/** 性别 0男 1女 */
	private String sex = "0";
	/** 手机号 */
	private String phone;
	/** 姓名 */
	private String trueName;
	/** 创建时间 */
	private String createTime;
	/** 更新时间 */
	private String updateTime;
	/** 状态 */
	private String flag;
	
	/** 新登录密码 */
	private String newpwd;

	public SysUser() {
	}

	public SysUser(SysUserView view) {
		this.id = UuidGenerator.getUUID32();
		this.account = view.getAccount();
		this.pwd = MD5Util.getMD5Code(view.getPwd());
		this.sex = "1";
		this.phone = view.getPhone();
		this.trueName = "trueName";
		this.createTime = DateUtil.COMMON_FULL.getDateText(new Date());
		this.updateTime = createTime;
		this.flag = "1";
		this.newpwd = view.getNewpwd();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}
	/**
	 * @param trueName the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the newpwd
	 */
	public String getNewpwd() {
		return newpwd;
	}
	/**
	 * @param newpwd the newpwd to set
	 */
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	
}
