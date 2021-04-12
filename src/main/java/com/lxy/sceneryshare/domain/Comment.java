package com.lxy.sceneryshare.domain;

import java.util.Date;

/**
 * 评论
 */
public class Comment {
    private Integer id;             //主键
    private Integer userId;         //用户id
    private Integer sceneryshareId; //动态id
    private String content;         //评论内容
    private Date createTime;        //评论时间

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
