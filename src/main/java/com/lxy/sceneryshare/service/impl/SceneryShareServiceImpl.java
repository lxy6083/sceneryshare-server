package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.SceneryShareMapper;
import com.lxy.sceneryshare.domain.SceneryShare;
import com.lxy.sceneryshare.service.SceneryShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SceneryShareServiceImpl implements SceneryShareService {

    @Autowired
    private SceneryShareMapper sceneryShareMapper;

    /**
     * 添加风景分享
     * @param sceneryShare
     * @return
     */
    @Override
    public boolean insert(SceneryShare sceneryShare) {
        return sceneryShareMapper.insert(sceneryShare) > 0;
    }

    /**
     * 修改风景分享信息
     * @param sceneryShare
     * @return
     */
    @Override
    public boolean update(SceneryShare sceneryShare) {
        return sceneryShareMapper.update(sceneryShare) > 0;
    }

    /**
     * 删除风景分享
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return sceneryShareMapper.delete(id) > 0;
    }

    /**
     * 按主键查找
     * @param id
     * @return
     */
    @Override
    public SceneryShare getByPrimaryKey(Integer id) {
        return sceneryShareMapper.getByPrimaryKey(id);
    }

    /**
     * 获取所有风景分享列表
     * @return
     */
    @Override
    public List<SceneryShare> getAllSceneryShare() {
        return sceneryShareMapper.getAllSceneryShare();
    }

    /**
     * 根据用户Id查找
     * @param userId
     * @return
     */
    @Override
    public List<SceneryShare> getSceneryByUserId(Integer userId) {
        return sceneryShareMapper.getSceneryByUserId(userId);
    }

    /**
     * 通过天气查询
     * @param weather
     * @return
     */
    @Override
    public List<SceneryShare> getByWeather(Integer weather) {
        return sceneryShareMapper.getByWeather(weather);
    }

    /**
     * 通过时段查询
     * @param timeBucket
     * @return
     */

    @Override
    public List<SceneryShare> getByTimeBucket(Integer timeBucket) {
        return sceneryShareMapper.getByTimeBucket(timeBucket);
    }

    /**
     * 通过季节查询
     * @param season
     * @return
     */
    @Override
    public List<SceneryShare> getBySeason(Integer season) {
        return sceneryShareMapper.getBySeason(season);
    }

    /**
     * 设置/取消精华
     * @param essence
     * @param id
     * @return
     */

    @Override
    public boolean toggleEssence(Byte essence, Integer id) {
        return sceneryShareMapper.toggleEssence(essence, id) > 0;
    }

    /**
     * 通过用户id获取用户总动态数
     * @param userId
     * @return
     */
    @Override
    public int getCountByUserId(Integer userId) {
        return sceneryShareMapper.getCountByUserId(userId);
    }

    /**
     * 设置是否可见
     * @param visible
     * @param id
     * @return
     */
    @Override
    public boolean toggleVisible(Byte visible, Integer id) {
        return sceneryShareMapper.toggleVisible(visible,id) > 0;
    }
}
