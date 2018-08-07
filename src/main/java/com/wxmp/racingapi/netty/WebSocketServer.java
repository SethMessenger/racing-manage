package com.wxmp.racingapi.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author  xunbo.xu
 * @desc    ${netty WebSocketServer启动类}
 * @date 18/8/8
 */
public class WebSocketServer {

    private final EventLoopGroup workerGroup = new NioEventLoopGroup();
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();

    public void run(){
        ServerBootstrap boot = new ServerBootstrap();
        boot.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {

                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        //将请求和应答的消息编码或者解码为HTTP消息
                        pipeline.addLast("http-codec",new HttpServerCodec());
                        //将HTTP消息的多个部分组合成一条完整的HTTP消息
                        pipeline.addLast("aggregator",new HttpObjectAggregator(65536));
                        //向客户端发送HTML5文件，主要用于支持浏览器和服务端进行websocket通信
                        pipeline.addLast("http-chunked",new ChunkedWriteHandler());
                        //增加消息的Handler处理类WebSocketServerHandler
                        pipeline.addLast("handler",new WebSocketServerHandler());
                    }

                });

        try {
            //bind方法会创建一个serverchannel，并且会将当前的channel注册到eventloop上面，
            //会为其绑定本地端口，并对其进行初始化，为其的pipeline加一些默认的handler
            Channel ch = boot.bind(2048).sync().channel();
            System.out.println("websocket server start at port:2048");
            //相当于在这里阻塞，直到serverchannel关闭
            ch.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new WebSocketServer().run();
    }

}