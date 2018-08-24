package com.wxmp.threads;

import com.wxmp.threads.exception.ChildThreadException;

/**
 * @author  xunbo.xu
 * @desc    多线程处理接口定义
 * @date 18/8/24
 */
public interface MultiThreadHandler {

    /**
     * 新增并行任务
     * @param tasks
     */
    void addTask(Runnable... tasks);

    /**
     * 执行任务
     * @throws ChildThreadException
     */
    void run() throws ChildThreadException;

}
