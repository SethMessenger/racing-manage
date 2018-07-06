package com.wxmp.core.domain.ajax;

/**
 * @author xunbo.xu
 * @desc    用于进行ajax返回值的传递的基类
 * @date 18/3/27
 */
public class BaseAjaxResult {

    /** 返回消息 */
    private String msg;
    /** 服务器时间戳 */
    private long timestamp;
    /** 服务器返回编码 */
    private Integer code;

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
