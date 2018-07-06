package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.RUserCoin;
import java.util.List;

public interface RUserCoinMapper {
    int insert(RUserCoin record);

    List<RUserCoin> selectAll();
}