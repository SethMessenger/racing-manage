package com.wxmp.wxcms.ctrl;

import com.wxmp.backstage.sys.domain.SysUser;
import com.wxmp.backstage.sys.service.ISysUserService;
import com.wxmp.core.util.SessionUtilsWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xunbo.xu
 * @desc    用于加载内容的controller
 * @date 18/3/8
 */
@Controller
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 加载指定页面
     * @param path
     * @return
     */
    @RequestMapping("load/{path}")
    public ModelAndView testVelocity(HttpServletRequest request,
                                     @PathVariable(required = true, value = "path") String path){
        if(path.contains("$")){
            path = path.replaceAll("[$]", "/");
        }
        ModelAndView mv = new ModelAndView(path);
        SysUser sysUser = SessionUtilsWeb.getUser(request);
        mv.addObject("account", sysUser.getAccount());
        mv.addObject("userId", sysUser.getId());
        return mv;
    }

}
