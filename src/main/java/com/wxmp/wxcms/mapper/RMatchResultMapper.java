package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.RMatchResult;
import java.util.List;

public interface RMatchResultMapper {
    int insert(RMatchResult record);

    List<RMatchResult> selectAll();
}