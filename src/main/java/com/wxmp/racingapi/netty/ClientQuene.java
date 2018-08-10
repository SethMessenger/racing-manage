package com.wxmp.racingapi.netty;

import io.netty.channel.socket.SocketChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author  xunbo.xu
 * @desc    当前在线长连接管理,当前用户只允许单登录，如果有人二次登录会将之前登录的用户进行登出
 * @date 18/8/10
 */

public class ClientQuene {

    /** 客户端队列 客户端ID ： 对应channel */
    private static Map<String, SocketChannel> map = new ConcurrentHashMap<>();

    /**
     * 新增用户长连接
     * @param clientId
     * @param channel
     */
    public static void add(String clientId, SocketChannel channel) {
        map.put(clientId, channel);
    }

    /**
     * 查询用户所处的长连接频道
     * @param clientId
     * @return
     */
    public static SocketChannel get(String clientId) {
        return map.get(clientId);
    }

    /**
     * 查询全部
     * @return
     */
    public static List<String> getClients(){
        return new ArrayList<String>(map.keySet());
    };

    /**
     * 移除当前用户所在的长连接频道
     * @param channel
     */
    public static void remove(SocketChannel channel) {
        for (Map.Entry<String, SocketChannel> entry : map.entrySet()) {
            if (entry.getValue() == channel) {
                map.remove(entry.getKey());
            }
        }
    }
}


