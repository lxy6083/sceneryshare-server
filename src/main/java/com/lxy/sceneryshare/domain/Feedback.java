package com.lxy.sceneryshare.domain;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 意见反馈
 */
public class Feedback {
    private Integer id;         //主键
    private Integer userId;     //用户ID
    private Integer adminId;    //管理员ID
    private String opinion;     //用户的意见
    private String feedback;    //管理员的反馈
    private Date createTime;    //创建时间，即用户意见的提交时间
    private Date updateTime;    //更新时间，即管理员反馈的提交时间

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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", userId=" + userId +
                ", adminId=" + adminId +
                ", opinion='" + opinion + '\'' +
                ", feedback='" + feedback + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
