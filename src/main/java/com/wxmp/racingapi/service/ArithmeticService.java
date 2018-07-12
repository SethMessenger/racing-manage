package com.wxmp.racingapi.service;

import com.wxmp.racingcms.domain.RMatchLog;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    赛果算法核心业务<br/>
 *          参与人数
 *          总的押注金额
 *
 * @date 18/7/10
 */
public interface ArithmeticService {

    /**
     * 计算指定赛程的比赛结果
     * @param matchLogs
     */
    List<List<Integer>> caculateMatchResult(List<RMatchLog> matchLogs);


}
