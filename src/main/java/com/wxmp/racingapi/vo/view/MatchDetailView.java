package com.wxmp.racingapi.vo.view;

import com.google.common.collect.Lists;
import com.wxmp.racingcms.domain.RMatchResult;
import com.wxmp.racingcms.domain.RMatchType;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    赛程详情前端模型定义
 * @date 18/7/19
 */
public class MatchDetailView {

    private String matchName;
    private double mutiAmount;
    private String remark;
    private MatchResultView current;
    private List<MatchResultView> history;

    public MatchDetailView() { super(); }

    /**
     * 无历史数据
     * @param type
     */
    public MatchDetailView(RMatchType type) {
        this.matchName = type.getMatchName();
        this.mutiAmount = type.getMutiAmount();
        this.remark = type.getRemark();
    }

    /**
     * 构造
     * @param type
     * @param results   按照创建时间倒序排列
     */
    public MatchDetailView(RMatchType type, List<RMatchResult> results) {
        this.matchName = type.getMatchName();
        this.mutiAmount = type.getMutiAmount();
        this.remark = type.getRemark();
        //解析最新的赛程结果
        RMatchResult now = null;
        for (RMatchResult bean : results){
            if(StringUtils.isEmpty(bean.getMatchResult())){
                this.current = new MatchResultView(bean);
            }else {
                if(null == this.history){
                    this.history = Lists.newArrayList();
                }
                history.add(new MatchResultView(bean));
            }
        }
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public double getMutiAmount() {
        return mutiAmount;
    }

    public void setMutiAmount(double mutiAmount) {
        this.mutiAmount = mutiAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public MatchResultView getCurrent() {
        return current;
    }

    public void setCurrent(MatchResultView current) {
        this.current = current;
    }

    public List<MatchResultView> getHistory() {
        return history;
    }

    public void setHistory(List<MatchResultView> history) {
        this.history = history;
    }
}
