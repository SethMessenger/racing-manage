package com.wxmp.racingcms.ctrl;

import com.google.common.collect.Maps;
import com.wxmp.backstage.sys.domain.SysUser;
import com.wxmp.backstage.sys.service.ISysUserService;
import com.wxmp.core.util.SessionUtilsWeb;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.mapper.RUserMapper;
import com.wxmp.racingcms.vo.view.SysUserView;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/20
 */
@Controller
@RequestMapping("/racingcms/sysuser")
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private RUserMapper userMapper;

    /**
     * 客户端用户列表查询
     * @param searchEntity
     * @return
     */
    @RequestMapping(value = "/listForPage")
    public ModelAndView listForPage(@ModelAttribute SysUser searchEntity){
        ModelAndView mv = new ModelAndView("/racingcms/sysuserlist");
        List<SysUserView> list = iSysUserService.getSysUserList(searchEntity, 0);
        mv.addObject("list",list);
        return mv;
    }

    /**
     * 新增系统管理用户
     * @param sysUser
     * @param request
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String, String> sysUserAdd(@ModelAttribute SysUserView sysUser, HttpServletRequest request){
        Map<String, String> resultMap = Maps.newHashMap();
        try {
            SysUser user = SessionUtilsWeb.getUser(request);
            String rel_phone = request.getParameter("rel_phone");
            RUser filter = new RUser();
            filter.setMobile(rel_phone);
            List<RUser> users = this.userMapper.listForPage(filter);
            if(CollectionUtils.isNotEmpty(users)){
                RUser u = users.get(0);
                String userUuid = u.getUuid();
                sysUser.setUserUuid(userUuid);
                iSysUserService.addSysUserInfo(sysUser, user);
                resultMap.put("errorCode", "0");
                resultMap.put("errorMsg", "添加成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("errorCode", "999");
            resultMap.put("errorMsg", "系统错误，请联系管理员");
        }
        return resultMap;
    }

    @RequestMapping(value = "/info/{sysUserUuid}")
    public ModelAndView sysUserInfo(@PathVariable String sysUserUuid){
        ModelAndView mv = new ModelAndView("/racingcms/sysuserlist");
        SysUser searchEntity = new SysUser();
        searchEntity.setId(sysUserUuid);
        List<SysUserView> list = iSysUserService.getSysUserList(searchEntity, 1);
        if(CollectionUtils.isNotEmpty(list)){
            SysUserView sysUser = list.get(0);
            mv.addObject("user",sysUser);
        }
        return mv;
    }

}
