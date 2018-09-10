package com.wxmp.racingapi.ctrl;

import com.wxmp.core.util.wx.SignUtil;
import com.wxmp.racingapi.common.WechatConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/9/10
 */
@Controller
@RequestMapping("/racingwx")
public class WechatController {

    /**
     * GET请求：进行URL、Tocken 认证；
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     */
    @RequestMapping(value = "/notify",  method = RequestMethod.GET)
    public @ResponseBody
    String doGet(HttpServletRequest request) {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        // 校验成功返回  echostr，成功成为开发者；否则返回error，接入失败
        if (SignUtil.validSign(signature, WechatConstants.WECHAT_TOKEN, timestamp, nonce)) {
            return echostr;
        }
        return "error";
    }


}
