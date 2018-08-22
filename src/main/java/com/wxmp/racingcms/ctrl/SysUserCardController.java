package com.wxmp.racingcms.ctrl;

import com.google.common.collect.Maps;
import com.wxmp.backstage.sys.domain.SysUser;
import com.wxmp.core.util.SessionUtilsWeb;
import com.wxmp.racingcms.domain.RSaleCard;
import com.wxmp.racingcms.service.RSysCardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/23
 */
@Controller
@RequestMapping("/racingcms/syscard")
public class SysUserCardController {

    @Autowired
    private RSysCardService cardService;

    /**
     * 客户端用户列表查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/listForPage")
    public ModelAndView listForPage(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/racingcms/coinCardList");
        SysUser user = SessionUtilsWeb.getUser(request);
        List<RSaleCard> list = cardService.listForPage(user.getId());
        mv.addObject("list",list);
        return mv;
    }

    /**
     * 新增分销充值卡
     * @param request
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String, String> saleCardrAdd(HttpServletRequest request){
        Map<String, String> resultMap = Maps.newHashMap();
        try {
            SysUser user = SessionUtilsWeb.getUser(request);
            String sysUserUuid = user.getId();
            Integer amount = Integer.valueOf(request.getParameter("amount"));

            if(null != user && StringUtils.isNotEmpty(sysUserUuid) && null != amount && amount >0){
                RSaleCard card = new RSaleCard(user.getId(), (byte)0, amount, user.getId(), "remark");
                this.cardService.add(card);
                resultMap.put("errorCode", "0");
                resultMap.put("errorMsg", "添加成功");
            }else {
                resultMap.put("errorCode", "999");
                resultMap.put("errorMsg", "请检查您的创建参数");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("errorCode", "999");
            resultMap.put("errorMsg", "系统错误，请联系管理员");
        }
        return resultMap;
    }

}
