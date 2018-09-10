package com.wxmp.threads;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.wxmp.threads.exception.ChildThreadException;
import com.wxmp.threads.handler.MultiThreadHandler;
import com.wxmp.threads.thread.ParallelTaskWithThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/27
 */
public class HttpTestMain {

    private static final String URL1 = "https://www.apiopen.top/satinApi";
    private static final String URL2 = "https://www.apiopen.top/satinCommentApi";

    public static void main(String[] args) {

        queryResult();

    }


    private static Map<String, Object> queryResult(){

        //https://www.apiopen.top/satinApi?type=1&page=1
        //https://www.apiopen.top/satinCommentApi?id=27610708&page=1

        System.out.println("main begin \t=================");
        Map<String, Object> resultMap = new HashMap<String, Object>(8, 1);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        int size = 5;
        ExecutorService executorService = new ThreadPoolExecutor(size,size,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
        MultiThreadHandler handler = new ParallelTaskWithThreadPool(executorService);

        Map<String, Object> paramsMap1 = Maps.newHashMap();
        paramsMap1.put("type", 1);
        paramsMap1.put("page", 1);
        ThreadHttoConecCase<String> threadCase1 = new ThreadHttoConecCase<String>(URL1, paramsMap1);

        Map<String, Object> paramsMap2 = Maps.newHashMap();
        paramsMap1.put("id", "27610708");
        paramsMap1.put("page", 1);
        ThreadHttoConecCase<String> threadCase2 = new ThreadHttoConecCase<String>(URL2, paramsMap2);

        //加入线程组
        handler.addTask(threadCase1);
        handler.addTask(threadCase2);

        try {
            handler.run();
        } catch (ChildThreadException e) {
            System.out.println(e.getAllStackTraceMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("END");

        //TODO
        return null;
    }

}
