package com.wxmp.core.domain;

import java.util.Date;

public class BaseEntity {

	/** id */
	private Long id;
	/** 创建时间 */
	private Date createtime = new Date();
	
	
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
