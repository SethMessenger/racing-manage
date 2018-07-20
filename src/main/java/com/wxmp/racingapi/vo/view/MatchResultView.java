package com.wxmp.racingapi.vo.view;

import com.alibaba.fastjson.TypeReference;
import com.wxmp.core.util.JSONUtil;
import com.wxmp.racingcms.domain.RMatchResult;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/19
 */
public class MatchResultView {

    /** 赛果uuid */
    private String matchResultUuid;
    /** 亚军编码 */
    private Integer second;
    /** 季军编码 */
    private Integer third;
    /** 最终赛果 */
    private List<Integer> resultDetail;
    /** 冠军编码 */
    private Integer champion;

    public MatchResultView() { super(); }

    public MatchResultView(RMatchResult bean) {
        this.matchResultUuid = bean.getUuid();
        String resultJSON = bean.getMatchResult();
        if(StringUtils.isNotEmpty(resultJSON)){
            List<List<Integer>> indexes = JSONUtil.jsonToObject(new TypeReference<List<List<Integer>>>(){}, resultJSON);
            this.resultDetail = indexes.get(indexes.size()-1);
            this.champion = indexes.get(indexes.size()-1).get(0);
            this.second = indexes.get(indexes.size()-1).get(1);
            this.third = indexes.get(indexes.size()-1).get(2);
        }
    }

    public String getMatchResultUuid() {
        return matchResultUuid;
    }

    public void setMatchResultUuid(String matchResultUuid) {
        this.matchResultUuid = matchResultUuid;
    }

    public Integer getChampion() {
        return champion;
    }

    public void setChampion(Integer champion) {
        this.champion = champion;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getThird() {
        return third;
    }

    public void setThird(Integer third) {
        this.third = third;
    }

    public List<Integer> getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(List<Integer> resultDetail) {
        this.resultDetail = resultDetail;
    }
}
