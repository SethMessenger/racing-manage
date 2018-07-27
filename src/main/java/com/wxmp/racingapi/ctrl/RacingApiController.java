package com.wxmp.racingapi.ctrl;

import com.wxmp.racingapi.common.ErrorCodeEnum;
import com.wxmp.racingapi.service.MatchService;
import com.wxmp.racingapi.service.UserCoinService;
import com.wxmp.racingapi.service.UserService;
import com.wxmp.racingapi.vo.form.LoginForm;
import com.wxmp.racingapi.vo.form.MatchForm;
import com.wxmp.racingapi.vo.form.UserRegisForm;
import com.wxmp.racingapi.vo.view.*;
import com.wxmp.racingapi.vo.form.UserPayForm;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.domain.RUserCoin;
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
    @Autowired
    private MatchService matchService;

    /**
     * 使用找回码，重新设置密码
     * @param request
     * @param user
     * @return
     */
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/resetPwd/{code}",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView resetPwd(HttpServletRequest request, @RequestBody UserRegisForm user, @PathVariable String code) {
        if(null == user || StringUtils.isEmpty(code)
                || StringUtils.isEmpty(user.getPwd()) || StringUtils.isEmpty(user.getMobile())){
            return BaseView.PARAM_ERROR;
        }
        UserAccountView resultUser = this.userService.resetPwd(code, user);
        if(null != resultUser){
            //暂时不返回账户信息
            return new ObjectView<UserAccountView>(resultUser);
        }else {
            return BaseView.FAIL;
        }
    }

    /**
     * 找回密码 生成验证码
     * @param request
     * @param mobile
     * @return
     */
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/find/{mobile}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView find(HttpServletRequest request, @PathVariable String mobile) {
        try {
            String code = this.userService.findCode(mobile);
            return new ObjectView<String>(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return BaseView.FAIL;
    }

    /**
     * 更新信息
     * @param request
     * @param user
     * @return
     */
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/updateUserInfo",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView updateUserInfo(HttpServletRequest request, @RequestBody UserRegisForm user) {
        UserAccountView resultUser = this.userService.updateUserInfo(user);
        if(null != resultUser){
            //暂时不返回账户信息
            return new ObjectView<UserAccountView>(resultUser);
        }else {
            return BaseView.FAIL;
        }
    }

    /**
     * 绑定手机号，直接进行账户创建
     * @param request
     * @return
     */
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/bindMobile",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView bindMobile(HttpServletRequest request, @RequestParam("code")String code, @RequestBody UserRegisForm form) {
        try {
            UserAccountView view = this.userService.registerUser(code, form);
            if(null != view){
                return new ObjectView<UserAccountView>(view);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return BaseView.FAIL;
    }

    /**
     * 生成验证码
     * @param request
     * @param mobile
     * @return
     */
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/createCode/{mobile}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView checkMobile(HttpServletRequest request, @PathVariable String mobile) {
        try {
            String code = this.userService.identifyCode(mobile);
            return new ObjectView<String>(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return BaseView.FAIL;
    }


    /**
     * 获取用户信息
     * @param request
     * @param form
     * @return
     */
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/login",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView login(HttpServletRequest request, @RequestBody LoginForm form) {
        BaseView result = null;
        if(null != form && StringUtils.isNotEmpty(form.getMobile()) && StringUtils.isNotEmpty(form.getPwd())){
            RUser user = this.userService.login(form);
            if(null != user){
                UserAccountView view = this.userService.getUserInfo(user.getUuid());
                if (null != view) {
                    result = new ObjectView<UserAccountView>(view);
                }else {
                    result = new ObjectView<UserAccountView>(ErrorCodeEnum.USER_ERROR);
                }
            }

        }
        return result;
    }

    /**
     * 获取用户信息
     * @param request
     * @param userUuid
     * @return
     */
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/user/{userUuid}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView getUser(HttpServletRequest request, @PathVariable String userUuid) {
        BaseView result = null;
        if(StringUtils.isNotEmpty(userUuid)){
            UserAccountView view = this.userService.getUserInfo(userUuid);
            if (null != view) {
                result = new ObjectView<UserAccountView>(view);
            }else {
                result = new ObjectView<UserAccountView>(ErrorCodeEnum.USER_ERROR);
            }
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
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/coins/{userUuid}",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView payMatch(HttpServletRequest request, @PathVariable String userUuid, @RequestBody UserPayForm form) {
        BaseView result = null;
        if(StringUtils.isNotEmpty(userUuid)){
            this.userCoinService.payMatch(userUuid, form.getAmount(), form.getMatchUuid(), Integer.valueOf(form.getWins()));
            result = BaseView.SUCCESS;
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
    @CrossOrigin(maxAge = 3600)
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
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/match/{matchType}",  method = RequestMethod.GET)
    @ResponseBody
    public BaseView matchInfo(HttpServletRequest request, @PathVariable Integer matchType) {
        BaseView result = null;
        if(null != matchType && matchType == 1){
            MatchDetailView view = this.matchService.queryMatchResults(matchType);
            result = new ObjectView<MatchDetailView>(view);
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
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/match/result",  method = RequestMethod.POST)
    @ResponseBody
    public BaseView matchResult(HttpServletRequest request, @RequestBody MatchForm form) {
        BaseView result = BaseView.FAIL;
        if(null != form && StringUtils.isNotEmpty(form.getMatchUuid())) {
            MatchDetailResultView view = this.matchService.queryMatchDetailRequest(form.getMatchUuid());
            return new ObjectView<MatchDetailResultView>(view);
        }else {
            return BaseView.PARAM_ERROR;
        }
    }

}
