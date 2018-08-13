package com.wxmp.core.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author xing.sun
 * @date 17/2/23
 */
public class CommonLog {

    private Logger logger;

    private CommonLog(Logger logger){
        this.logger = logger;
    }

    public static CommonLog getLogger(Class clazz){
        return new CommonLog(LogManager.getLogger(clazz));
    }

    public void error(String msg){
        if(LogTraceUtil.getTraceId()==null){
            logger.error(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+msg);
        }else {
            logger.error(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+LogTraceUtil.getTraceId()+":"+ msg);
        }
    }

    public void error(String msg,Throwable t){
        if(LogTraceUtil.getTraceId()==null) {
            logger.error(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+msg, t);
        }else {
            logger.error(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+LogTraceUtil.getTraceId()+":"+ msg,t);
        }
    }

    public void info(String msg){
        if(LogTraceUtil.getTraceId()==null){
            logger.info(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+msg);
        }else {
            logger.info(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+LogTraceUtil.getTraceId() + ":" + msg);
        }
    }

    public void info(String msg,Throwable t){
        if(LogTraceUtil.getTraceId()==null) {
            logger.info(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+msg, t);
        }else {
            logger.info(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+LogTraceUtil.getTraceId() + ":" + msg, t);
        }
    }

    public void debug(String msg){
        if(LogTraceUtil.getTraceId()==null){
            logger.debug(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+msg);
        }else {
            logger.debug(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+LogTraceUtil.getTraceId() + ":" + msg);
        }
    }

    public void debug(String msg,Throwable t){
        if(LogTraceUtil.getTraceId()==null) {
            logger.debug(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+msg, t);
        }else {
            logger.debug(Thread.currentThread().getStackTrace()[2].getLineNumber()+" "+LogTraceUtil.getTraceId() + ":" + msg, t);
        }
    }

}
