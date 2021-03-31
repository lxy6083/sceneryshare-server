package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.Comment;

import java.util.List;

/**
 * 评论service层
 */
public interface CommentService {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    public boolean insert(Comment comment);

    /**
     * 删除评论
     * @param id
     * @return
     */
    public boolean delete(Integer id);

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
