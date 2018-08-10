package com.wxmp.racingapi.netty.service;

import com.alibaba.fastjson.TypeReference;
import com.wxmp.core.log.CommonLog;
import com.wxmp.core.util.JSONUtil;
import com.wxmp.racingapi.netty.ClientMessage;
import com.wxmp.racingapi.netty.ClientQuene;
import com.wxmp.racingapi.netty.MessageEnum;
import com.wxmp.racingapi.netty.ServerMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    长连接业务service
 * @date 18/8/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WebSocketBizServiceImpl implements WebSocketBizService {

    @Autowired
    private WebSocketService socketService;

    /**
     * 入口路由
     *
     * @param jsonStr
     * @param ctx
     */
    @Override
    public void handleRequest(String jsonStr, ChannelHandlerContext ctx) {
        if(JSONUtil.isJson(jsonStr)){
            ClientMessage msg = JSONUtil.jsonToObject(new TypeReference<ClientMessage>(){}, jsonStr);
            switch (msg.getType()){
                case PING:
                    break;
                case DEFAULT:
                    break;
                case LOGIN:
                    userHandShake(msg.getUserUuid(), ctx);
                    break;
                case EVENT_DEFAULT:
                    break;
                case MESSAGE_DEFAULT:
                    break;
                default:
                    CommonLog.getLogger(WebSocketBizServiceImpl.class).info("handleRequest default null ");
            }
        }
    }

    /**
     * 用户握手完成后的操作
     *
     * @param userUuid
     * @param ctx
     */
    private void userHandShake(String userUuid, ChannelHandlerContext ctx) {
        SocketChannel channel = ClientQuene.get(userUuid);
//        if(null == channel){
            //自动注册用户访问频道
            channel = (SocketChannel)ctx.channel();
            ClientQuene.add(userUuid, channel);
//        }
        System.out.println("用户握手完成");
        ServerMessage event = new ServerMessage();
        event.setUserUuid("seth");
        event.setData("data");
        event.setType(MessageEnum.PING);
        this.socketService.sendEvent(userUuid, event);
    }

    /**
     * 收到用户发生事件并进行处理
     *
     * @param userUUID
     */
    private void receiveEvent(String userUUID) {

    }

    /**
     * 向用户广播消息
     *
     * @param userUuids
     * @param jsonStr
     */
    private void sendEvent2Users(List<String> userUuids, String jsonStr) {

    }

}
