package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.SceneryMapper;
import com.lxy.sceneryshare.domain.Scenery;
import com.lxy.sceneryshare.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 景点Service实现类
 */

@Service
public class SceneryImpl implements SceneryService {
    @Autowired
    private SceneryMapper sceneryMapper;

    @Override
    public boolean insert(Scenery scenery) {
        return sceneryMapper.insert(scenery) > 0;
    }

    @Override
    public boolean update(Scenery scenery) {
        return sceneryMapper.update(scenery) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return sceneryMapper.delete(id) > 0;
    }

    @Override
    public Scenery getByPrimaryKey(Integer id) {
        return sceneryMapper.getByPrimaryKey(id);
    }

    @Override
    public List<Scenery> getAllScenery() {
        return sceneryMapper.getAllScenery();
    }

    @Override
    public List<Scenery> getFirstScenery() {
        return sceneryMapper.getFirstScenery();
    }

    @Override
    public List<Scenery> getSecondScenery() {
        return sceneryMapper.getSecondScenery();
    }

    @Override
    public boolean toggleFlag(Integer flag, Integer id) {
        return sceneryMapper.toggleFlag(flag,id) > 0;
    }

    @Override
    public boolean updateType(Integer type, Integer id) {
        return sceneryMapper.updateType(type,id) > 0;
    }

    @Override
    public boolean updateParentId(Integer parentId, Integer id) {
        return sceneryMapper.updateParentId(parentId,id) > 0;
    }
}
