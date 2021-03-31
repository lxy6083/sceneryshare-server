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
     * @param id
     * @return
     */
    public int delete(Integer id);


    /**
     * 获取用户所有的收藏列表
     * @return
     */
    public List<Collect> getAllCollect(Integer userId);

}
