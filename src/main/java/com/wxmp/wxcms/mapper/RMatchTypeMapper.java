package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.RMatchType;
import java.util.List;

public interface RMatchTypeMapper {
    int insert(RMatchType record);

    List<RMatchType> selectAll();
}