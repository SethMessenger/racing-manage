package com.wxmp.threaddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/28
 */
public class CallableDemo implements Callable<Integer> {

    public static void main(String[] args) {
        CallableDemo ctt = new CallableDemo();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(int i = 0;i < 100;i++) {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20) {
                new Thread(ft,"有返回值的线程" + i).start();
            }
        }
        try {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<20;i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }
}
