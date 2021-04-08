package com.lxy.sceneryshare.service;


import com.lxy.sceneryshare.domain.Scenery;

import java.util.List;

/**
 * 景点Service
 */
public interface SceneryService {
    /**
     * 添加景点
     * @param scenery
     * @return
     */

    public boolean insert(Scenery scenery);

    /**
     * 更新景点信息
     * @param scenery
     * @return
     */

    public boolean update(Scenery scenery);

    /**
     * 删除景点
     * @param id
     * @return
     */

    public boolean delete(Integer id);

    /**
     * 通过主键获取景点
     * @param id
     * @return
     */

    public Scenery getByPrimaryKey(Integer id);

    /**
     *获取所有的景点
     * @return
     */

    public List<Scenery> getAllScenery();

    /**
     * 获取一级景点列表
     * @return
     */

    public List<Scenery> getFirstScenery();

    /**
     * 获取二级景点列表
     * @return
     */

    public List<Scenery> getSecondScenery();

    /**
     * 切换是否可用
     * @param flag
     * @param id
     * @return
     */
    public boolean toggleFlag(Integer flag, Integer id);

    /**
     * 切换景点类型
     * @param type
     * @return
     */

    public boolean updateType(Integer type, Integer id);

    /**
     * 改变景点的父景点ID
     * @param parentId
     * @return
     */

    public boolean updateParentId(Integer parentId, Integer id);

}
