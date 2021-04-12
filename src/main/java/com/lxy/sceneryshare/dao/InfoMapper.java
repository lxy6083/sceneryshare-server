package com.lxy.sceneryshare.dao;

import com.lxy.sceneryshare.domain.Info;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 信息统计mapper
 */
@Repository
public interface InfoMapper {

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
