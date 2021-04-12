package com.lxy.sceneryshare.domain;

import java.util.Date;

/**
 * 收藏
 */
public class Collect {
    private Integer id;             //主键
    private Integer userId;         //用户id
    private Integer sceneryshareId; //动态id
    private Date createTime;        //收藏时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSceneryshareId() {
        return sceneryshareId;
    }

    public void setSceneryshareId(Integer sceneryshareId) {
        this.sceneryshareId = sceneryshareId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
