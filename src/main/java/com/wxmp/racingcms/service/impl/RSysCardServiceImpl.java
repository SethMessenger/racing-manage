package com.wxmp.racingcms.service.impl;

import com.wxmp.racingcms.domain.RSaleCard;
import com.wxmp.racingcms.mapper.RSaleCardMapper;
import com.wxmp.racingcms.service.RSysCardService;
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
public class RSysCardServiceImpl implements RSysCardService{

    @Autowired
    private RSaleCardMapper saleCardMapper;

    /**
     * 主键查询
     *
     * @param uuid
     * @return
     */
    @Override
    public RSaleCard getById(String uuid) {
        return this.saleCardMapper.selectByPrimaryKey(uuid);
    }

    /**
     * 分页查询
     *
     * @param sysUserUuid
     * @return
     */
    @Override
    public List<RSaleCard> listForPage(String sysUserUuid) {
        return this.saleCardMapper.listForPage(sysUserUuid);
    }

    /**
     * 添加新卡片
     *
     * @param entity
     */
    @Override
    public int add(RSaleCard entity) {
        return this.saleCardMapper.insert(entity);
    }

    /**
     * 更新用户信息
     *
     * @param entity
     */
    @Override
    public void update(RSaleCard entity) {
        this.saleCardMapper.updateByPrimaryKey(entity);
    }

    /**
     * 冻结用户
     *
     * @param entity
     */
    @Override
    public void delete(RSaleCard entity) {
        this.saleCardMapper.deleteByPrimaryKey(entity.getUuid());
    }

}
