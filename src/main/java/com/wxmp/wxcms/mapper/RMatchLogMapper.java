package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.RMatchLog;
import java.util.List;

public interface RMatchLogMapper {
    int insert(RMatchLog record);

    List<RMatchLog> selectAll();
}