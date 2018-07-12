package com.wxmp.racingapi.ctrl;

import com.wxmp.racingapi.common.ErrorCodeEnum;
import com.wxmp.racingapi.service.UserCoinService;
import com.wxmp.racingapi.service.UserService;
import com.wxmp.racingapi.vo.form.MatchForm;
import com.wxmp.racingapi.vo.form.UserRegisForm;
import com.wxmp.racingapi.vo.view.BaseView;
import com.wxmp.racingapi.vo.form.UserPayForm;
import com.wxmp.racingapi.vo.view.ObjectView;
import com.wxmp.racingcms.domain.RUser;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/6
 */
@Controller
@RequestMapping("/racing")
public class RacingApiController {

    private static Logger log = LogManager.getLogger(RacingApiController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserCoinService userCoinService;

    /**
     * 用户注册
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView registerUser(HttpServletRequest request, @RequestBody UserRegisForm user) {
        RUser resultUser = this.userService.registerUser(user);
        if(null != resultUser){
            return new ObjectView<RUser>(resultUser);
        }else {
            return BaseView.FAIL;
        }
    }

    /**
     * 绑定手机号
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/bindMobile/{userUuid}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView bindMobile(HttpServletRequest request, @RequestBody UserRegisForm user) {
        return BaseView.FAIL;
    }

    /**
     * 校验手机号
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/checkMobile/{userUuid}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView checkMobile(HttpServletRequest request, @RequestBody UserRegisForm user) {
        return BaseView.FAIL;
    }

    /**
     * 获取用户信息
     * @param request
     * @param userUuid
     * @return
     */
    @RequestMapping(value = "/user/{userUuid}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView getUser(HttpServletRequest request, @PathVariable String userUuid) {
        BaseView result = null;
        if(StringUtils.isNotEmpty(userUuid)){

        }else {
            result = BaseView.FAIL;
        }
        return result;
    }

    /**
     * 下注
     * @param   request
     * @param   userUuid
     * @POST    {"accountUuid":"accountUuid", "amount":100, "matchUuid":"matchUuid", "wins":"winsId"}
     * @return
     */
    @RequestMapping(value = "/coins/{userUuid}",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView payMatch(HttpServletRequest request, @PathVariable String userUuid, @RequestBody UserPayForm form) {
        BaseView result = null;
        if(StringUtils.isNotEmpty(userUuid)){
            this.userCoinService.payMatch(userUuid, form.getAmount(), form.getMatchUuid(), Integer.valueOf(form.getWins()));
        }else {
            result = BaseView.FAIL;
        }
        return result;
    }

    /**
     * TODO 查询所有赛制列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/match/list",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView matchlist(HttpServletRequest request) {
        BaseView result = null;
        result = BaseView.FAIL;
        return result;
    }

    /**
     * 获取赛程信息<br/>
     * {match_type}}前端暂时写死，可由{DOMAIN}/match/list接口进行动态返回
     * @param request
     * @param matchType
     * @return
     */
    @RequestMapping(value = "/match/{match_type}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView matchInfo(HttpServletRequest request, @PathVariable String matchType) {
        BaseView result = null;
        if(StringUtils.isNotEmpty(matchType)){

        }else {
            result = new BaseView(ErrorCodeEnum.PARAM_ERROR) {};
        }
        return result;
    }

    /**
     * 获取比赛结果<br/>
     * {"accountUuid":"accountUuid", "userUuid":"userUuid", "matchUuid":"matchUuid"}
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "/match/result",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView matchResult(HttpServletRequest request, @RequestBody MatchForm form) {
        BaseView result = null;
        result = BaseView.FAIL;
        return result;
    }

}
