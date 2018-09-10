package com.wxmp.racingcms.mapper;

import com.wxmp.racingapi.vo.dto.UserMatchLogDTO;
import com.wxmp.racingcms.domain.RMatchLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RMatchLogMapper {

    int insert(RMatchLog record);

    List<RMatchLog> selectAll();

    List<RMatchLog> selectByCondition(@Param("filter") RMatchLog logCondition);

    List<UserMatchLogDTO> queryUserMatchLogs(@Param("userUuid") String userUuid, @Param("startTime")  long startTime, @Param("endTime")  long endTime);
}