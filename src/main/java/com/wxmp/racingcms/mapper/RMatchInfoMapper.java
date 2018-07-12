package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RMatchInfo;
import java.util.List;

public interface RMatchInfoMapper {
    int insert(RMatchInfo record);

    List<RMatchInfo> selectAll();
}