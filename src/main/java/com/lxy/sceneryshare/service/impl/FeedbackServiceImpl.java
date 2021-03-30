package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.FeedbackMapper;
import com.lxy.sceneryshare.domain.Feedback;
import com.lxy.sceneryshare.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public boolean insert(Feedback feedback) {
        return feedbackMapper.insert(feedback) > 0;
    }

    @Override
    public boolean update(Feedback feedback) {
        return feedbackMapper.update(feedback) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return feedbackMapper.delete(id) > 0;
    }

    @Override
    public Feedback getByPrimaryKey(Integer id) {
        return feedbackMapper.getByPrimaryKey(id);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackMapper.getAllFeedback();
    }

    @Override
    public List<Feedback> getFeedbackByUserId(Integer userId) {
        return feedbackMapper.getFeedbackByUserId(userId);
    }

    @Override
    public List<Feedback> getFeedbackByAdminId(Integer adminId) {
        return feedbackMapper.getFeedbackByAdminId(adminId);
    }

}
