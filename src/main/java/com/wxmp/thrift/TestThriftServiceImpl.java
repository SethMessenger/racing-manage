package com.wxmp.thrift;

import com.wxmp.thrift.thriftdatatype.ResultInt;
import com.wxmp.thrift.thriftdatatype.ResultStr;
import com.wxmp.thrift.thriftdatatype.ThriftResult;
import org.apache.thrift.TException;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/4/8
 */
public class TestThriftServiceImpl implements TestThriftService.Iface{

    @Override
    public ResultStr getStr(String srcStr1, String srcStr2) throws TException {
        ResultStr result = new ResultStr(ThriftResult.SUCCESS,String.format("%s%s", srcStr1, srcStr2));
        System.out.println(result);
        return result;
    }

    @Override
    public ResultInt getInt(int val) throws TException {
        ResultInt result = new ResultInt(ThriftResult.SUCCESS, val);
        System.out.println(result);
        return result;
    }
}
