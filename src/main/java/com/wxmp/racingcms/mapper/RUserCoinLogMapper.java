package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RUserCoinLog;
import java.util.List;

public interface RUserCoinLogMapper {
    int insert(RUserCoinLog record);

    List<RUserCoinLog> selectAll();

    int insertBatch(List<RUserCoinLog> logs);
}