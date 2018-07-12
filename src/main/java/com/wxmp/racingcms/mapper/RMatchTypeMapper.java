package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RMatchType;
import java.util.List;

public interface RMatchTypeMapper {
    int insert(RMatchType record);

    List<RMatchType> selectAll();
}