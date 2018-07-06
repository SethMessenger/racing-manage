package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.RMatchInfo;
import java.util.List;

public interface RMatchInfoMapper {
    int insert(RMatchInfo record);

    List<RMatchInfo> selectAll();
}