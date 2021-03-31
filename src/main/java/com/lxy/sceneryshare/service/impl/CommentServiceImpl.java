package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.CommentMapper;
import com.lxy.sceneryshare.domain.Comment;
import com.lxy.sceneryshare.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return commentMapper.delete(id) > 0;
    }

    /**
     * 通过用户id获取评论列表
     * @param userId
     * @return
     */
    @Override
    public List<Comment> getByUserId(Integer userId) {
        return commentMapper.getByUserId(userId);
    }

    /**
     * 通过动态id获取评论列表
     * @param sceneryshareId
     * @return
     */

    @Override
    public List<Comment> getBySceneryshareId(Integer sceneryshareId) {
        return commentMapper.getBySceneryshareId(sceneryshareId);
    }
}
