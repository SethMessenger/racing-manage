package com.wxmp.core.util;

import java.util.UUID;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/10
 */
public class UuidGenerator {

    /**
     * 生成32位uuid
     * @return
     */
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
