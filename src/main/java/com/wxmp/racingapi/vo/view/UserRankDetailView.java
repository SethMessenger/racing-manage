package com.wxmp.racingapi.vo.view;

import org.apache.commons.lang.StringUtils;

/**
 * @author  xunbo.xu
 * @desc    排行榜
 * @date 18/8/15
 */
public class UserRankDetailView {

    private int index;
    private String icon = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1534269387&di=aba03eca9d098e8c50a840b41e031e0d&src=http://5b0988e595225.cdn.sohucs.com/images/20171109/eea19004b55f4543b0d69d8fb56a1d42.jpeg";
    private String userNickName;
    private long winCoins;
    private long rewards;

    public UserRankDetailView(int index, String icon, String userNickName, long winCoins) {
        this.index = index;
        if (StringUtils.isNotBlank(icon)) {
            this.icon = icon;
        }
        this.userNickName = userNickName;
        this.winCoins = winCoins;
        if(index == 1){
            rewards = 500000;
        }else if(index == 2){
            rewards = 200000;
        }else if(index == 3){
            rewards = 100000;
        }else if(index > 3 && index <= 15){
            rewards = 40000;
        }else if(index > 15 && index <= 50){
            rewards = 5000;
        }else if(index > 50){
            rewards = 2000;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public long getWinCoins() {
        return winCoins;
    }

    public void setWinCoins(long winCoins) {
        this.winCoins = winCoins;
    }

    public long getRewards() {
        return rewards;
    }

    public void setRewards(long rewards) {
        this.rewards = rewards;
    }
}
