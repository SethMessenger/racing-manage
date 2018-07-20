package com.wxmp.racingapi.vo.agent;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/20
 */
public class ShortMessageRes extends UnionDataBaseRes{

    /** 发送数量 */
    private Integer count;
    /** 扣除条数 */
    private Integer fee;
    /** 短信ID */
    private String sid;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
