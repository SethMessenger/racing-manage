package com.wxmp.racingapi.netty;

/**
 * @author  xunbo.xu
 * @desc    netty发送消息的类型
 * @date 18/8/10
 */
public enum MessageEnum {

    /** 心跳包 */
    PING(0, "heartBeat"),
    /** 登录 */
    LOGIN(1, "login success"),
    /** 登出 */
    LOGOUT(2, "logout"),
    /** 上传记账 */
    EVENT_SERVER_AMOUNT(101, "上传用户押注记录"),
    /** 回传前端请求参数 log */
    EVENT_SERVER_CLIENTLOG(109, "回传前端请求参数，作为前端log"),
    /** 事件 */
    EVENT_DEFAULT(109, "defaultEvent"),
    /** 消息 */
    MESSAGE_DEFAULT(209, "deafultMessage"),
    /** 容错默认 */
    DEFAULT(999, "dafault error");

    public static MessageEnum getMessageEnum(Integer enumCode){
        if(enumCode != null){
            for (MessageEnum e : MessageEnum.values()){
                if(e.getCode() == enumCode){
                    return e;
                }
            }
        }
        return MessageEnum.DEFAULT;
    }

    MessageEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
