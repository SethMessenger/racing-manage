package com.wxmp.racingapi.netty.service;

import com.wxmp.racingapi.netty.ServerMessage;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    用于操作当前项目长连接的
 * @date 18/8/10
 */
public interface WebSocketService {

    /**
     * 根据用户唯一标志进行事件的推送
     * TODO 因为每个context只能持有一个final类型的channel，索引全部的连接创建和管理在这里，是否有办法进行优化(因为这样就导致必须拿到context才能推送消息，无法在无连接的情况下进行推送)
     * @param userUuid
     * @param message
     * @return
     */
    boolean sendEvent(String userUuid, ServerMessage message);

    /**
     * 登录
     * 处理单点登录的逻辑
     * @param userUuid
     * @param message
     * @param ctx
     * @return
     */
    boolean login(String userUuid, ServerMessage message, ChannelHandlerContext ctx);

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
