package com.wxmp.racingcms.service.impl;

import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.mapper.RUserMapper;
import com.wxmp.racingcms.service.RUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RUserServiceImpl implements RUserService{

    @Autowired
    private RUserMapper rUserMapper;

    /**
     * 主键查询
     *
     * @param uuid
     * @return
     */
    @Override
    public RUser getById(String uuid) {
        return this.rUserMapper.getById(uuid);
    }

    /**
     * 分页查询
     *
     * @param entity
     * @return
     */
    @Override
    public List<RUser> listForPage(RUser entity) {
        return this.rUserMapper.listForPage(entity);
    }

    /**
     * 添加用户 TODO
     *
     * @param entity
     */
    @Override
    public int add(RUser entity) {
        return this.rUserMapper.insert(entity);
    }

    /**
     * 更新用户信息
     *
     * @param entity
     */
    @Override
    public void update(RUser entity) {
        this.rUserMapper.update(entity);
    }

    /**
     * 冻结用户
     *
     * @param entity
     */
    @Override
    public void delete(RUser entity) {
        this.rUserMapper.deleteUser(entity.getUuid());
    }
}
