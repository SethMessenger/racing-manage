package com.wxmp.core.log;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xing.sun
 * @date 17/2/23
 */
public class CommonLog {

    private Logger logger;

    private CommonLog(Logger logger){
        this.logger = logger;
    }

    private static final String LOG_FORMAT = "{} || {} || ====>>> {} ";

    public static CommonLog getLogger(Class clazz){
        return new CommonLog(LoggerFactory.getLogger(clazz));
    }

    public void error(String format, String... msg){
        format = LOG_FORMAT + format;
        if(LogTraceUtil.getTraceId()==null){
            logger.error(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), "NULL", msg);
        }else {
            logger.error(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), LogTraceUtil.getTraceId(), msg);
        }
    }

    public void error(Throwable t,String format, String... msg){
        format = LOG_FORMAT + format;
        if(LogTraceUtil.getTraceId()==null) {
            logger.error(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), "NULL", msg, t);
        }else {
            logger.error(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), LogTraceUtil.getTraceId(), msg, t);
        }
    }

    public void info(String format, String... msg){
        format = LOG_FORMAT + format;
        if(LogTraceUtil.getTraceId()==null){
            logger.info(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), "NULL", msg);
        }else {
            logger.info(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), LogTraceUtil.getTraceId(), msg);
        }
    }

    public void info(Throwable t,String format, String... msg){
        format = LOG_FORMAT + format;
        if(LogTraceUtil.getTraceId()==null) {
            logger.info(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), "NULL", msg, t);
        }else {
            logger.info(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), LogTraceUtil.getTraceId(), msg, t);
        }
    }

    public void debug(String format, String... msg){
        format = LOG_FORMAT + format;
        if(LogTraceUtil.getTraceId()==null){
            logger.debug(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), "NULL", msg);
        }else {
            logger.debug(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), LogTraceUtil.getTraceId(), msg);
        }
    }

    public void debug(Throwable t,String format, String... msg){
        format = LOG_FORMAT + format;
        if(LogTraceUtil.getTraceId()==null) {
            logger.debug(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), "NULL", msg, t);
        }else {
            logger.debug(format, Thread.currentThread().getStackTrace()[2].getLineNumber(), LogTraceUtil.getTraceId(), msg, t);
        }
    }

}
