package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.SceneryShare;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 风景分享数据service层
 */
public interface SceneryShareService {
    /**
     * 添加风景分享
     * @param sceneryShare
     * @return
     */
    public boolean insert(SceneryShare sceneryShare);

    /**
     * 修改风景分享信息
     * @param sceneryShare
     * @return
     */

    public boolean update(SceneryShare sceneryShare);

    /**
     * 删除风景分享
     * @param id
     * @return
     */

    public boolean delete(Integer id);

    /**
     * 按主键查找
     * @param id
     * @return
     */

    public SceneryShare getByPrimaryKey(Integer id);

    /**
     * 获取所有风景分享列表
     * @return
     */

    public List<SceneryShare> getAllSceneryShare();

    /**
     * 根据用户Id查找
     * @param userId
     * @return
     */
    public List<SceneryShare> getSceneryByUserId(Integer userId);


    /**
     * 通过天气查询
     * @param weather
     * @return
     */

    public List<SceneryShare> getByWeather(Integer weather);

    /**
     * 通过时段查询
     * @param timeBucket
     * @return
     */

    public List<SceneryShare> getByTimeBucket(Integer timeBucket);

    /**
     * 通过季节查询
     * @param season
     * @return
     */

    public List<SceneryShare> getBySeason(Integer season);


    /**
     * 设置/取消精华
     * @param essence
     * @param id
     * @return
     */

    public boolean toggleEssence(Byte essence, Integer id);

    /**
     * 通过用户id获取用户总动态数
     * @param userId
     * @return
     */
    public int getCountByUserId(Integer userId);

    /**
     * 设置是否可见
     * @param visible
     * @param id
     * @return
     */

    public boolean toggleVisible(Byte visible, Integer id);
}
