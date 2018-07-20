package com.wxmp.racingapi.ctrl;

import com.wxmp.racingapi.vo.view.BaseView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  xunbo.xu
 * @desc    用于支付路由
 * @date 18/7/17
 */
@Controller
@RequestMapping("pay")
public class PayController {

    /**
     * 跳转微信的H5支付页面<br/>
     * 直接302跳转
     * @return
     */
    @RequestMapping("toWechatH5")
    @ResponseBody
    public BaseView toWechatH5Pay(HttpServletRequest request, HttpServletResponse response){
        BaseView result = BaseView.FAIL;
        //组装微信
        return result;
    }

}
