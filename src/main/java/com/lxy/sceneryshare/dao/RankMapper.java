package com.lxy.sceneryshare.dao;

import com.lxy.sceneryshare.domain.Rank;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {

    /**
     * 添加评分
     * @param rank
     * @return
     */
    public int insert(Rank rank);

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
