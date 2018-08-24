package com.wxmp.threads.exception;

/**
 * @author  xunbo.xu
 * @desc    异常信息格式化
 * @date 18/8/24
 */
public interface ExceptionMessageFormat {

    /**
     * 异常格式化
     * @param e
     * @return
     */
    String formate(Exception e);

}
