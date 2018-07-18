package com.wxmp.racingapi.vo.dto;

/**
 * @author xunbo.xu
 * @desc    用于中间业务处理的 奖品（赛车）算法模型
 * @date 18/7/10
 */
public class ArithmeticAwardDTO {

    /**编号*/
    private String id;
    /**概率（最多3位小数）*/
    private float probability;
    /**数量（该类奖品剩余数量）*/
    private long count;

    /**
     * 构造
     * @param id
     * @param probability
     * @param count
     */
    public ArithmeticAwardDTO(String id, float probability, long count) {
        super();
        this.id = id;
        this.probability = probability;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ArithmeticAwardDTO{" +
                "id='" + id + '\'' +
                ", probability=" + probability +
                ", count=" + count +
                '}';
    }
}
