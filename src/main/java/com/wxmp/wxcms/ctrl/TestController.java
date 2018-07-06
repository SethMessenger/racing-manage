package com.wxmp.wxcms.ctrl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created With IntelliJ IDEA.
 * @author : Seth.Hsu
 * Date: 2018/3/7
 * Time: 23:48
 * Description:
 */
@Controller
@RequestMapping("test")
public class TestController {

    /**
     * 测试velocity的模板状态
     * @param param
     * @return
     */
    @RequestMapping("freemarker")
    public ModelAndView testVelocity(@RequestParam(required = false, value = "param") String param){
        ModelAndView mv = new ModelAndView("test");
        if(StringUtils.isEmpty(param)){
            param = "NULL_OBJ";
        }
        mv.addObject("param", param);
        return mv;
    }

}
