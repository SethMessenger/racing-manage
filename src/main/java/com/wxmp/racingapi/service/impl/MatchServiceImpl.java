package com.wxmp.racingapi.service.impl;

import com.wxmp.core.log.CommonLog;
import com.wxmp.core.quartz.AutoMatchJob;
import com.wxmp.core.util.JSONUtil;
import com.wxmp.racingapi.service.MatchService;
import com.wxmp.racingapi.vo.view.MatchDetailResultView;
import com.wxmp.racingapi.vo.view.MatchDetailView;
import com.wxmp.racingcms.domain.RMatchResult;
import com.wxmp.racingcms.domain.RMatchType;
import com.wxmp.racingcms.mapper.RMatchResultMapper;
import com.wxmp.racingcms.mapper.RMatchTypeMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MatchServiceImpl implements MatchService{

    @Autowired
    private RMatchTypeMapper matchTypeMapper;
    @Autowired
    private RMatchResultMapper matchResultMapper;
    @Autowired
    private AutoMatchJob autoMatchJob;

    /**
     * 查询当前赛程
     *
     * @param matchType
     * @return
     */
    @Override
    public RMatchType queryMatchDetail(Integer matchType) {
        RMatchType condiiton = new RMatchType();
        condiiton.setMatchType(matchType);
        List<RMatchType> matchs = this.matchTypeMapper.selectByCondition(condiiton);
        if(CollectionUtils.isNotEmpty(matchs)){
            return matchs.get(0);
        }
        return null;
    }

    /**
     * 查询最近赛程&赛果
     *
     * @param matchType
     * @return
     */
    @Override
    public MatchDetailView queryMatchResults(Integer matchType) {
        MatchDetailView view = null;
        RMatchType type = this.queryMatchDetail(matchType);
        if(null != type){
            view = new MatchDetailView(type);
            //查询该赛制下的赛程最近概况
            RMatchResult condition = new RMatchResult();
            condition.setMatchType(matchType);
            List<RMatchResult> results = this.matchResultMapper.selectByCondition(condition);
            if(CollectionUtils.isNotEmpty(results)){
                view = new MatchDetailView(type, results, this.autoMatchJob.getNextMatchCount());
            }
        }
        CommonLog.getLogger(MatchServiceImpl.class).info(StringUtils.EMPTY, "MatchServiceImpl queryMatchResults : " + JSONUtil.objectToJson(view));
        return view;
    }

    /**
     * 查询指定比赛的结果
     * @param matchResultUuid
     *
     * @return
     */
    @Override
    public MatchDetailResultView queryMatchDetailRequest(String matchResultUuid) {
        RMatchResult condition = new RMatchResult();
        condition.setUuid(matchResultUuid);
        List<RMatchResult> results = this.matchResultMapper.selectByCondition(condition);
        if(CollectionUtils.isNotEmpty(results)){
            RMatchResult result = results.get(0);
            return new MatchDetailResultView(result);
        }
        return null;
    }
}
