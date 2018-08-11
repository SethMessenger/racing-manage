package com.wxmp.racingapi.netty;

import com.alibaba.fastjson.JSON;
import com.wxmp.core.util.SpringContextHolder;
import com.wxmp.racingapi.netty.service.WebSocketBizService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

/**
 * @author  xunbo.xu
 * @desc    ${netty WebSocket服务端处理类}
 * @date 18/8/8
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        if(msg instanceof FullHttpRequest){
            /** HTTP接入，WebSocket第一次连接使用HTTP连接,用于握手 */
            handleHttpRequest(ctx, (FullHttpRequest)msg);
        }else if(msg instanceof WebSocketFrame){
            /** Websocket 接入 */
            handlerWebSocketFrame(ctx, (WebSocketFrame)msg);
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //频道结束读取
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        //长连接异常状态处理
        ctx.close();
    }


    /**
     * HTTP接入，WebSocket第一次连接使用HTTP连接,用于握手
     * @param ctx
     * @param req
     */
    private void handleHttpRequest(ChannelHandlerContext ctx,FullHttpRequest req){
        if (!req.getDecoderResult().isSuccess()
                || (!"websocket".equals(req.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                "ws://localhost:2048/ws", null, false);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    /**
     * 返回应答 到 客户端
     * @param ctx
     * @param req
     * @param res
     */
    private static void sendHttpResponse(ChannelHandlerContext ctx,
                                         FullHttpRequest req, DefaultFullHttpResponse res) {
        // 返回应答给客户端
        if (res.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(),
                    CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        // 如果是非Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!isKeepAlive(req) || res.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * 叛党当前的累计额是否需要保持通讯的协议
     * @param req
     * @return
     */
    private static boolean isKeepAlive(FullHttpRequest req) {
        return false;
    }

    /**
     * WS协议下 依据客户端不同的消息类型进行 路由
     * @param ctx
     * @param frame
     */
    private void handlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {

        /** 判断是否关闭链路的指令 */
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }

        /** 判断是否ping消息 */
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }

        /** 本例程仅支持文本消息，不支持二进制消息 */
        if (frame instanceof BinaryWebSocketFrame) {
            throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass().getName()));
        }

        /** 业务处理，根据枚举类型组装对象分发service进行处理 */
        if(frame instanceof TextWebSocketFrame){
            // 返回应答消息
            String request = ((TextWebSocketFrame) frame).text();
            WebSocketBizService webSocketBizService = SpringContextHolder.getBean(WebSocketBizService.class);

            webSocketBizService.handleRequest(request, ctx);
        }

    }
}