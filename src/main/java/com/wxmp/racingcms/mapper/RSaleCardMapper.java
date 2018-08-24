package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RSaleCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RSaleCardMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RSaleCard record);

    int insertSelective(RSaleCard record);

    RSaleCard selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RSaleCard record);

    int updateByPrimaryKey(RSaleCard record);

    /**
     * 查询用户创建的充值卡
     * @param sysUserUuid
     * @return
     */
    List<RSaleCard> listForPage(@Param("sysUserUuid") String sysUserUuid);

    /**
     * 根据卡号查询充值卡
     * @param cardNo
     * @return
     */
    RSaleCard selectByCardNo(@Param("cardNo") String cardNo);
}