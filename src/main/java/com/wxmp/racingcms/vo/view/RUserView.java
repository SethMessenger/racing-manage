package com.wxmp.racingcms.vo.view;

import com.wxmp.racingcms.domain.RUser;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/14
 */
public class RUserView extends RUser{

    /** 用户账户余额 */
    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
