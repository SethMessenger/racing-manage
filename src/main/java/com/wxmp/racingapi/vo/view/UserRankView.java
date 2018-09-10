package com.wxmp.racingapi.vo.view;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/9/5
 */
public class UserRankView implements Comparable<UserRankView>{

    private String name;
    private String icon;
    private int rank;

    public UserRankView() {
    }

    public UserRankView(String name, String icon, Integer rank) {
        this.name = name;
        this.icon = icon;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(UserRankView o) {
        if(this.rank > o.getRank()){
            return 1;
        }
        return 0;
    }
}
