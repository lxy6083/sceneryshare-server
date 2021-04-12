package com.lxy.sceneryshare.domain;

/**
 * 多表统计信息
 */
public class Info {
    private String date;    //日期
    private Integer user;   //用户统计数
    private Integer scenery;    //景点统计数
    private Integer share;      //动态统计数

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getScenery() {
        return scenery;
    }

    public void setScenery(Integer scenery) {
        this.scenery = scenery;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }
}
