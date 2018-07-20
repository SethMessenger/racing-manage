package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RMatchType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RMatchTypeMapper {

    int insert(RMatchType record);

    List<RMatchType> selectAll();

    List<RMatchType> selectByCondition(@Param("filter") RMatchType userCoinCondition);
}