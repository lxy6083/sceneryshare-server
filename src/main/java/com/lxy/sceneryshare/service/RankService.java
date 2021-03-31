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
    public Rank getMark(@Param("userid") Integer userId, @Param("sceneryshareId") Integer sceneryshareId);

    /**
     * 通过动态id查询动态的平均评分
     * @param sceneryshareId
     * @return
     */
    public float getAverageScore(Integer sceneryshareId);

}
