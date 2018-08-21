package com.wxmp.backstage.sys.service;

import com.wxmp.backstage.sys.domain.SysUser;
import com.wxmp.racingcms.vo.view.SysUserView;

import java.util.List;


/***
 * 
 * @title : 
 * @description : 
 * @projectname : wxmp
 * @classname : ISysUserService
 * @version 1.0
 * @author : sw_jee_dev
 * @createtime : 2017年4月2日 上午10:04:02
 */
public interface ISysUserService {

	/**
	 * 帐号是否存在
	 * @param account
	 * @return
	 */
	public boolean isAccount(String account);
	
	public SysUser getSysUser(SysUser sysUser);
	
	public SysUser getSysUserById(String userId);
	
	public int updateLoginPwd(SysUser sysUser);

	/**
	 * 系统用户信息管理
	 * @param searchEntity
	 * @param relType
	 * @return
	 */
	List<SysUserView> getSysUserList(SysUser searchEntity, Integer relType);

	/**
	 * 添加系统运营用户，并且关联账户
	 * @param sysUser
	 */
	void addSysUserInfo(SysUserView sysUser, SysUser sys);
}
