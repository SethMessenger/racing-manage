package com.wxmp.racingapi.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author  xunbo.xu
 * @desc    用户金币消费策略
 * @date 18/7/11
 */
public interface UserCoinService {

    /**
     * 押注
     * @param userUuid  账户uuid
     * @param amount    金额
     * @param matchUuid 赛程ID
     * @param winsIndex 下注对象
     * @return
     */
    boolean payMatch(String userUuid, long amount, String matchUuid, Integer winsIndex);

    /**
     * 用户金币出账(扣费)
     * @param useruuid
     * @param amount
     * @return
     */
    boolean rechargeAmount(String useruuid, BigDecimal amount);

    /**
     * 用户金币入账(充值)
     * @param useruuid
     * @param amount
     * @return
     */
    boolean withdrawAmount(String useruuid, BigDecimal amount);

    /**
     * 用户人民币进账，仅允许整数充值
     * @param useruuid
     * @param amount
     * @return
     */
    boolean withdrawRMBAmount(String useruuid, BigDecimal amount);

    /**
     * 用户金币集中入账(充值)
     * @param userCoin
     * @return
     */
    boolean withdrawAmountBatchOne(Map<String, BigDecimal> userCoin);

    /**
     * 用户金币集中入账(充值)
     * @param userCoin
     * @return
     */
    boolean withdrawAmountBatchMuti(Map<String, List<BigDecimal>> userCoin);
}
