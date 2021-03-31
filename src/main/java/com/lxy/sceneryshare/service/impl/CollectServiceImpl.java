package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.CollectMapper;
import com.lxy.sceneryshare.domain.Collect;
import com.lxy.sceneryshare.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper mapper;
    /**
     * 添加收藏
     * @param collect
     * @return
     */
    @Override
    public boolean insert(Collect collect) {
        return mapper.insert(collect) > 0;
    }

    /**
     * 取消收藏
     * @param id
     * @return
     */

    @Override
    public boolean delete(Integer id) {
        return mapper.delete(id) > 0;
    }

    /**
     * 获取用户所有的收藏列表
     * @return
     */

    @Override
    public List<Collect> getAllCollect(Integer userId) {
        return mapper.getAllCollect(userId);
    }
}
