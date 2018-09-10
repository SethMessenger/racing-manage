package com.wxmp.racingapi.vo.view;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/15
 */
public class RankView {

    private List<UserRankDetailView> todays;
    private String userIcon = "http://d.lanrentuku.com/down/png/1406/little_animal_64x64/little_animal_06.png";
    private String userNickName;
    private String todaysRank = "500+";

    public List<UserRankDetailView> getTodays() {
        return todays;
    }

    public void setTodays(List<UserRankDetailView> todays) {
        this.todays = todays;
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

    public String getTodaysRank() {
        return todaysRank;
    }

    public void setTodaysRank(String todaysRank) {
        this.todaysRank = todaysRank;
    }
}
