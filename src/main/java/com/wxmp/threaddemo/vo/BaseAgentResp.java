package com.wxmp.threaddemo.vo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/29
 */
public class BaseAgentResp<T> {

    private int operateTime = 1000;
    private T data;
    private Future<T> future;

    public BaseAgentResp() {
    }

    public int getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(int operateTime) {
        this.operateTime = operateTime;
    }

    public T getData() {
        if (this.future == null) {
            //异步任务返回
            return this.data;
        } else {
            try {
                //同步任务返回
                return this.future.get((long)this.operateTime, TimeUnit.MILLISECONDS);
            } catch (ExecutionException | TimeoutException | InterruptedException var2) {
                var2.printStackTrace();
                return null;
            }
        }
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setFuture(Future<T> future) {
        this.future = future;
    }

}
