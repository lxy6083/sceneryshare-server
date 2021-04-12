package com.lxy.sceneryshare.domain;

import java.util.Date;

/**
 * 动态
 */
public class SceneryShare {
    private Integer id; //主键
    private Integer userId;    //用户id
    private String title;       //标题
    private String content; //内容
    private String pic; //照片
    private Integer sceneryId; //景区Id
    private Integer bearing; //方位
    private Integer weather; //天气
    private Integer timeBucket;  //时段
    private Integer season;  //季节
    private Byte essence;       //精华
    private Byte visible;       //是否可见
    private Date createTime;    // 创建时间
    private Date updateTime;    //更新时间



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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(Integer sceneryId) {
        this.sceneryId = sceneryId;
    }

    public Integer getBearing() {
        return bearing;
    }

    public void setBearing(Integer bearing) {
        this.bearing = bearing;
    }

    public Integer getWeather() {
        return weather;
    }

    public void setWeather(Integer weather) {
        this.weather = weather;
    }

    public Integer getTimeBucket() {
        return timeBucket;
    }

    public void setTimeBucket(Integer timeBucket) {
        this.timeBucket = timeBucket;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Byte getEssence() {
        return essence;
    }

    public void setEssence(Byte essence) {
        this.essence = essence;
    }

    public Byte getVisible() {
        return visible;
    }

    public void setVisible(Byte visible) {
        this.visible = visible;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
