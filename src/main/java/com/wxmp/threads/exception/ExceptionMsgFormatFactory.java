package com.wxmp.threads.exception;

/**
 * @author  xunbo.xu
 * @desc    自定义异常格式化处理工厂
 * @date 18/8/24
 */
public class ExceptionMsgFormatFactory {

    /** 异常栈格式化处理器 */
    public static final String STACK_TRACE = "StackTraceHandler";

    /** 私有化构造，不允许工厂对象进行实例化 */
    private ExceptionMsgFormatFactory() {
    }

    /** 私有化工厂持有者 */
    private static class SingletonHolder {
        private static final ExceptionMsgFormatFactory instance = new ExceptionMsgFormatFactory();
    }

    /** 只能通过一种方式获取工厂实例 */
    public static ExceptionMsgFormatFactory getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 获取格式化工具
     *
     * @param formatterName
     * @return
     */
    public ExceptionMessageFormat getFormatter(String formatterName) {
        switch (formatterName) {
            case STACK_TRACE:
                return StackTraceMsgHandler.getInstance();

            default:
                break;
        }
        return DefaultExceptionMsgHandler.getInstance();
    }
}
