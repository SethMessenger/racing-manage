package com.wxmp.wxcms.domain;

import java.util.Date;

import com.wxmp.wxapi.process.MpAccount;

/**
 * 微信公众账号
 */
public class Account extends MpAccount{

	/** 名称 */
	private String name;
	/** id */
	private Long id;
	/** 创建时间 */
	private Date createtime = new Date();
	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}