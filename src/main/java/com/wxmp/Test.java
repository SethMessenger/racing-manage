package com.wxmp;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wxmp.racingapi.common.WxPayUtils;
import com.wxmp.racingapi.service.impl.ArithmeticServiceImpl;
import com.wxmp.racingapi.vo.dto.ArithmeticAwardDTO;
import com.wxmp.racingapi.vo.view.UserAccountView;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.domain.RUserCoin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


/**
 * @author xunbo.xu
 * @desc    测试类目
 * @date 18/3/7
 */
public class Test {

    public static void main(String[] args){

        /** 数组阻塞队列， 指定默认长度后即不可变更 */
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(20);
        /** 延迟队列 , 队列中对象需要实现 delaty接口 */
        //blockingQueue = new DelayQueue();
        /** 链阻塞队列 */
        blockingQueue = new LinkedBlockingQueue();
        /** 具有优先级的阻塞队列 */
        blockingQueue = new PriorityBlockingQueue<>();
        /** 同步队列 */
        blockingQueue = new SynchronousQueue<>();



    }

}
