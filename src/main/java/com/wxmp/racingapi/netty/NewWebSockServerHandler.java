package com.wxmp.racingapi.netty;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/10
 */
@Deprecated
public class NewWebSockServerHandler extends SimpleChannelInboundHandler<String>{

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //channel失效，从Map中移除
        ClientQuene.remove((SocketChannel)ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception {
        cause.printStackTrace();
        System.out.println("出现异常！");
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg)throws Exception {
        //5.0版本后 修改方法名为 messageReceived
//        System.out.println(msg);
//        Message message = JSON.parseObject(msg+"", Message.class);
//        System.out.println("接收到消息："+message);
//        String clientId = message.getClientId();
//        if(MessageEnum.LOGIN.equals(message.getType())){
//            System.out.printf("将%s添加到队列\n",clientId);
//            ClientQuene.add(clientId,(SocketChannel)ctx.channel());
//        }else{
//            if(ClientQuene.get(clientId) == null){
//                //说明未登录，或者连接断了，服务器向客户端发起登录请求，让客户端重新登录
//                System.out.printf("登录失败，请重新登录!",clientId);
//                message = new Message(MessageEnum.LOGIN);
//                ctx.channel().writeAndFlush(JSON.toJSONString(message));
//            }
//        }
//
//        switch (message.getType()){
//            case PING:{
//                message = new Message(MessageEnum.PING);
//                ClientQuene.get(clientId).writeAndFlush(JSON.toJSONString(message));
//            }break;
//            case MESSAGE:{
//                //收到客户端的请求，发送给targetId
//                System.out.println("发送消息："+message);
//                if(ClientQuene.get(message.getTargetId()) != null){
//                    ClientQuene.get(message.getTargetId()).writeAndFlush(JSON.toJSONString(message));
//                }else{
//                    message.setType(MessageEnum.EVENT);
//                    ClientQuene.get(clientId).writeAndFlush(JSON.toJSONString(message));
//                }
//            }break;
//            default:
//                break;
//        }
    }

}
