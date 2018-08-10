package com.wxmp.core.log;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by aohailin on 2017/2/23.
 */
public class LogTraceUtil {

    private static final ThreadLocal<String> logUtilThreadLocal = new ThreadLocal<>();

    private static final Map<Thread, Long> threadReferenceCountMap = new ConcurrentHashMap<>();

    /** 此方法在aop开始时执行 */
    public static void setTraceId() {
        Thread currentThread = Thread.currentThread();
        Long referenceCount = threadReferenceCountMap.get(currentThread);
        if (referenceCount != null) {
            referenceCount++;
        } else {
            referenceCount = 1L;
            logUtilThreadLocal.set(UUID.randomUUID().toString());
        }
        threadReferenceCountMap.put(currentThread, referenceCount);
    }

    /** 此方法在log中内置实现 */
    public static String getTraceId() {
        return logUtilThreadLocal.get();
    }

    /** 此方法在aop结束时执行 */
    public static void removeTraceId() {
        Thread currentThread = Thread.currentThread();
        Long referenceCount = threadReferenceCountMap.get(currentThread);
        if (referenceCount != null) {
            if (referenceCount == 1) {
                threadReferenceCountMap.remove(currentThread);
                logUtilThreadLocal.remove();
            } else {
                referenceCount--;
                threadReferenceCountMap.put(currentThread, referenceCount);
            }
        } else {
            logUtilThreadLocal.remove();
        }
    }
}
