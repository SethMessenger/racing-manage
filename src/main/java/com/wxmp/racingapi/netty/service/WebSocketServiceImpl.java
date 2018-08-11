package com.wxmp.racingapi.netty.service;

import com.wxmp.core.util.JSONUtil;
import com.wxmp.racingapi.netty.ClientQuene;
import com.wxmp.racingapi.netty.ServerMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    用于操作当前项目长连接的
 * @date 18/8/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WebSocketServiceImpl implements WebSocketService{

    /**
     * 登录
     * 处理单点登录的逻辑
     * @param userUuid
     * @param message
     * @return
     */
    @Override
    public boolean login(String userUuid, ServerMessage message, ChannelHandlerContext ctx) {
        boolean flag = false;
        SocketChannel  channel = ClientQuene.get(userUuid);
        try {
            channel = ClientQuene.get(userUuid);
            if(null != channel){
                //单点登录，如果当前用户已经登录过，则进行下线
                channel.shutdownOutput();
            }
            //自动注册用户访问频道
            ClientQuene.add(userUuid, (SocketChannel) ctx.channel());
            this.sendEvent(userUuid, message);
            //TODO  调研Netty中的Futrure/ChannelFuture/ChannelPromise 进行发送成功与否的判断
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据用户唯一标志进行事件的推送
     * TODO 因为每个context只能持有一个final类型的channel，索引全部的连接创建和管理在这里，是否有办法进行优化(因为这样就导致必须拿到context才能推送消息，无法在无连接的情况下进行推送)
     * @param userUuid
     * @param message
     * @return
     */
    @Override
    public boolean sendEvent(String userUuid, ServerMessage message) {
        boolean flag = false;
        SocketChannel  channel = ClientQuene.get(userUuid);
        try {
            if(null != channel){
                channel.writeAndFlush(new TextWebSocketFrame(JSONUtil.objectToJson(message)));
            }
            //TODO  调研Netty中的Futrure/ChannelFuture/ChannelPromise 进行发送成功与否的判断
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据用户的唯一标志 播发系统通知(在无用户主动推送下的返回，不经过单点登录系统)
     *
     * @param userUuids
     * @param message
     * @return
     */
    @Override
    public Integer sendNotice(List<String> userUuids, ServerMessage message) {
        Integer count = 0;
        try {
            if(CollectionUtils.isNotEmpty(userUuids)){
                for (String userUuid : userUuids){
                    //自发送，不校验
                    boolean flag = false;
                    try {
                        SocketChannel  channel = ClientQuene.get(userUuid);
                        if(null != channel){
                            channel.writeAndFlush(new TextWebSocketFrame(JSONUtil.objectToJson(message)));
                        }
                        flag  = true;
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    if(flag){
                        count++;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 接收前端事件 封装为业务对象
     * @param jsonMsg
     * @return
     */
    @Override
    public boolean receiveEvent(String jsonMsg) {
        return false;
    }

    /**
     * 用户登出
     *
     * @param userUuid
     * @param event
     * @param ctx
     * @return
     */
    @Override
    public boolean loginout(String userUuid, ServerMessage event, ChannelHandlerContext ctx) {
        SocketChannel  channel = ClientQuene.get(userUuid);
        if(null == channel){
            //发送消息，关闭连接
            channel = (SocketChannel) ctx.channel();
            sendEvent(userUuid, event);
            channel.shutdownOutput();
        }else {
            //关闭连接，移除队列 TODO 关闭与否的Future
            sendEvent(userUuid, event);
            channel.shutdownOutput();
            ClientQuene.remove(channel);
        }
        return false;
    }

}
