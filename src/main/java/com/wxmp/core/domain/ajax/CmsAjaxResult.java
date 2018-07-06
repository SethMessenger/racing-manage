package com.wxmp.core.domain.ajax;

import com.wxmp.backstage.sys.domain.SysUser;

/**
 * @author xunbo.xu
 * @desc    cms中使用ajax返回的编码对象
 * @date 18/3/27
 */
public class CmsAjaxResult extends BaseAjaxResult{

    /** 当前用户名称 */
    private String userName;
    /** 当前用户ID */
    private String userId;

    /**
     * 唯一构造
     * @param user
     * @param code
     * @param msg
     */
    public CmsAjaxResult(SysUser user, Integer code, String msg){
        if(null != user){
            this.userId = user.getId();
            this.userId = user.getAccount();
        }
        super.setCode(code);
        super.setMsg(msg);
        super.setTimestamp(System.currentTimeMillis());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
