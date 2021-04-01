package com.lxy.sceneryshare.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.Rank;
import com.lxy.sceneryshare.service.RankService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 评分Controller层
 */
@RestController
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankService service;

    /**
     * 添加评分
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object addRank(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String sceneryshareId = request.getParameter("sceneryshareId").trim();
        String userId = request.getParameter("userId").trim();
        String score = request.getParameter("score").trim();

        Rank rank = new Rank();
        rank.setUserId(Integer.parseInt(sceneryshareId));
        rank.setUserId(Integer.parseInt(userId));
        rank.setScore(Integer.parseInt(score));

        Rank mark = service.getMark(Integer.parseInt(sceneryshareId), Integer.parseInt(userId));
        if (mark != null) {
            boolean isSuccess = service.insert(rank);

            if (isSuccess) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"评分成功");
            } else {
                jsonObject.put(Consts.CODE,0);
                jsonObject.put(Consts.MSG,"评分失败");
            }
        } else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"已评分，请勿重复评分");
        }
        return jsonObject;
    }

    /**
     * 通过userId和sceneryId查询评分信息
     * @param request
     * @return
     */

    @RequestMapping(value = "/getMark", method = RequestMethod.GET)
    public Object getMark(HttpServletRequest request) {
        String userId = request.getParameter("userId").trim();
        String sceneryshareId = request.getParameter("sceneryshareId").trim();
        Rank rank = service.getMark(Integer.parseInt(userId),Integer.parseInt(sceneryshareId));
        return rank;
    }


    /**
     * 获取总分
     * @param request
     * @return
     */

    @RequestMapping(value = "/getScoreSum", method = RequestMethod.GET)
    public Object getScoreSum(HttpServletRequest request) {
        String sceneryshareId = request.getParameter("sceneryshareId").trim();
        float scoreSum = service.getScoreSum(Integer.parseInt(sceneryshareId));
        return scoreSum;
    }


    /**
     * 获取总人数
     * @param request
     * @return
     */

    @RequestMapping(value = "/getScoreNum", method = RequestMethod.GET)
    public Object getScoreNum(HttpServletRequest request) {
        String sceneryshareId = request.getParameter("sceneryshareId").trim();
        float scoreNum= service.getScoreNum(Integer.parseInt(sceneryshareId));
        return scoreNum;
    }


}
