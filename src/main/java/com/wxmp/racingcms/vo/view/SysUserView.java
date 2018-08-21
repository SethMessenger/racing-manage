package com.wxmp.racingcms.vo.view;

import com.wxmp.backstage.sys.domain.SysUser;
import com.wxmp.racingcms.domain.RUser;

import java.util.List;

/**
 * 系统用户业务管理
 * @author xunbo.xu
 * @desc
 * @date 18/8/20
 */
public class SysUserView extends SysUser{

    /** 关联前台用户的uuid */
    private String userUuid;
    /** 用户的金币余额，和前台用户保持一致 */
    private long total;
    /** 关联的用户列表 */
    private List<RUser> users;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<RUser> getUsers() {
        return users;
    }

    public void setUsers(List<RUser> users) {
        this.users = users;
    }
}
