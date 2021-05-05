package com.lxy.sceneryshare.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.Feedback;
import com.lxy.sceneryshare.service.FeedbackService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

/**
 * 意见/反馈控制类
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    /**
     * 发送建议
     * @param request
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Object sendFeedback(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String opinion = request.getParameter("opinion").trim();  //用户的建议
        String userId = request.getParameter("userId").trim();    //用户ID

        Feedback feedback = new Feedback();
        feedback.setOpinion(opinion);
        feedback.setUserId(Integer.parseInt(userId));

        boolean flag = feedbackService.insert(feedback);

        if (flag) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"意见发送成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"意见发送失败");
            return jsonObject;
        }
    }

    /**
     * 回复反馈
     * @param request
     * @return
     */

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public Object replyFeedback(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();              //意见反馈ID
        String reply = request.getParameter("reply").trim();  //管理员的回复
        String adminId = request.getParameter("adminId").trim();    //管理员ID

        Feedback feedback = feedbackService.getByPrimaryKey(Integer.valueOf(id));
        feedback.setFeedback(reply);
        feedback.setAdminId(Integer.parseInt(adminId));

        boolean flag = feedbackService.update(feedback);

        if (flag) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"反馈回复成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"反馈回复失败");
            return jsonObject;
        }
    }

    /**
     * 删除已发送意见
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteFeedback(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = feedbackService.delete(Integer.parseInt(id));
        return flag;
    }


    /**
     * 通过用户id获取意见反馈列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getFeedbackByUserId",method = RequestMethod.GET)
    public Object getFeedbackByUserId(HttpServletRequest request) {
        String userId = request.getParameter("userId").trim();
        List<Feedback> feedbackList = feedbackService.getFeedbackByUserId(Integer.parseInt(userId));
        return feedbackList;
    }

    /**
     * 获取意见反馈列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAllFeedback",method = RequestMethod.GET)
    public Object getAllFeedback(HttpServletRequest request) {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        return feedbackList;
    }



}
