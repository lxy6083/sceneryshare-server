package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.RankMapper;
import com.lxy.sceneryshare.domain.Rank;
import com.lxy.sceneryshare.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper mapper;

    /**
     * 添加评分
     * @param rank
     * @return
     */

    @Override
    public boolean insert(Rank rank) {
        return mapper.insert(rank) > 0;
    }

    /**
     * 通过userId和sceneryId查询评分信息
     * @return
     */

    @Override
    public Rank getMark(Integer userId, Integer sceneryshareId) {
        return mapper.getMark(userId,sceneryshareId);
    }

    /**
     * 通过动态id查询动态的平均评分
     * @param sceneryshareId
     * @return
     */

    @Override
    public float getAverageScore(Integer sceneryshareId) {
        return mapper.getAverageScore(sceneryshareId);
    }
}
