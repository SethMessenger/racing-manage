package com.wxmp.racingapi.ctrl;

import com.wxmp.racingapi.common.ErrorCodeEnum;
import com.wxmp.racingapi.service.impl.ComponentServiceImpl;
import com.wxmp.racingapi.vo.view.BaseView;
import com.wxmp.racingapi.vo.view.MatchDetailView;
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
public class TestController {

    @Autowired
    private ComponentServiceImpl componentService;

    @RequestMapping(value = "/match/{matchType}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView matchInfo(HttpServletRequest request, @PathVariable Integer matchType) {
        BaseView result = null;

        return result;
    }


}
