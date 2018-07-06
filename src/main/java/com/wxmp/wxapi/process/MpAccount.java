package com.wxmp.wxapi.process;

import java.io.Serializable;

/**
 * 微信公众号信息
 * @author SethMessenger
 */
public class MpAccount implements Serializable{
	private static final long serialVersionUID = -6315146640254918207L;

	/** 账号 */
	private String account;
	/** appsecret */
	private String appsecret;
	/** 验证时用的url */
	private String url;
	/** token */
	private String token;
	/** appid */
	private String appid;
	/** 关联的公司id */
	private String companyId;

	/** 自动回复消息条数;默认是5条 */
	private Integer msgcount;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCompanyId() { return companyId; }
	public void setCompanyId(String companyId) { this.companyId = companyId; }
	public Integer getMsgcount() {
		if(msgcount == null){
			//默认5条
			msgcount = 5;
		}
		return msgcount;
	}

	public void setMsgcount(Integer msgcount) {
		this.msgcount = msgcount;
	}
}
