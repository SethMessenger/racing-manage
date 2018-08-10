package com.wxmp.racingapi.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.core.log.CommonLog;
import com.wxmp.racingapi.service.ArithmeticService;
import com.wxmp.racingapi.vo.dto.ArithmeticAwardDTO;
import com.wxmp.racingcms.domain.RMatchLog;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author  xunbo.xu
 * @desc    赛果算法核心业务
 * @date 18/7/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArithmeticServiceImpl implements ArithmeticService{


    /**
     * 计算指定赛程的比赛结果
     * @param matchLogs
     */
    @Override
    public List<List<Integer>> caculateMatchResult(List<RMatchLog> matchLogs) {
        List<List<Integer>> reslut = Lists.newArrayList();
        //每辆车押注总额 总计
        Map<Integer, Long> coinMap = Maps.newHashMap();
        //每辆车押注总人数
        Map<Integer, Long> playerMap = Maps.newHashMap();
        List<ArithmeticAwardDTO> racings = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(matchLogs)){
            for (RMatchLog log : matchLogs){
                if(!coinMap.keySet().contains(log.getCoinIndex())){
                    coinMap.put(log.getCoinIndex(), log.getCoinAmount());
                    playerMap.put(log.getCoinIndex(), 1L);
                }else {
                    coinMap.put(log.getCoinIndex(), Long.valueOf(coinMap.get(log.getCoinIndex())) + log.getCoinAmount());
                    playerMap.put(log.getCoinIndex(), playerMap.get(log.getCoinIndex()) + 1L);
                }
            }
        }
        for (int i = 0; i < RacingConstants.RACING_AMOUNT; i++) {
            //支持6辆赛车
            racings.add(new ArithmeticAwardDTO(String.valueOf(i), this.caculateProbability(i, coinMap), this.caculateCounts(i, playerMap)));
        }
        reslut.add(queryRandom(9999));
        reslut.add(queryRandom(9999));
        reslut.add(queryRandom(9999));
        reslut.add(queryRandom(9999));
        List<Integer> finals = Lists.newArrayList();
        CommonLog.getLogger(ArithmeticServiceImpl.class).info(" caculateMatchResult ===>>>> " + racings.toString());
        Integer champIndex = lottery(racings);
        if(null != champIndex){
            finals.add(champIndex);
            finals.addAll(queryRandom(champIndex));
            reslut.add(finals);
        }else {
            return Lists.newArrayList();
        }

        return reslut;
    }


    /**
     * 依据赛车下注金额计算赛车第一名可能性
     * @param coinIndex
     * @param coinMap   coinIndex VS coinTotal
     * @return
     */
    private float caculateProbability(Integer coinIndex, Map<Integer, Long> coinMap){
        if(MapUtils.isNotEmpty(coinMap)){
            long total = 0L;
            for (long coin : coinMap.values()){
                total += coin;
            }
            List<Float> probabilityList = this.initlizeProbability();
            if(total > 0){
                for (int index : coinMap.keySet()){
                    probabilityList.set(index, new BigDecimal(coinMap.get(index)).divide(new BigDecimal(total), 2, RoundingMode.HALF_UP).floatValue() );
                }
                if(CollectionUtils.isNotEmpty(probabilityList)){
                    //反序，押注的越多，概率越低
                    Collections.reverse(probabilityList);
                }
                return probabilityList.get(coinIndex);
            }else {
                return new BigDecimal(1).divide(new BigDecimal(RacingConstants.RACING_AMOUNT), 2, RoundingMode.HALF_UP).floatValue();
            }
        }else {
            return new BigDecimal(1).divide(new BigDecimal(RacingConstants.RACING_AMOUNT), 2, RoundingMode.HALF_UP).floatValue();
        }
    }

    /**
     * 依据赛车被人关注次数的多少确认赛车的 模型关注量
     * @param coinIndex
     * @param playerMap
     * @return
     */
    private long caculateCounts(Integer coinIndex, Map<Integer, Long> playerMap){
        //参与人数越多，越容易中奖
        if(null != playerMap.get(coinIndex) && 0 != playerMap.get(coinIndex)){
            return playerMap.get(coinIndex) * 100;
        }else {
            return 100;
        }
    }

    /**
     * 核心<br/>
     * 计算赛车最终的胜利者,排序，胜者在前<br/>
     * 这个算法可以不要求全部的概率之和为100%
     * @param awards
     * @return  胜出者 VS 剩余队列 只有一对keyValue
     */
    private Integer lottery(List<ArithmeticAwardDTO> awards){

        if(CollectionUtils.isNotEmpty(awards)){
            //总的概率区间
            float totalPro = 0f;
            //存储每个赛车获奖新的概率区间
            List<Float> proSection = new ArrayList<Float>();
            proSection.add(0f);
            //遍历每个赛车，设置概率区间，总的概率区间为每个概率区间的总和
            for (ArithmeticAwardDTO award : awards) {
                //每个概率区间为奖品概率乘以1000（把三位小数转换为整）再乘以剩余奖品数量
                totalPro += award.getProbability() * 10 * award.getCount();
                proSection.add(totalPro);
            }

            //获取总的概率区间中的随机数
            Random random = new Random();
            float randomPro = (float)random.nextInt((int)totalPro);

            //判断取到的随机数在哪个奖品的概率区间中
            for (int i = 0,size = proSection.size(); i < size; i++) {
                if(randomPro >= proSection.get(i)
                        && randomPro < proSection.get(i + 1)){
                    return i;
                }
            }
        }
        return null;
    }

    /**
     * 数字随机排列
     * @param except
     * @return
     */
    private List<Integer> queryRandom(int except){
        List<Integer> nums = Lists.newArrayList();
        for (int i = 0; i < RacingConstants.RACING_AMOUNT; i++) {
            if(except != i){
                nums.add(i);
            }
        }
        Collections.shuffle(nums);
        return nums;
    }

    /**
     * 初始化当前赛车的原始命中概率
     * @return
     */
    private List<Float> initlizeProbability(){
        List<Float> probabilityList = Lists.newArrayList();
        Integer initSize = RacingConstants.RACING_AMOUNT;
        Float initProbability = new BigDecimal(1).divide(new BigDecimal(initSize), 2, RoundingMode.HALF_UP).floatValue();

        for (int i = 0; i < initSize; i++) {
            probabilityList.add(initProbability);
        }
        return probabilityList;
    }

}
