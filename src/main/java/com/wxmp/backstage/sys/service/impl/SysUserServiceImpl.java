package com.wxmp.backstage.sys.service.impl;
import com.wxmp.core.util.SessionUtils;
import com.wxmp.racingcms.domain.RSysuserUserRel;
import com.wxmp.racingcms.mapper.RSysuserUserRelMapper;
import com.wxmp.racingcms.mapper.RUserCoinMapper;
import com.wxmp.racingcms.mapper.RUserMapper;
import com.wxmp.racingcms.vo.view.SysUserView;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxmp.backstage.sys.service.ISysUserService;
import com.wxmp.backstage.sys.domain.SysUser;
import com.wxmp.backstage.sys.mapper.SysUserDao;

import javax.annotation.Resource;
import java.util.List;


/**
 * 
 * @title : 
 * @description : 
 * @projectname : wxmp
 * @classname : SysUserServiceImpl
 * @version 1.0
 * @author : sw_jee_dev
 * @createtime : 2017年4月2日 上午10:05:11
 */

@Service
public class SysUserServiceImpl  implements ISysUserService{

	@Resource
	private SysUserDao sysUserDao;
	@Resource
	private RUserMapper userMapper;
	@Resource
	private RUserCoinMapper coinMapper;
	@Resource
	private RSysuserUserRelMapper relMapper;
	
	
	
	@Override
	public boolean isAccount(String account) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public SysUser getSysUser(SysUser sysUser) {
		SysUser resUser = null;
		
		resUser = this.sysUserDao.getSysUser(sysUser);

		if(resUser != null){
			return resUser;
		}else{
			return null;
		}
	}


	/* (non-Javadoc)
	 * @see com.wxmp.backstage.sys.ISysUserService#getSysUserById(java.lang.String)
	 */
	@Override
	public SysUser getSysUserById(String userId) {
		SysUser resUser = null;
		
		resUser = this.sysUserDao.getSysUserById(userId);

		if(resUser != null){
			return resUser;
		}else{
			return null;
		}
	}


	@Override
	public int updateLoginPwd(SysUser sysUser) {
		int n = 0;
		try {
			sysUserDao.updateLoginPwd(sysUser);
			n = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}

	/**
	 * 系统用户信息管理
	 *
	 * @param searchEntity
	 * @return
	 */
	@Override
	public List<SysUserView> getSysUserList(SysUser searchEntity) {
		return this.sysUserDao.getSysUserList(searchEntity);
	}

	/**
	 * 添加系统运营用户，并且关联账户
	 *
	 * @param sysUser
	 */
	@Override
	public void addSysUserInfo(SysUserView sysUser, SysUser sys) {
		if(null != sysUser && null != sys){
			if(StringUtils.isNotEmpty(sysUser.getUserUuid())){
				//TODO 检查当前用户是否已经被关联过

				//添加系统用户，增加关联记录
				SysUser newSysUser = new SysUser(sysUser);
				this.sysUserDao.insert(newSysUser);
				RSysuserUserRel rel = new RSysuserUserRel(sys.getId(), sysUser.getUserUuid(), newSysUser.getId(), (byte)0, "remark");
				this.relMapper.insert(rel);
			}else {
				throw new RuntimeException("userUuid 不能为空");
			}
		}

	}

}
