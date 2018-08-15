package com.wxmp.racingapi.vo.view;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/15
 */
public class RankView {

    private List<UserRankDetailView> todays;
    private List<UserRankDetailView> yesterdays;
    private String userIcon = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1534269387&di=aba03eca9d098e8c50a840b41e031e0d&src=http://5b0988e595225.cdn.sohucs.com/images/20171109/eea19004b55f4543b0d69d8fb56a1d42.jpeg";
    private String userNickName;
    private int todaysRank;
    private int yesterdaysRank;

    public List<UserRankDetailView> getTodays() {
        return todays;
    }

    public void setTodays(List<UserRankDetailView> todays) {
        this.todays = todays;
    }

    public List<UserRankDetailView> getYesterdays() {
        return yesterdays;
    }

    public void setYesterdays(List<UserRankDetailView> yesterdays) {
        this.yesterdays = yesterdays;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public int getTodaysRank() {
        return todaysRank;
    }

    public void setTodaysRank(int todaysRank) {
        this.todaysRank = todaysRank;
    }

    public int getYesterdaysRank() {
        return yesterdaysRank;
    }

    public void setYesterdaysRank(int yesterdaysRank) {
        this.yesterdaysRank = yesterdaysRank;
    }
}
