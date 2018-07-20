package com.wxmp.racingapi.vo.agent;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/20
 */
public class UnionDataBaseRes {

    private String reason;
    private Long error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getError_code() {
        return error_code;
    }

    public void setError_code(Long error_code) {
        this.error_code = error_code;
    }
}
