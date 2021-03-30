package com.lxy.sceneryshare.dao;
import com.lxy.sceneryshare.domain.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 意见反馈Dao
 */
@Repository
public interface FeedbackMapper {
    /**
     * 添加
     * @param feedback
     * @return
     */
    int insert(Feedback feedback);

    /**
     * 更新
     * @param feedback
     * @return
     */
    int update(Feedback feedback);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Integer id);

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
