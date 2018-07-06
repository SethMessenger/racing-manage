package com.wxmp.wxcms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wxmp.wxcms.domain.MsgBase;
import com.wxmp.wxcms.mapper.MsgBaseMapper;
import com.wxmp.wxcms.service.MsgBaseService;

import javax.annotation.Resource;


@Service
public class MsgBaseServiceImpl implements MsgBaseService{

	@Resource
	private MsgBaseMapper entityDao;

	public MsgBase getById(String id){
		return entityDao.getById(id);
	}

	public List<MsgBase> listForPage(MsgBase searchEntity){
		return entityDao.listForPage(searchEntity);
	}

	public void add(MsgBase entity){
		entityDao.add(entity);
	}

	public void update(MsgBase entity){
		entityDao.update(entity);
	}

	public void delete(MsgBase entity){
		entityDao.delete(entity);
	}



}