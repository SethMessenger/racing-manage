package com.wxmp.racingapi.common;

/**
 * @author xunbo.xu
 * @desc    错误码枚举
 * @date 18/7/8
 */
public enum ErrorCodeEnum {

    SUCCESS(1, "SUCCESS"),
    FAIL(9999, "FAIL"),
    PARAM_ERROR(1001, "param required");

    private int error;
    private String errorMsg;

    private ErrorCodeEnum(){}
    private ErrorCodeEnum(int error, String errorMsg){
        this.error = error;
        this.errorMsg = errorMsg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
