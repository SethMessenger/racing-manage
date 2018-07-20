package com.wxmp.racingapi.vo.agent;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/20
 */
public class ShortMessageReq {

    /** 接收短信的手机号码*/
    private String mobile;
    /** 短信模板ID */
    private Integer tpl_id;
    /** 变量名和变量值对，如：#code#=431515，整串值需要urlencode，比如正确结果为：%23code%23%3d431515。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行utf-8 urlencode编码后再传递 */
    private String tpl_value;
    /** APPKEY */
    private String key = "8b7a1dbf16564fb4db14f18c18de5819";
    /** 返回数据的格式,xml或json，默认json */
    private String dtype;

    public ShortMessageReq(String mobile, Integer tpl_id, String tpl_value, String dtype) {
        this.mobile = mobile;
        this.tpl_id = tpl_id;
        try {
            this.tpl_value = URLEncoder.encode("#code#=", "UTF-8") + tpl_value;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            this.tpl_value = null;
        }
        this.dtype = dtype;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getTpl_id() {
        return tpl_id;
    }

    public void setTpl_id(Integer tpl_id) {
        this.tpl_id = tpl_id;
    }

    public String getTpl_value() {
        return tpl_value;
    }

    public void setTpl_value(String tpl_value) {
        this.tpl_value = tpl_value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }
}
