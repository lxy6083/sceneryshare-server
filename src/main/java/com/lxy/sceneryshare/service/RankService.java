package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.Rank;
import org.apache.ibatis.annotations.Param;

/**
 * 评分Service层
 */

public interface RankService {

    /**
     * 添加评分
     * @param rank
     * @return
     */
    public boolean insert(Rank rank);

    /**
     * 通过userId和sceneryId查询评分信息
     * @return
     */
    public Integer getMark(@Param("userid") Integer userId, @Param("sceneryshareId") Integer sceneryshareId);

    /**
     * 获取总分
     * @param sceneryshareId
     * @return
     */
    public int getScoreSum(Integer sceneryshareId);

    /**
     * 获取总人数
     * @param sceneryshareId
     * @return
     */

    public int getScoreNum(Integer sceneryshareId);

    /**
     * 获取平均分
     * @param sceneryshareId
     * @return
     */
    public double getAvgScore(Integer sceneryshareId);

}
