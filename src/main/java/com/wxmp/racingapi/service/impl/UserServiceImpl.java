package com.wxmp.racingapi.service.impl;

import com.wxmp.backstage.common.RacingConstants;
import com.wxmp.racingapi.service.ComponentService;
import com.wxmp.racingapi.service.UserService;
import com.wxmp.racingapi.vo.form.UserRegisForm;
import com.wxmp.racingapi.vo.view.UserAccountView;
import com.wxmp.racingcms.domain.RUser;
import com.wxmp.racingcms.domain.RUserCoin;
import com.wxmp.racingcms.mapper.RUserCoinMapper;
import com.wxmp.racingcms.service.RUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author  xunbo.xu
 * @desc
 * @date 18/7/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private RUserService rUserService;
    @Autowired
    private RUserCoinMapper rUserCoinMapper;
    @Autowired
    private ComponentService componentService;

    /** 验证码池,验证码 ： 手机号 */
    private ConcurrentHashMap<String, String> codePool = new ConcurrentHashMap<String, String>();

    /**
     * 用户信息修改
     * @param form
     * @return
     */
    @Override
    public UserAccountView registerUser(UserRegisForm form) {
        if(!this.checkUserAccount(form)){
            return null;
        }
        RUser user = new RUser(RacingConstants.RACING_SYS_ACCOUNT , form);
        if(this.rUserService.add(user) > 0){
            //添加金币账户
            RUserCoin coin = new RUserCoin(RacingConstants.RACING_SYS_ACCOUNT, user.getUuid(), user.getUserNickname(),
                    user.getMobile(), user.getOpenId());
            if(this.rUserCoinMapper.insert(coin) > 0){
                return new UserAccountView(user, coin);
            }else {
                //回滚账户
                this.rUserService.delete(user);
                return null;
            }
        }else {
            return null;
        }
    }

    /**
     * 用户手机注册
     *
     * @param mobile
     * @param code
     * @return
     */
    @Override
    public UserAccountView registerUser(String mobile, String code) {
        if(codePool.keySet().contains(code) && codePool.get(code).equalsIgnoreCase(mobile)){
            //自动生成一个用户名和昵称
            String nickName = getStringRandom();
            String userName = mobile;
            UserRegisForm form = new UserRegisForm();
            form.setUserNickName(nickName);
            form.setUserName(userName);
            form.setMobile(mobile);
            return registerUser(form);
        }else {
            return null;
        }
    }

    /**
     * 检测账户可用性
     * @param form
     * @return
     */
    @Override
    public boolean checkUserAccount(UserRegisForm form){
        //用户现保证mobile & openId唯一
        String openId = form.getOpenId();
        String mobile = form.getMobile();
        RUser condition = new RUser();
        condition.setMobile(mobile);
        condition.setOpenId(openId);
        List<RUser> users = this.rUserService.listForPage(condition);
        if(CollectionUtils.isNotEmpty(users)){
            return false;
        }
        return true;
    }


    /**
     * 用户信息查询
     *
     * @param userUuid
     * @return
     */
    @Override
    public UserAccountView getUserInfo(String userUuid) {
        RUser user = this.rUserService.getById(userUuid);
        RUserCoin userCoinCondition = new RUserCoin();
        userCoinCondition.setUserUuid(userUuid);
        List<RUserCoin> coinAccount = this.rUserCoinMapper.selectByCondition(userCoinCondition);
        if(null == user || CollectionUtils.isEmpty(coinAccount)){
            //账户异常
            return null;
        }
        return new UserAccountView(user, coinAccount.get(0));
    }

    /**
     * 为当前用户获取验证码
     *
     * @param mobile
     * @return
     */
    @Override
    public String identifyCode(String mobile) {

        String code = getIdentifyCode();
        while (codePool.keySet().contains(code)){
            code = getIdentifyCode();
        }
        codePool.put(code, mobile);
        this.componentService.pushIdentifyShortMessage(mobile, code);
        return code;
    }

    /****************************** 私有工具 ******************************

    /**
     * 生成随机用户名，数字和字母组成,
     * @return
     */
    private String getStringRandom() {
        int length = 8;
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 生成6位验证码
     * @return
     */
    private String getIdentifyCode() {
        int length = 6;
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

}
