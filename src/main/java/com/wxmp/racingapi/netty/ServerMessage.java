package com.wxmp.racingapi.netty;

import java.io.Serializable;

/**
 * @author  xunbo.xu
 * @desc    服务器端发送消息格式
 * @date 18/8/11
 */
public class ServerMessage implements Serializable{

    private static final long serialVersionUID = -5756901646411393226L;

    /** 事件类型,  */
    private MessageEnum type;
    /** 事件内容 ,使用json格式，对前端进行返回 */
    private String data;
    /** 用户唯一标志 */
    private String userUuid;

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
}
