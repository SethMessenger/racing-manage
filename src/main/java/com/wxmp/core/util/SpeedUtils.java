package com.wxmp.core.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/15
 */
public class SpeedUtils {

    /**
     * 将数据库保存的竞速赛下注结果输出为 实际下注人
     * @param muti
     * @return
     */
    public static Integer QueryReadCountOn(Integer muti){
        String[] array = String.valueOf(muti).split("");
        Integer real = null;
        if(null != muti && muti > 100){
            return Integer.valueOf(array[2]);
        }
        return real;
    }

    /**
     * 竞速赛解析
     * @param result
     * @param matchCoins
     * @return
     */
    public static boolean checkSpeedsHit(List<Integer> result, String matchCoins){
        if(CollectionUtils.isNotEmpty(result) && StringUtils.isNotEmpty(matchCoins) && matchCoins.length() == 3){
            //默认无胜者
            Integer winner = 999;
            String[] array = matchCoins.split("");

            Integer compare1 = Integer.valueOf(array[0]);
            Integer compare2 = Integer.valueOf(array[1]);
            Integer countOn = Integer.valueOf(array[2]);

            Integer compareIndex1 = result.indexOf(compare1);
            Integer compareIndex2 = result.indexOf(compare2);
            Integer countOnIndex = result.indexOf(countOn);

            if(compareIndex1 > compareIndex2){
                winner = compare2;
            }else {
                winner = compare1;
            }
            return countOnIndex.equals(winner);
        }
        return false;
    }

    /**
     * 生成竞速赛解析押注结果
     * @param countOn
     * @param compare1
     * @param compare2
     * @return
     */
    public static Integer createMatchCoins(Integer countOn, Integer compare1, Integer compare2){
        if(null != compare1 && null != compare2 && null != countOn){
            StringBuffer sf = new StringBuffer().append(compare1).append(compare2).append(countOn);
            return Integer.valueOf(sf.toString());
        }
        return null;
    }

}