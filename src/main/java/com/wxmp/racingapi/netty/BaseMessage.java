package com.wxmp.racingapi.netty;

import com.wxmp.core.util.DateUtil;

import java.util.Date;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/12
 */
public class BaseMessage {

    private long timestamp;
    private String timeFormat;

    public BaseMessage() {
        this.timestamp = System.currentTimeMillis();
        this.timeFormat = DateUtil.COMMON_FULL.getDateText(new Date(this.timestamp));
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }
}
