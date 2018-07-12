package com.wxmp.racingcms.mapper;

import com.wxmp.racingcms.domain.RMatchResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RMatchResultMapper {

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(RMatchResult record);

    /**
     * 查询全部
     * @return
     */
    List<RMatchResult> selectAll();

    /**
     * 条件查询
     * @param filter
     * @return
     */
    List<RMatchResult> selectByCondition(@Param("filter") RMatchResult filter);

    /**
     * 批量更新
     * @param resultList
     * @return
     */
    int updateBatch(@Param("list") List<RMatchResult> resultList);

    /**
     * 更新
     * @param lastMatch
     * @return
     */
    int update(RMatchResult lastMatch);
}