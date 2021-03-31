package com.lxy.sceneryshare.domain;

public class Rank {
    private Integer id;             //主键
    private Integer sceneryshareId; //动态id
    private Integer userId;         //用户id
    private Integer score;          //评分

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSceneryshareId() {
        return sceneryshareId;
    }

    public void setSceneryshareId(Integer sceneryshareId) {
        this.sceneryshareId = sceneryshareId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
