package com.wxmp.threads.thread;

import com.wxmp.threads.handler.MultiParallelThreadHandler;

import java.util.concurrent.ExecutorService;

/**
 * @author  xunbo.xu
 * @desc    多线程池
 * @date 18/8/24
 */
public class ParallelTaskWithThreadPool extends MultiParallelThreadHandler {

    private ExecutorService service;

    public ParallelTaskWithThreadPool() {
    }

    public ParallelTaskWithThreadPool(ExecutorService service) {
        this.service = service;
    }

    public ExecutorService getService() {
        return service;
    }

    public void setService(ExecutorService service) {
        this.service = service;
    }

    /**
     * 使用线程池运行
     */
    @Override
    protected void invoke(Runnable command) {
        if(null != service){
            service.execute(command);
        }else{
            super.invoke(command);
        }
    }

}