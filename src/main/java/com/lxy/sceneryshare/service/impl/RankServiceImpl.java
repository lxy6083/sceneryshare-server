package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.RankMapper;
import com.lxy.sceneryshare.domain.Rank;
import com.lxy.sceneryshare.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
    public Integer getMark(Integer userId, Integer sceneryshareId) {
        return mapper.getMark(userId,sceneryshareId);
    }

    /**
     * 获取总分
     * @param sceneryshareId
     * @return
     */
    @Override
    public int getScoreSum(Integer sceneryshareId) {
        return mapper.getScoreSum(sceneryshareId);
    }

    /**
     * 获取总人数
     * @param sceneryshareId
     * @return
     */
    @Override
    public int getScoreNum(Integer sceneryshareId) {
        return mapper.getScoreSum(sceneryshareId);
    }

    /**
     * 获取平均分
     * @param sceneryshareId
     * @return
     */
    @Override
    public double getAvgScore(Integer sceneryshareId) {
        int scoreSum = mapper.getScoreSum(sceneryshareId);
        int scoreNum = mapper.getScoreNum(sceneryshareId);
        //防止分母为0报错
        if (scoreNum == 0) {
            scoreNum = 1;
        }
        double avgScore = new BigDecimal(scoreSum / scoreNum).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return avgScore;
    }


}
