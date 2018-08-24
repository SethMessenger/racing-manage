package com.wxmp.threads.exception;

/**
 * @author  xunbo.xu
 * @desc    默认异常格式化器,单例
 * @date 18/8/24
 */
public class DefaultExceptionMsgHandler implements ExceptionMessageFormat {

    private DefaultExceptionMsgHandler() {
    }

    private static class SingletonHolder{
        private static final DefaultExceptionMsgHandler instance = new DefaultExceptionMsgHandler();
    }

    public static DefaultExceptionMsgHandler getInstance(){
        return SingletonHolder.instance;
    }

    /**
     * 格式化异常信息
     */
    @Override
    public String formate(Exception e) {
        return e.getMessage() + "\n";
    }

}
