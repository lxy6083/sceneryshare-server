package com.lxy.sceneryshare.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.Collect;
import com.lxy.sceneryshare.service.CollectService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService service;

    /**
     * 发表评论
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object addCollect(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId").trim();
        String sceneryshareId = request.getParameter("sceneryshareId").trim();

        Collect collect = new Collect();
        collect.setUserId(Integer.parseInt(userId));
        collect.setSceneryshareId(Integer.parseInt(sceneryshareId));

        Boolean isSuccess = service.insert(collect);
        if (isSuccess) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"收藏成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"收藏失败");
            return jsonObject;
        }
    }

    /**
     * 取消收藏
     * @param request
     * @return
     */

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteCollect(HttpServletRequest request) {
        String userId = request.getParameter("userId").trim();
        String sceneryshareId = request.getParameter("sceneryshareId").trim();
        Boolean isSuccess = service.delete(Integer.parseInt(userId),Integer.parseInt(sceneryshareId));
        return isSuccess;
    }

    /**
     * 获取收藏列表
     * @param request
     * @return
     */

    @RequestMapping(value = "/getAllCollect", method = RequestMethod.GET)
    public Object getAllCollect(HttpServletRequest request) {
        String userId = request.getParameter("userId").trim();
        List<Collect> collectList = service.getAllCollect(Integer.parseInt(userId));
        return collectList;
    }
}
