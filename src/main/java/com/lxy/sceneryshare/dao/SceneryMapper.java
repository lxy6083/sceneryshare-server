package com.lxy.sceneryshare.dao;


import com.lxy.sceneryshare.domain.Scenery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 景点Dao
 */
@Repository
public interface SceneryMapper {
    /**
     * 添加景点
     * @param scenery
     * @return
     */

    public int insert(Scenery scenery);

    /**
     * 更新景点信息
     * @param scenery
     * @return
     */

    public int update(Scenery scenery);

    /**
     * 删除景点
     * @param id
     * @return
     */

    public int delete(Integer id);

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
    public int toggleFlag(@Param("flag") Integer flag, @Param("id") Integer id);

    /**
     * 切换景点类型
     * @param type
     * @return
     */

    public int updateType(@Param("type") Integer type, @Param("id") Integer id);

    /**
     * 改变景点的父景点ID
     * @param parentId
     * @return
     */

    public int updateParentId(@Param("parentId") Integer parentId, @Param("id") Integer id);


}
