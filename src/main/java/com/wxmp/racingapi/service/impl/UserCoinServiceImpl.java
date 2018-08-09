package com.wxmp.racingapi.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.racingapi.service.UserCoinService;
import com.wxmp.racingcms.domain.RMatchLog;
import com.wxmp.racingcms.domain.RUserCoinLog;
import com.wxmp.racingcms.mapper.RMatchLogMapper;
import com.wxmp.racingcms.mapper.RUserCoinLogMapper;
import com.wxmp.racingcms.mapper.RUserCoinMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Autowired
    private RUserCoinLogMapper rUserCoinLogMapper;
    @Autowired
    private RUserCoinMapper rUserCoinMapper;
    @Autowired
    private RMatchLogMapper rMatchLogMapper;

    /**
     * 押注
     *
     * @param userUuid  账户uuid
     * @param amount    金额
     * @param matchUuid 赛程ID
     * @param winsIndex 下注对象
     * @return
     */
    @Override
    public boolean payMatch(String userUuid, long amount, String matchUuid, Integer winsIndex) {
        //用户扣费
        if(this.rechargeAmount(userUuid, new BigDecimal(amount))){
            //增加比赛操作日志
            RMatchLog matchLog = new RMatchLog(matchUuid, userUuid, 0, amount, winsIndex, null);
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
