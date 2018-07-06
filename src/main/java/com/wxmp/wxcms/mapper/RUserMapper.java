package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.RUser;
import java.util.List;

public interface RUserMapper {
    int insert(RUser record);

    List<RUser> selectAll();
}