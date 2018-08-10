package com.wxmp.racingapi.netty.service;

import com.wxmp.racingapi.netty.ServerMessage;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    用于操作当前项目长连接的
 * @date 18/8/10
 */
public interface WebSocketService {

    /**
     * 根据用户唯一标志进行事件的推送
     * @param userUuid
     * @param message
     * @return
     */
    boolean sendEvent(String userUuid, ServerMessage message);

    /**
     * 根据用户的唯一标志 播发系统通知
     * @param userUuids
     * @param message
     * @return
     */
    Integer sendNotice(List<String> userUuids, ServerMessage message);

    /**
     * 接收前端事件 封装为业务对象
     * @param jsonMsg
     * @return
     */
    boolean receiveEvent(String jsonMsg);


}
