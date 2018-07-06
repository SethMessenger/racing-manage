package com.wxmp.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import java.net.ServerSocket;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/4/8
 */
public class TestServerMain {


    /**
     * 启动thrift服务端
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //启动socket
        ServerSocket socket = new ServerSocket(8888);
        TServerSocket serverTransport = new TServerSocket(socket);
        //在socket中启动当前接口的实现逻辑代码
        TestThriftService.Processor processor = new TestThriftService.Processor(new TestThriftServiceImpl());

        //服务端启动
        TServer.Args tServerArgs = new TServer.Args(serverTransport);
        tServerArgs.processor(processor);
        TServer server = new TSimpleServer(tServerArgs);
        System.out.println("=======>>>   start to run thrift simple server");
        server.serve();
    }

}
