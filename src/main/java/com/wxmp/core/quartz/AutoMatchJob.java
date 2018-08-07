package com.wxmp.core.quartz;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.core.util.wx.LogUtils;
import com.wxmp.racingapi.service.ArithmeticService;
import com.wxmp.racingapi.service.UserCoinService;
import com.wxmp.racingcms.domain.RMatchLog;
import com.wxmp.racingcms.domain.RMatchResult;
import com.wxmp.racingcms.mapper.RMatchLogMapper;
import com.wxmp.racingcms.mapper.RMatchResultMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * @author  xunbo.xu
 * @desc    定时开赛任务
 * @date 18/7/10
 */
@Component
public class AutoMatchJob {

    @Autowired
    private UserCoinService userCoinService;
    @Autowired
    private ArithmeticService arithmeticService;
    @Autowired
    private RMatchResultMapper rMatchResultMapper;
    @Autowired
    private RMatchLogMapper rMatchLogMapper;

    /** 上次执行时间 */
    private static Long lastTime;
    /** 下次执行时间 */
    private static Long nextTime;

    /**
     * 冠军赛赛程下场结算时间，倒计时ms为单位
     * @return
     */
    public Long getNextMatchCount(){
        try {
             //当前时间戳
             Long current = System.currentTimeMillis();
             return nextTime - current;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.console("getNextMatchCount ERROR !!!");
        }
        return 1000 * 60 * 60 * 24 * 7L;
    }

    /**
     * 生成赛程结果，每两分钟生成一个新的比赛，并将下个比赛进行入账
     * 每分钟
     */
    @Scheduled(cron = "0 0/2 * * * ? ")
    public void autoMatchResult(){
        LogUtils.console("Start autoMatchResult");
        //结算上场
        LogUtils.console("settleLastMatch autoMatchResult");
        this.settleLastMatch();
        //开启下场
        LogUtils.console("beginNextMatch autoMatchResult");
        this.beginNextMatch();
        LogUtils.console("lastTime autoMatchResult");
        lastTime = System.currentTimeMillis();
        LogUtils.console("nextTime autoMatchResult");
        nextTime = lastTime + 2 * 60 * 1000L;
        LogUtils.console("END autoMatchResult");
    }

    /**
     * 结算上场比赛结果
     */
    private void settleLastMatch(){
        //查询还未结束的比赛
        RMatchResult condition = new RMatchResult();
        condition.setMatchStatus(0);
        List<RMatchResult> resultList = this.rMatchResultMapper.selectByCondition(condition);
        if(CollectionUtils.isNotEmpty(resultList)){
            for (RMatchResult bean : resultList){
                bean.setMatchStatus(1);
            }
            //上一场比赛状态置为 封板
            this.rMatchResultMapper.updateBatch(resultList);
            //计算当前的投注量
            RMatchResult lastMatch = resultList.get(0);
                //赛程ID
            String matchResultUuid = resultList.get(0).getUuid();
                //倍率
            double mutiAmount = resultList.get(0).getMutiAmount();
            RMatchLog logCondition = new RMatchLog();
            logCondition.setMatchResultUuid(matchResultUuid);
            List<RMatchLog> logs = this.rMatchLogMapper.selectByCondition(logCondition);
            List<List<Integer>> finals = this.arithmeticService.caculateMatchResult(logs);
            List<Integer> finalResult = finals.get(4);
            Integer champIndex = finalResult.get(0);
            lastMatch.setMatchResult(JSON.toJSONString(finals));
            logCondition.setCoinIndex(champIndex);
            logs = this.rMatchLogMapper.selectByCondition(logCondition);
            //分发奖品至用户账户
            Map<String, BigDecimal> userCoins = Maps.newHashMap();
            if(CollectionUtils.isNotEmpty(logs)){
                for (RMatchLog log : logs){
                    String userUuid = log.getUserUuid();
                    Long amount = log.getCoinAmount();
                    if(!userCoins.keySet().contains(log.getUserUuid())){
                        userCoins.put(userUuid, new BigDecimal(amount).multiply(new BigDecimal(mutiAmount)));
                    }else {
                        BigDecimal plusAmount = new BigDecimal(amount).multiply(new BigDecimal(mutiAmount));
                        userCoins.put(userUuid, userCoins.get(userUuid).add(plusAmount));
                    }
                }
                this.userCoinService.withdrawAmountBatchOne(userCoins);
            }
            this.rMatchResultMapper.update(lastMatch);
        }else {
            //直接启动新的比赛
            return;
        }
    }

    /**
     * 启动下场比赛进程
     */
    private void beginNextMatch(){
        //新建下一场比赛，状态为 新建
        RMatchResult newMatch = new RMatchResult(null, RacingConstants.RACING_CHAMP_MUTI, 0, null);
        LogUtils.console("create r_match_result UUID = " + newMatch.getUuid());
        this.rMatchResultMapper.insert(newMatch);
    }

}
