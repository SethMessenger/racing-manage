package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RUserCoin;
import java.util.List;

public interface RUserCoinMapper {
    int insert(RUserCoin record);

    List<RUserCoin> selectAll();
}