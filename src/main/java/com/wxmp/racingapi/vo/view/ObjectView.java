package com.wxmp.racingapi.vo.view;

import com.wxmp.racingapi.common.ErrorCodeEnum;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/10
 */
public class ObjectView<T> extends BaseView{

    public ObjectView(ErrorCodeEnum code) {
        super(code);
    }

    public ObjectView(T data){
        super(ErrorCodeEnum.SUCCESS);
        this.data = data;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
