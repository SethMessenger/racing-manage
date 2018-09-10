package com.wxmp.threads;

import com.wxmp.core.util.HttpUtil;

import java.util.Map;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/27
 */
public class ThreadHttoConecCase<T> implements Runnable {


    private String url;
    private Map<String, Object> params;
    private T result;

    /**
     * 构造中需要告知当前请求的访问地址 & 请求参数列表 &
     * @param url
     * @param params
     */
    public ThreadHttoConecCase(String url, Map<String, Object> params) {
        this.url = url;
        this.params = params;
    }

    @Override
    public void run() {
        try {
            //发起请求
            System.out.println(url + " HEADER IS : " + " TODO  Things ");
            System.out.println(" REQ_JSON IS : ");
            String resultStr = HttpUtil.doGet(url, params, false);
            System.out.println("RESP_JSON IS : " + resultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}