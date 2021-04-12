package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.InfoMapper;
import com.lxy.sceneryshare.domain.Info;
import com.lxy.sceneryshare.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper mapper;

    @Override
    public List<Info> getLatestWeekNew() {
        return mapper.getLatestWeekNew();
    }

    @Override
    public List<Info> getLatestWeekSum() {
        return null;
    }
}
