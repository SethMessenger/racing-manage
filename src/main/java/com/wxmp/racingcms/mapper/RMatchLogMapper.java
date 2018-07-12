package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RMatchLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RMatchLogMapper {

    int insert(RMatchLog record);

    List<RMatchLog> selectAll();

    List<RMatchLog> selectByCondition(@Param("filter") RMatchLog logCondition);
}