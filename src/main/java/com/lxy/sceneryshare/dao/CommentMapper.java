package com.lxy.sceneryshare.dao;

import com.lxy.sceneryshare.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论Dao
 */

@Repository
public interface CommentMapper {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    public int insert(Comment comment);

    /**
     * 删除评论
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 通过用户id获取评论列表
     * @param userId
     * @return
     */
    public List<Comment> getByUserId(Integer userId);

    /**
     * 通过动态id获取评论列表
     * @param sceneryshareId
     * @return
     */
    public List<Comment> getBySceneryshareId(Integer sceneryshareId);

}
