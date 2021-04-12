package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.Info;

import java.util.List;

public interface InfoService {

    /**
     * 获取最近七天新增数据
     * @return
     */
    public List<Info> getLatestWeekNew();


    /**
     * 获取最近七天总数数据
     * @return
     */
    public List<Info> getLatestWeekSum();
}
