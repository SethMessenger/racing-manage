package com.wxmp.core.aop;

import com.wxmp.core.log.CommonLog;
import com.wxmp.core.log.LogTraceUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/13
 */
public class PerformanceAopAdvice {

    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
        // 启动一个 stop watch
        LogTraceUtil.setTraceId();
        StopWatch sw = new StopWatch();
        Object[] args=pjp.getArgs();
        // 运行计时器
        String methodName = pjp.getTarget().getClass().getName() +"."+ pjp.getSignature().getName();
        sw.start(pjp.getSignature().getName());
        // 执行业务方法
        Object returnValue = null;
        try {
            if (args!=null) {
                returnValue = pjp.proceed(args);
            }else {
                returnValue = pjp.proceed();
            }
        } catch (Throwable e) {
            if(e!=null){
                CommonLog.getLogger(PerformanceAopAdvice.class).error( e, StringUtils.EMPTY,"performanceAopAdvice aroundMethod exception : ");
            }
            throw e;
        } finally {
            sw.stop();
            LogTraceUtil.removeTraceId();
        }
        // 返回业务方法返回值
        return returnValue;
    }

}
