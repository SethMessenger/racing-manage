package com.wxmp.racingapi.netty;

import com.wxmp.core.util.JSONUtil;

import java.io.Serializable;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/10
 */
public class ClientMessage extends BaseMessage implements Serializable {

    private static final long serialVersionUID = -5756901646411393269L;

    /** 事件类型,  */
    private MessageEnum type;
    /** 事件内容 ,使用json格式，对前端进行返回 */
    private String data;
    /** 用户唯一标志 */
    private String userUuid;
    /** 上传备注 */
    private String remark;

    public ClientMessage(){
        super();
    }

    public MessageEnum getType() {
        return type;
    }

    public void setType(MessageEnum type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}