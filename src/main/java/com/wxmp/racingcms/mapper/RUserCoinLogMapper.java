package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RUserCoinLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RUserCoinLogMapper {
    int insert(RUserCoinLog record);

    List<RUserCoinLog> selectAll();

    int insertBatch(@Param("list") List<RUserCoinLog> logs);
}