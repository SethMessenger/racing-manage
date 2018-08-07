package com.wxmp.core.util.wx;

/**
 * @author  xunbo.xu
 * @desc    用于日志操作的类
 * @date 18/7/13
 */
public class LogUtils {

    public static void console(String msg){
        System.out.println(Thread.currentThread().getId() + " LOG CONSOLE ====== " + msg);
    }


}
