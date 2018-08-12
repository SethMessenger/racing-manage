package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RSysuserUserRel;

public interface RSysuserUserRelMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RSysuserUserRel record);

    int insertSelective(RSysuserUserRel record);

    RSysuserUserRel selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RSysuserUserRel record);

    int updateByPrimaryKey(RSysuserUserRel record);
}