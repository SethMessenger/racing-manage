package com.wxmp.racingcms.service;

import com.wxmp.racingcms.domain.RUser;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc    客户端用户管理
 * @date 18/7/9
 */
public interface RUserService {

    /**
     * 主键查询
     * @param uuid
     * @return
     */
    RUser getById(String uuid);

    /**
     * 分页查询
     * @param entity
     * @return
     */
    List<RUser> listForPage(RUser entity);

    /**
     * 添加用户 TODO
     * @param entity
     */
    int add(RUser entity);

    /**
     * 更新用户信息
     * @param entity
     */
    void update(RUser entity);

    /**
     * 冻结用户
     * @param entity
     */
    void delete(RUser entity);
}
