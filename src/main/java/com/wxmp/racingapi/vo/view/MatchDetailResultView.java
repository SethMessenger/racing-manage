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
public class MatchDetailResultView extends MatchResultView{

    public MatchDetailResultView(RMatchResult bean) {
        super(bean);
        String resultJSON = bean.getMatchResult();
        if(StringUtils.isNotEmpty(resultJSON)) {
            List<List<Integer>> indexes = JSONUtil.jsonToObject(new TypeReference<List<List<Integer>>>() {}, resultJSON);
            this.all = indexes;
        }
    }

    public List<List<Integer>> all;

    public List<List<Integer>> getAll() {
        return all;
    }

    public void setAll(List<List<Integer>> all) {
        this.all = all;
    }
}
