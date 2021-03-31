package com.lxy.sceneryshare.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.Comment;
import com.lxy.sceneryshare.service.CommentService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 发表评论
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object addComment(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId").trim();
        String sceneryshareId = request.getParameter("sceneryshareId").trim();
        String content = request.getParameter("contnet").trim();

        Comment comment = new Comment();
        comment.setUserId(Integer.parseInt(userId));
        comment.setSceneryshareId(Integer.parseInt(sceneryshareId));
        comment.setContent(content);

        Boolean isSuccess = commentService.insert(comment);
        if (isSuccess) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"评论成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"评论失败");
            return jsonObject;
        }
    }

    /**
     * 删除评论
     * @param request
     * @return
     */

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteComment(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        Boolean isSuccess = commentService.delete(Integer.parseInt(id));
        return isSuccess;
    }

    /**
     * 通过用户id获取评论列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getByUserId",method = RequestMethod.GET)
    public Object getByUserId(HttpServletRequest request) {
        String userId = request.getParameter("userId").trim();
        List<Comment> comments = commentService.getByUserId(Integer.parseInt(userId));
        return comments;
    }

    /**
     * 通过动态id获取评论列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/getBySceneryshareId",method = RequestMethod.GET)
    public Object getBySceneryshareId(HttpServletRequest request) {
        String sceneryshareId = request.getParameter("sceneryshareId").trim();
        List<Comment> comments = commentService.getByUserId(Integer.parseInt(sceneryshareId));
        return comments;
    }

}
