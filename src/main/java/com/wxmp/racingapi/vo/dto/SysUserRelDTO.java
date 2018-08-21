package com.wxmp.racingapi.vo.dto;

import com.wxmp.racingcms.domain.RUser;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/21
 */
public class SysUserRelDTO extends RUser{

    private String sysUserUuid;

    public String getSysUserUuid() {
        return sysUserUuid;
    }

    public void setSysUserUuid(String sysUserUuid) {
        this.sysUserUuid = sysUserUuid;
    }
}
