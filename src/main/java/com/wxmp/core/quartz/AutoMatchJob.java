package com.wxmp.core.quartz;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.wxmp.core.log.CommonLog;
import com.wxmp.core.util.SpeedUtils;
import com.wxmp.racingapi.common.MatchTypeEnum;
import com.wxmp.racingapi.netty.ClientQuene;
import com.wxmp.racingapi.netty.MessageEnum;
import com.wxmp.racingapi.netty.ServerMessage;
import com.wxmp.racingapi.netty.service.WebSocketService;
import com.wxmp.racingapi.service.ArithmeticService;
import com.wxmp.racingapi.service.UserCoinService;
import com.wxmp.racingcms.domain.RMatchLog;
import com.wxmp.racingcms.domain.RMatchResult;
import com.wxmp.racingcms.mapper.RMatchLogMapper;
import com.wxmp.racingcms.mapper.RMatchResultMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
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
    @Autowired
    private WebSocketService webSocketService;

    /** 上次执行时间 */
    private static Long lastTime = System.currentTimeMillis();
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
            CommonLog.getLogger(AutoMatchJob.class).error(StringUtils.EMPTY, "getNextMatchCount ERROR ");
        }
        return 1000 * 60 * 60 * 24 * 7L;
    }

    /**
     * 生成赛程结果，每两分钟生成一个新的比赛，并将下个比赛进行入账，55秒开始，停顿5秒给前端长连接通知进行记账
     * 每分钟
     */
    @Scheduled(cron = "55 0/2 * * * ? ")
    public void autoMatchResult(){
        //提醒前端上传
        ServerMessage msg = ServerMessage.build(MessageEnum.EVENT_SERVER_AMOUNT, "", "");
        this.webSocketService.sendNotice(ClientQuene.getClients(), msg);
        try {
            Thread.sleep(5 * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        CommonLog.getLogger(AutoMatchJob.class).info(StringUtils.EMPTY, "Start autoMatchResult ");
        //结算上场
        this.settleLastMatch();
        //开启下场
        this.beginNextMatch();
        lastTime = System.currentTimeMillis();
        CommonLog.getLogger(AutoMatchJob.class).info(" {} ", "lastTime autoMatchResult " + new Date(lastTime));
        nextTime = lastTime + 2 * 60 * 1000L;
        CommonLog.getLogger(AutoMatchJob.class).info(" {} ", "nextTime autoMatchResult " + new Date(nextTime));
        CommonLog.getLogger(AutoMatchJob.class).info(StringUtils.EMPTY, "END autoMatchResult ");
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
//            RMatchResult f = new RMatchResult();
//            f.setUuid("3b6ed159897e4b6f8da96289aaee7221");
//            resultList = this.rMatchResultMapper.selectByCondition(f);

            RMatchResult lastMatch = resultList.get(0);
            //赛程ID
            String matchResultUuid = lastMatch.getUuid();
                //倍率
            RMatchLog logCondition = new RMatchLog();
            logCondition.setMatchResultUuid(matchResultUuid);
            List<RMatchLog> logs = this.rMatchLogMapper.selectByCondition(logCondition);
            // TODO 仍然将 几种赛制押注的结果 使用 冠军赛的权重算法进行生成
            List<List<Integer>> finals = this.arithmeticService.caculateMatchResult(logs);
            lastMatch.setMatchResult(JSON.toJSONString(finals));
            List<Integer> finalResult = finals.get(4);


            //分发奖品至用户账户
            Map<String, BigDecimal> userCoins = Maps.newHashMap();
            if(CollectionUtils.isNotEmpty(logs)){
                userCoins = this.settleUserCoins(finalResult, logs);
                this.userCoinService.withdrawAmountBatchOne(userCoins);
            }
            this.rMatchResultMapper.update(lastMatch);
        }else {
            //直接启动新的比赛
            return;
        }
    }

    /**
     * 根据当场比赛结果 和 押注记录生成用户 获奖记录
     * @param   finalResult
     * @param   userLogs
     * @return
     */
    private Map<String, BigDecimal> settleUserCoins(List<Integer> finalResult, List<RMatchLog> userLogs){
        Map<String, BigDecimal> userCoins = Maps.newHashMap();
        Integer champIndex = finalResult.get(0);
        Integer sendcond = finalResult.get(1);
        boolean isHit = false;
        for (RMatchLog log : userLogs){
            double mutiAmount = 0.0D;
            switch (log.getMatchType()){
                case 1:
                    mutiAmount = MatchTypeEnum.CHAMPS.getRacingMuti();
                    if(champIndex.equals(log.getCoinIndex())){
                        isHit = true;
                    }
                    break;
                case 2:
                    mutiAmount = MatchTypeEnum.CHAMP_SECONDS.getRacingMuti();
                    if(champIndex.equals(log.getCoinIndex()) || sendcond.equals(log.getCoinIndex())){
                        isHit = true;
                    }
                    break;
                case 3:
                    mutiAmount = MatchTypeEnum.SPEEDS.getRacingMuti();
                    if(SpeedUtils.checkSpeedsHit(finalResult, String.valueOf(log.getCoinIndex()))){
                        isHit = true;
                    }
                    break;
                default:
                    mutiAmount = 0.0;
                    break;
            }
            Long amount = log.getCoinAmount();
            if(isHit){
                String userUuid = log.getUserUuid();
                if(!userCoins.keySet().contains(log.getUserUuid())){
                    userCoins.put(userUuid, new BigDecimal(amount).multiply(new BigDecimal(mutiAmount)));
                }else {
                    BigDecimal plusAmount = new BigDecimal(amount).multiply(new BigDecimal(mutiAmount));
                    userCoins.put(userUuid, userCoins.get(userUuid).add(plusAmount));
                }
            }
        }
        return userCoins;
    }

    /**
     * 启动下场比赛进程
     */
    private void beginNextMatch(){
        //新建下一场比赛，状态为 新建
        RMatchResult newMatch = new RMatchResult(null, 0.0D, 0, null);
        CommonLog.getLogger(AutoMatchJob.class).info(StringUtils.EMPTY, "create r_match_result UUID " + newMatch.getUuid());
        this.rMatchResultMapper.insert(newMatch);
    }

}
