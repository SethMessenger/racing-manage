package com.wxmp.core.agent;

import com.alibaba.fastjson.TypeReference;
import com.wxmp.core.util.BeanUtil;
import com.wxmp.core.util.HttpUtil;
import com.wxmp.core.util.JSONUtil;
import com.wxmp.racingapi.vo.agent.ShortMessageReq;
import com.wxmp.racingapi.vo.agent.ShortMessageRes;
import org.springframework.stereotype.Component;

/**
 * @author  xunbo.xu
 * @desc    程序组件请求发送器
 * @date 18/7/20
 */
@Component
public class ComponentAgent {

    /** 发送验证码短信 */
    private static final String PUSH_SHORT_MESSAGE_URL = "http://v.juhe.cn/sms/send";

    private static final Integer IDENTIFY_CODE_TEMPLATE = 88911;
    private static final String RETURN_TYPE_JSON = "json";
    private static final String RETURN_TYPE_XML = "xml";

    /**
     * 示例: http://v.juhe.cn/sms/send?mobile=手机号码&tpl_id=短信模板ID&tpl_value=%23code%23%3D654654&key=   <br/>
     * 使用聚合数据API申请d短信发送权限，发送指定模板短信<br/>
     * @param mobile
     * @param identifyCode
     */
    public static ShortMessageRes sendShortMessage(String mobile, String identifyCode){
        ShortMessageReq req = new ShortMessageReq(mobile, IDENTIFY_CODE_TEMPLATE, identifyCode, RETURN_TYPE_JSON);
        String resultJSON = HttpUtil.doGet(PUSH_SHORT_MESSAGE_URL, BeanUtil.getAllFields(req), false);
        ShortMessageRes res = JSONUtil.jsonToObject(new TypeReference<ShortMessageRes>(){}, resultJSON);
        return res;
    }



}
