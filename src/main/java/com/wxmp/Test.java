package com.wxmp;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wxmp.racingapi.service.impl.ArithmeticServiceImpl;
import com.wxmp.racingapi.vo.dto.ArithmeticAwardDTO;
import com.wxmp.racingapi.vo.view.UserAccountView;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.domain.RUserCoin;

import java.util.List;


/**
 * @author xunbo.xu
 * @desc    测试类目
 * @date 18/3/7
 */
public class Test {

    public static void main(String[] args){

        List<List<Integer>> finals = Lists.newArrayList();
        List<Integer> i1 = Lists.newArrayList();
        i1.add(1);
        i1.add(2);
        i1.add(3);
        List<Integer> i2 = Lists.newArrayList();
        i2.add(3);
        i2.add(2);
        i2.add(1);
        finals.add(i1);
        finals.add(i2);
        System.out.println(JSON.toJSONString(finals));

        RUser user = new RUser();
        user.setUuid("uuid");
        user.setUserName("username");
        user.setUserNickname("userNickName");
        user.setMobile("mobile");
        user.setOpenId("openId");
        user.setEmail("email");

        RUserCoin coin  = new RUserCoin();
        coin.setUuid("accountUuid");
        coin.setTotal(1000L);

        UserAccountView view = new UserAccountView(user, coin);
        System.out.println(JSON.toJSONString(view));
        System.out.println(System.currentTimeMillis());

        ArithmeticServiceImpl service = new ArithmeticServiceImpl();
        List<ArithmeticAwardDTO> list = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            ArithmeticAwardDTO dto = new ArithmeticAwardDTO(String.valueOf(i), 0.1f * i, 10 * i);
            list.add(dto);
        }
        //ArithmeticServiceImpl.lottery(list);

    }

}
