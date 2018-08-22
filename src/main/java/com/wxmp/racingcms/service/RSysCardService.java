package com.wxmp.racingcms.service;

import com.wxmp.racingcms.domain.RSaleCard;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/23
 */
public interface RSysCardService {

    RSaleCard getById(String uuid);

    List<RSaleCard> listForPage(String sysUserUuid);

    int add(RSaleCard entity);

    void update(RSaleCard entity);

    void delete(RSaleCard entity);
}
