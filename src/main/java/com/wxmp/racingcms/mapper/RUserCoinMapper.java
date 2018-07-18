package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RUserCoin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RUserCoinMapper {

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(RUserCoin record);

    /**
     * 查询全部
     * @return
     */
    List<RUserCoin> selectAll();

    /**
     * 条件查询
     * @param userCoinCondition
     * @return
     */
    List<RUserCoin> selectByCondition(@Param("filter") RUserCoin userCoinCondition);

    /**
     * 账户进出账
     * @param useruuid
     * @param amount
     * @return
     */
    int dealWithCoins(@Param("useruuid") String useruuid, @Param("amount") int amount);

}