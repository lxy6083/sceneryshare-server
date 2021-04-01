package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.Collect;

import java.util.List;

/**
 * 收藏Service层
 */
public interface CollectService {
    /**
     * 添加收藏
     * @param collect
     * @return
     */
    public boolean insert(Collect collect);

    /**
     *取消收藏
     * @param userId
     * @param sceneryshareId
     * @return
     */
    public boolean delete(Integer userId, Integer sceneryshareId);


    /**
     * 获取用户所有的收藏列表
     * @return
     */
    public List<Collect> getAllCollect(Integer userId);
}
