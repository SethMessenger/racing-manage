package com.wxmp.thrift;

import com.wxmp.thrift.thriftdatatype.ResultStr;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/4/8
 */
public class TestClientMain {

    /**
     * thrift客户端实现逻辑
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //访问本地的 8888 服务端程序
        TTransport transport = new TSocket("localhost", 8888);
        TProtocol protocol = new TBinaryProtocol(transport);

        //创建client
        TestThriftService.Client client = new TestThriftService.Client(protocol);

        if(!transport.isOpen()){
            transport.open();
        }

        //第一种请求类型
        ResultStr resultStr = client.getStr("seth_thrift_demo", " success");
        System.out.println("success!!!");
        System.out.println(resultStr);

    }


}
