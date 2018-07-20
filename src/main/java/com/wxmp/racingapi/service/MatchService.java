package com.wxmp.racingapi.service;

import com.wxmp.racingapi.vo.view.MatchDetailResultView;
import com.wxmp.racingapi.vo.view.MatchDetailView;
import com.wxmp.racingcms.domain.RMatchType;


/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/6
 */
public interface MatchService {

    /**
     * 查询当前赛程
     * @param matchType
     * @return
     */
    RMatchType queryMatchDetail(Integer matchType);


    /**
     * 查询最近赛程&赛果
     * @param matchType
     * @return
     */
    MatchDetailView queryMatchResults(Integer matchType);

    /**
     * 查询指定比赛的结果
     * @param matchResultUuid
     * @return
     */
    MatchDetailResultView queryMatchDetailRequest(String matchResultUuid);



}
