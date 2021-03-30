package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.Feedback;

import java.util.List;

public interface FeedbackService {
    /**
     * 添加
     * @param feedback
     * @return
     */
    boolean insert(Feedback feedback);

    /**
     * 更新
     * @param feedback
     * @return
     */
    boolean update(Feedback feedback);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 通过主键查找
     * @param id
     * @return
     */
    Feedback getByPrimaryKey(Integer id);

    /**
     * 获取所有意见反馈记录
     * @return
     */
    List<Feedback> getAllFeedback();

    /**
     * 通过用户ID获取意见反馈记录
     * @param userId
     * @return
     */
    List<Feedback> getFeedbackByUserId(Integer userId);

    /**
     * 通过管理员ID获取意见反馈记录
     * @param adminId
     * @return
     */
    List<Feedback> getFeedbackByAdminId(Integer adminId);
}
