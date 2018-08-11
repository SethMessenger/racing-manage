package com.wxmp.racingapi.netty;

import java.io.Serializable;

/**
 * @author  xunbo.xu
 * @desc    服务器端发送消息格式
 * @date 18/8/11
 */
public class ServerMessage extends BaseMessage implements Serializable{

    private static final long serialVersionUID = -5756901646411393226L;

    /** 事件类型,  */
    private Integer type;
    /** 事件内容 ,使用json格式，对前端进行返回 */
    private String data;
    /** 用户唯一标志 */
    private String userUuid;
    /** 备注 */
    private String remark;

    public static ServerMessage build(MessageEnum type, String data, String userUuid){
        return new ServerMessage(type,data,userUuid);
    }

    private ServerMessage(MessageEnum type, String data, String userUuid) {
        super();
        this.type = type.getCode();
        this.remark = type.getMsg();
        this.data = data;
        this.userUuid = userUuid;
    }

    public String getRemark() {
        return remark;
    }

    private void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    private void setType(Integer type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }

    public String getUserUuid() {
        return userUuid;
    }

    private void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
}
