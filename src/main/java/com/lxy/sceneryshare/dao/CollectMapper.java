package com.lxy.sceneryshare.dao;

import com.lxy.sceneryshare.domain.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收藏Dao层
 */
@Repository
public interface CollectMapper {

    /**
     *添加收藏
     * @param collect
     * @return
     */
    public int insert(Collect collect);

    /**
     *取消收藏
     * @param userId
     * @param sceneryshareId
     * @return
     */
    public int delete(@Param("userId") Integer userId, @Param("sceneryshareId") Integer sceneryshareId);


    /**
     * 获取用户所有的收藏列表
     * @return
     */
    public List<Collect> getAllCollect(Integer userId);

    /**
     * 是否收藏
     * @param sceneryshareId
     * @param userId
     * @return
     */
    public int isCollect(@Param("sceneryshareId") Integer sceneryshareId, @Param("userId") Integer userId);

}
