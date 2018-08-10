package com.wxmp.racingapi.ctrl;

import com.wxmp.core.log.CommonLog;
import com.wxmp.core.util.HttpRequestDeviceUtils;
import com.wxmp.racingapi.vo.form.WechatPayOrderForm;
import com.wxmp.racingapi.vo.view.BaseView;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  xunbo.xu
 * @desc    用于支付路由
 * @date 18/7/17
 */
@Controller
@RequestMapping("racing/pay")
public class PayController {

    /**
     * 跳转微信的H5支付页面<br/>
     * 直接302跳转
     * @return
     */
    @RequestMapping(name = "toWechatH5", method = RequestMethod.POST)
    @ResponseBody
    public BaseView toWechatH5Pay(HttpServletRequest request, HttpServletResponse response, @RequestBody WechatPayOrderForm form){
        BaseView result = BaseView.FAIL;
        System.out.println("--pay start--");
        String ip = HttpRequestDeviceUtils.getRealIp(request);
        if (StringUtils.isBlank(ip)) {
            ip = "127.0.0.1";
        }
        //组装微信
        return result;
    }

    /**
     * 测试支付前的用户回调（获取临时openID进行支付）
     * @param request
     * @param response
     * @param userUuid
     * @return
     */
    @RequestMapping(name = "openid_callback/{userUuid}", method = RequestMethod.GET)
    @ResponseBody
    public BaseView openIdCallback(HttpServletRequest request, HttpServletResponse response, @PathVariable String userUuid){
        BaseView result = BaseView.SUCCESS;
        CommonLog.getLogger(PayController.class).info("openIdCallback ===>>>> " + request.getRequestURL().toString());

        return result;
    }

}
