package com.wxmp.racingapi.service.impl;

import com.wxmp.backstage.common.RacingConstants;
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

    /**
     * 用户注册
     * @return
     */
    @Override
    public UserAccountView registerUser(UserRegisForm form) {
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

}
