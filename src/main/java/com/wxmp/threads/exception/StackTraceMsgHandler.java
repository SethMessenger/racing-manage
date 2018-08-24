package com.wxmp.threads.exception;

/**
 * @author  xunbo.xu
 * @desc    堆栈解析 异常 格式化处理器
 * @date 18/8/24
 */
public class StackTraceMsgHandler implements ExceptionMessageFormat {

    private StackTraceMsgHandler() {
    }

    private static class SingletonHolder {
        private static final StackTraceMsgHandler instance = new StackTraceMsgHandler();
    }

    public static StackTraceMsgHandler getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 格式化堆栈跟踪信息
     */
    @Override
    public String formate(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuffer sb = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat " + stackTraceElement + "\n");
        }
        return sb.toString();
    }

}
