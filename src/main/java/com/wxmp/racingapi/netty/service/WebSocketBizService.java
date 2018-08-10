package com.wxmp.racingapi.netty.service;

import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/10
 */
public interface WebSocketBizService {

    /**
     * 入口路由
     * @param jsonStr
     * @param ctx
     */
    void handleRequest(String jsonStr, ChannelHandlerContext ctx);

}
