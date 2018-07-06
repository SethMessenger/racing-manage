package com.wxmp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xunbo.xu
 * @desc    测试类目
 * @date 18/3/7
 */
public class Test {

    public static void main(String[] args){

        String s = "a$s$c";
        String result = s.replaceAll("[$]", "d");
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "value");

        System.out.print(result);
    }

}
