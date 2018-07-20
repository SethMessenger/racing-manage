package com.wxmp.racingapi.ctrl;

import com.wxmp.racingapi.service.impl.ComponentServiceImpl;
import com.wxmp.racingapi.vo.view.BaseView;
import com.wxmp.racingapi.vo.view.ObjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/20
 */
@Controller
@RequestMapping("racing")
public class TestRacingController {

    @Autowired
    private ComponentServiceImpl componentService;

    /**
     * 测试发送验证码
     * @param request
     * @param mobile
     * @param code
     * @return
     */
    @RequestMapping(value = "/testPush/{mobile}/{code}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView matchInfo(HttpServletRequest request, @PathVariable String mobile, @PathVariable String code) {
        BaseView result = BaseView.FAIL;
        try {
            Integer returnInt = this.componentService.pushIdentifyShortMessage(mobile, code);
            result = new ObjectView<Integer>(returnInt);
        }catch (Exception e){
            e.printStackTrace();
            result = BaseView.FAIL;
        }
        return result;
    }


}
