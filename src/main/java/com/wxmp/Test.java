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


/**
 * @author xunbo.xu
 * @desc    测试类目
 * @date 18/3/7
 */
public class Test {

    public static void main(String[] args){

        Map<String, String> params = new HashMap<>();
        params.put("appid", "wx51f257775c37d37d");
        params.put("attach", "支付测试");
        params.put("body", "H5支付测试");
        params.put("mch_id", "1509817261");
        params.put("nonce_str", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        params.put("notify_url", "http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php");
        params.put("openid", "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
        params.put("out_trade_no", "0000000001");
        params.put("spbill_create_ip", "14.23.150.211");
        params.put("total_fee", "1");
        params.put("trade_type", "MWEB");
        params.put("scene_info", "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"https://pay.qq.com\",\"wap_name\": \"腾讯充值\"}}");
        System.out.println(WxPayUtils.createSign(params, "PQBXx6aNpTA4Eyjliuu31NA8CIewSNF8"));


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
