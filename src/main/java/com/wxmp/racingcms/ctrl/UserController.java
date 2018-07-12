package com.wxmp.racingcms.ctrl;

import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.service.RUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    客户端用户管理
 * @date 18/7/9
 */
@Controller
@RequestMapping("/racingcms/ruser")
public class UserController {

    @Autowired
    private RUserService rUserService;

    /**
     * 客户端用户列表查询
     * @param searchEntity
     * @return
     */
    @RequestMapping(value = "/listForPage")
    public ModelAndView listForPage(@ModelAttribute RUser searchEntity){
        ModelAndView mv = new ModelAndView("/racingcms/userlist");
        List<RUser> list = rUserService.listForPage(searchEntity);
        mv.addObject("list",list);
        return mv;
    }



}
