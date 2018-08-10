package com.wxmp.racingapi.netty.service;

import com.wxmp.core.util.JSONUtil;
import com.wxmp.racingapi.netty.ClientQuene;
import com.wxmp.racingapi.netty.ServerMessage;
import io.netty.channel.Channel;
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
     * 根据用户唯一标志进行事件的推送
     *
     * @param userUuid
     * @param message
     * @return
     */
    @Override
    public boolean sendEvent(String userUuid, ServerMessage message) {
        boolean flag = false;
        try {
            Channel channel = ClientQuene.get(userUuid);
            channel.writeAndFlush(new TextWebSocketFrame(JSONUtil.objectToJson(message)));
            //TODO  调研Netty中的Futrure/ChannelFuture/ChannelPromise 进行发送成功与否的判断
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据用户的唯一标志 播发系统通知
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
                    if(this.sendEvent(userUuid, message)){
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

}
