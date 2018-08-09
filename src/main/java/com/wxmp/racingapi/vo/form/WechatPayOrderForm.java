package com.wxmp.racingapi.vo.form;

/**
 * @author  xunbo.xu
 * @desc    提交创建微信支付订单表单
 * @date 18/7/31
 */
public class WechatPayOrderForm {

    /** 用户唯一标志 */
    private String userUuid;
    /** 订单类型, 0 现金支付  */
    private Integer orderType;
    /** 订单支付金额 */
    private Integer orderAmount;
    /** 支付方式：0 微信支付 */
    private Integer payType;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}
