package com.wxmp.threaddemo.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/29
 */
public class BaseAgentReq implements Serializable{
    private static final long serialVersionUID = 4342155380668337754L;

    private AgentHeaderVo agentHeader;
    private Map<String, String> httpHeader;
    private String aesParams;
    private Map<String, String> extraHeader;

    public BaseAgentReq() {}

    public BaseAgentReq(AgentHeaderVo agentHeader) {
        this.agentHeader = agentHeader;
    }

    public AgentHeaderVo getAgentHeader() {
        return agentHeader;
    }

    public void setAgentHeader(AgentHeaderVo agentHeader) {
        this.agentHeader = agentHeader;
    }

    public Map<String, String> getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(Map<String, String> httpHeader) {
        this.httpHeader = httpHeader;
    }

    public String getAesParams() {
        return aesParams;
    }

    public void setAesParams(String aesParams) {
        this.aesParams = aesParams;
    }

    public Map<String, String> getExtraHeader() {
        return extraHeader;
    }

    public void setExtraHeader(Map<String, String> extraHeader) {
        this.extraHeader = extraHeader;
    }
}
