package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.RUserCoinLog;
import java.util.List;

public interface RUserCoinLogMapper {
    int insert(RUserCoinLog record);

    List<RUserCoinLog> selectAll();
}