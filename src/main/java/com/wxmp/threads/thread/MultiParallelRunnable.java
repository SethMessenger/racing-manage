package com.wxmp.threads.thread;

/**
 * @author  xunbo.xu
 * @desc    线程task实例，其中包含当前多线程实例的上下文
 * @date 18/8/24
 */
public class MultiParallelRunnable implements Runnable {

    /**
     * 并行任务参数
     */
    private MultiParallelContext context;

    /**
     * 构造函数
     * @param context
     */
    public MultiParallelRunnable(MultiParallelContext context) {
        this.context = context;
    }

    /**
     * 运行任务
     */
    @Override
    public void run() {
        try {
            context.getTask().run();
        } catch (Exception e) {
            e.printStackTrace();
            context.getChildException().addException(e);
        } finally {
            context.getChildLatch().countDown();
        }
    }

}