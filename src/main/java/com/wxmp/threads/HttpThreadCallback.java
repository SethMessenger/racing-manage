package com.wxmp.threads;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wxmp.core.util.HttpUtil;
import org.apache.commons.lang.StringUtils;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/28
 */
public class HttpThreadCallback<T> implements Callable<T> {

    private static final String URL1 = "https://www.apiopen.top/satinApi";
    private static final String URL2 = "https://www.apiopen.top/satinCommentApi";

    private String url;
    private Map<String, Object> paramsMap;
    private T result;

    public HttpThreadCallback(String url, Map<String, Object> paramsMap) {
        this.url = url;
        this.paramsMap = paramsMap;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public T call() throws Exception {
        if(StringUtils.isNotEmpty(url)){
            //发起请求
            System.out.println(url + " HEADER IS : " + " TODO  Things ");
            System.out.println(" REQ_JSON IS : ");
            String resultStr = HttpUtil.doGet(url, paramsMap, false);
            System.out.println("RESP_JSON IS : " + resultStr);
        }
        return null;
    }

    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(2);

        Map<String, Object> paramsMap1 = Maps.newHashMap();
        paramsMap1.put("type", 1);
        paramsMap1.put("page", 1);
        HttpThreadCallback<String> task1 = new HttpThreadCallback<>(URL1, paramsMap1);
        // 传入Callable对象创建FutureTask对象
        FutureTask<String> ft1 = new FutureTask<String>(task1);

        Map<String, Object> paramsMap2 = Maps.newHashMap();
        paramsMap1.put("id", "27610708");
        paramsMap1.put("page", 1);
        HttpThreadCallback<String> task2 = new HttpThreadCallback<>(URL2, paramsMap2);
        // 传入Callable对象创建FutureTask对象
        FutureTask<String> ft2 = new FutureTask<String>(task2);

        Collection<FutureTask<String>> tasks = Lists.newArrayList();
        Collection<HttpThreadCallback<String>> tasksd = Lists.newArrayList();
        tasksd.add(task1);
        tasksd.add(task2);
        tasks.add(ft1);
        tasks.add(ft2);
        try {
            exec.invokeAll(tasksd);
            for (FutureTask task : tasks){
                System.out.println(task.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
