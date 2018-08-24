package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RSysuserUserRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RSysuserUserRelMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RSysuserUserRel record);

    int insertSelective(RSysuserUserRel record);

    RSysuserUserRel selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RSysuserUserRel record);

    int updateByPrimaryKey(RSysuserUserRel record);

    /**
     * 条件查询
     * @param userUuid
     * @param sysUserUuid
     * @param relType
     * @return
     */
    List<RSysuserUserRel> selectByCondition(@Param("userUuid") String userUuid, @Param("sysUserUuid") String sysUserUuid, @Param("relType")Integer relType);
}