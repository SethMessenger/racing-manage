package com.wxmp.racingapi.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.core.log.CommonLog;
import com.wxmp.core.util.DateUtil;
import com.wxmp.core.util.JSONUtil;
import com.wxmp.core.util.SpeedUtils;
import com.wxmp.racingapi.common.MatchTypeEnum;
import com.wxmp.racingapi.common.RacingRankInstance;
import com.wxmp.racingapi.service.UserCoinService;
import com.wxmp.racingapi.vo.dto.UserMatchLogDTO;
import com.wxmp.racingapi.vo.form.UserPayAllForm;
import com.wxmp.racingapi.vo.view.RankView;
import com.wxmp.racingapi.vo.view.UserMatchLogView;
import com.wxmp.racingapi.vo.view.UserRankDetailView;
import com.wxmp.racingapi.vo.view.UserRankView;
import com.wxmp.racingapi.vo.vo.UserPayDetailForm;
import com.wxmp.racingapi.vo.vo.UserPaySpeedDetailForm;
import com.wxmp.racingcms.domain.RMatchLog;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.domain.RUserCoinLog;
import com.wxmp.racingcms.mapper.RMatchLogMapper;
import com.wxmp.racingcms.mapper.RUserCoinLogMapper;
import com.wxmp.racingcms.mapper.RUserCoinMapper;
import com.wxmp.racingcms.mapper.RUserMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xunbo.xu
 * @desc    用户下注账户操作
 * @date 18/7/11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserCoinServiceImpl implements UserCoinService{

    private static final CommonLog logger = CommonLog.getLogger(UserCoinServiceImpl.class);

    @Autowired
    private RUserCoinLogMapper rUserCoinLogMapper;
    @Autowired
    private RUserCoinMapper rUserCoinMapper;
    @Autowired
    private RMatchLogMapper rMatchLogMapper;
    @Autowired
    private RUserMapper rUserMapper;

    /**
     * 查询参赛记录
     *
     * @param userUuid
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<UserMatchLogView> queryUserMatchLogs(String userUuid, long startTime, long endTime) {
        List<UserMatchLogView> views = Lists.newArrayList();
        List<UserMatchLogDTO> dtos = this.rMatchLogMapper.queryUserMatchLogs(userUuid, startTime, endTime);
        System.out.println(startTime + " : " + endTime);
        if(CollectionUtils.isNotEmpty(dtos)){
            for(UserMatchLogDTO item : dtos){
                String matchResultUuid = item.getMatchResultUuid();
                Integer matchType = item.getMatchType();
                long amount = item.getCoinAmount();
                Integer wins = item.getCoinIndex();
                Long matchTimeLong = item.getCreateTime();
                String matchTime = DateUtil.COMMON_FULL.getDateText(new Date(matchTimeLong));
                UserMatchLogView view = new UserMatchLogView(matchResultUuid, matchType, amount, wins, matchTime);
                views.add(view);
            }
        }
        return views;
    }

    @Override
    public RankView queryUserMatchRank(String userUuid){
        RankView result = new RankView();
        List<UserRankDetailView> todays = Lists.newArrayList();
        RUser user = this.rUserMapper.getById(userUuid);
        if(null != user){
            //TODO 查询当前所有用户的押注记录

            List<UserRankView> ranks = RacingRankInstance.getRacingRank(Lists.newArrayList());
            int index = 1;
            for (UserRankView view : ranks){
                UserRankDetailView v = new UserRankDetailView(index, view.getIcon(), view.getName(), view.getRank());
                todays.add(v);
                index++;
            }
            result.setTodays(todays);
            result.setUserNickName(user.getUserNickname());
            //result.setTodaysRank();
        }
        return result;
    }

    /**
     * 下注全部
     * @param userUuid
     * @param form
     */
    @Override
    public void payAllMatch(String userUuid, UserPayAllForm form){
        logger.info(" {} : ", " payAllMatch ", JSONUtil.objectToJson(form));
        //校验在contr层已经完毕
        String matchUuid = form.getMatchUuid();
        if(CollectionUtils.isNotEmpty(form.getChampSeconds())){
            for (UserPayDetailForm item : form.getChamps()){
                try {
                    this.payMatch(MatchTypeEnum.CHAMPS.getMatchType(), userUuid, item.getAmount(), matchUuid, Integer.valueOf(item.getWins()));
                }catch (Exception e){
                    logger.error(e, " {} : ", " payAllMatch ");
                    continue;
                }
            }
        }
        if(CollectionUtils.isNotEmpty(form.getChampSeconds())){
            for (UserPayDetailForm item : form.getChampSeconds()){
                try {
                    this.payMatch(MatchTypeEnum.CHAMP_SECONDS.getMatchType(), userUuid, item.getAmount(), matchUuid, Integer.valueOf(item.getWins()));
                }catch (Exception e){
                    logger.error(e, " {} : ", " payAllMatch ");
                    continue;
                }
            }
        }
        /** 竞速赛 */
        if(CollectionUtils.isNotEmpty(form.getSpeeds())){
            for (UserPaySpeedDetailForm item : form.getSpeeds()){
                try {
                    //押注冠军
                    this.payMatch(MatchTypeEnum.SPEEDS.getMatchType(), userUuid, item.getFirst().getAmount(), matchUuid,
                            SpeedUtils.createMatchCoins(Integer.valueOf(item.getFirst().getWins()), Integer.valueOf(item.getFirst().getWins()), Integer.valueOf(item.getSecond().getWins())));
                    //押注亚军
                    this.payMatch(MatchTypeEnum.SPEEDS.getMatchType(), userUuid, item.getSecond().getAmount(), matchUuid,
                            SpeedUtils.createMatchCoins(Integer.valueOf(item.getSecond().getWins()), Integer.valueOf(item.getFirst().getWins()), Integer.valueOf(item.getSecond().getWins())));
                }catch (Exception e){
                    logger.error(e, " {} : ", " payAllMatch ");
                    continue;
                }
            }
        }
    }

    /**
     * 押注
     *
     * @param matchType 比赛类型 比赛下注类型  1冠军赛 2冠亚军赛 3竞速赛
     * @param userUuid  账户uuid
     * @param amount    金额
     * @param matchUuid 赛程ID
     * @param winsIndex 下注对象
     * @return
     */
    @Override
    public boolean payMatch(Integer matchType, String userUuid, long amount, String matchUuid, Integer winsIndex) {
        //用户扣费
        if(this.rechargeAmount(userUuid, new BigDecimal(amount))){
            //增加比赛操作日志
            RMatchLog matchLog = new RMatchLog(matchType, matchUuid, userUuid, 0, amount, winsIndex, null);
            this.rMatchLogMapper.insert(matchLog);
            return true;
        }
        return false;
    }

    /**
     * 用户金币出账(扣费)
     *
     * @param useruuid
     * @param amount
     * @return
     */
    @Override
    public boolean rechargeAmount(String useruuid, BigDecimal amount) {
        if(this.rUserCoinMapper.dealWithCoins(useruuid, - amount.intValue()) > 0){
            RUserCoinLog log = new RUserCoinLog(useruuid, "", 0, amount.longValue(), null);
            if(this.rUserCoinLogMapper.insert(log) > 0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * 用户金币入账(充值)
     *
     * @param useruuid
     * @param amount
     * @return
     */
    @Override
    public boolean withdrawAmount(String useruuid, BigDecimal amount) {
        if(this.rUserCoinMapper.dealWithCoins(useruuid, amount.intValue()) > 0){
            RUserCoinLog log = new RUserCoinLog(useruuid, "", 1, amount.longValue(), null);
            if(this.rUserCoinLogMapper.insert(log) > 0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * 用户人民币进账，仅允许整数充值
     * @param useruuid
     * @param amount
     * @return
     */
    @Override
    public boolean withdrawRMBAmount(String useruuid, BigDecimal amount){
        BigDecimal rmb = amount.multiply(new BigDecimal(RacingConstants.RACING_RMB_RATE));
        if(this.rUserCoinMapper.dealWithCoins(useruuid, rmb.intValue()) > 0){
            RUserCoinLog log = new RUserCoinLog(useruuid, "", 2, amount.longValue(), null);
            if(this.rUserCoinLogMapper.insert(log) > 0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * 用户金币集中入账(充值)<br/>
     *
     * @param userCoin
     * @return
     */
    @Override
    public boolean withdrawAmountBatchOne(Map<String, BigDecimal> userCoin) {
        if(MapUtils.isNotEmpty(userCoin)){
            List<RUserCoinLog> logs = Lists.newArrayList();
            for (String useruuid : userCoin.keySet()){
                if(null != userCoin.get(useruuid)){
                    //金币入账
                    RUserCoinLog log = new RUserCoinLog(useruuid, "", 1, userCoin.get(useruuid).longValue(), null);
                    logs.add(log);
                    this.rUserCoinMapper.dealWithCoins(useruuid, userCoin.get(useruuid).intValue());
                }
            }
            if(logs.size() > 0){
                if(this.rUserCoinLogMapper.insertBatch(logs) > 0){
                    return true;
                }else {
                    return false;
                }
            }
        }
        //无人中奖
        return false;
    }

    /**
     * 用户金币集中入账(充值)
     *
     * @param userCoin
     * @return
     */
    @Override
    public boolean withdrawAmountBatchMuti(Map<String, List<BigDecimal>> userCoin) {
        Map<String, BigDecimal> simpleUserCoin = Maps.newHashMap();
        if(MapUtils.isNotEmpty(userCoin)){
            for (String useruuid : userCoin.keySet()){
                if(CollectionUtils.isNotEmpty(userCoin.get(useruuid))){
                    BigDecimal userTotal = new BigDecimal(0);
                    for (BigDecimal amount : userCoin.get(useruuid)){
                        userTotal.add(amount);
                    }
                    //计算每个用户进账总额
                    simpleUserCoin.put(useruuid, userTotal);
                }
            }
            //启动充值流程
            this.withdrawAmountBatchOne(simpleUserCoin);
        }
        return false;
    }

}
