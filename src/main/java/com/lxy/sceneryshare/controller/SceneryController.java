package com.lxy.sceneryshare.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.Scenery;
import com.lxy.sceneryshare.service.SceneryService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 景点控制类
 */
@RestController
@RequestMapping("/scenery")
public class SceneryController {
    @Autowired
    private SceneryService sceneryService;

    /**
     * 添加景点
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addScenery(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String type = request.getParameter("type").trim();
        String coordinate = request.getParameter("coordinate").trim();
        String province = request.getParameter("province").trim();
        String city = request.getParameter("city").trim();
        String district = request.getParameter("district").trim();
        String parentId = null;

        if (request.getParameter("parentId") != null) {
            parentId = request.getParameter("parentId").trim();
        }

        Scenery scenery = new Scenery();
        scenery.setName(name);
        scenery.setType(Integer.parseInt(type));
        scenery.setCoordinate(coordinate);
        scenery.setProvince(province);
        scenery.setCity(city);
        scenery.setDistrict(district);
        if (request.getParameter("parentId") != null) {
            scenery.setParentId(Integer.parseInt(parentId));
        }

        boolean isSuccess = sceneryService.insert(scenery);

        if (isSuccess) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "景点添加成功");
        } else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "景点添加失败");
        }

        return jsonObject;
    }

    /**
     * 更新景点
     * @param request
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateScenery(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String type = request.getParameter("type").trim();
        String coordinate = request.getParameter("coordinate").trim();
        String province = request.getParameter("province").trim();
        String city = request.getParameter("city").trim();
        String district = request.getParameter("district").trim();
        String parentId = request.getParameter("parentId").trim();
        String flag = request.getParameter("flag").trim();

        Scenery scenery = new Scenery();
        scenery.setName(name);
        scenery.setId(Integer.parseInt(id));
        scenery.setType(Integer.parseInt(type));
        scenery.setCoordinate(coordinate);
        scenery.setProvince(province);
        scenery.setCity(city);
        scenery.setDistrict(district);
        scenery.setParentId(Integer.parseInt(parentId));
        scenery.setFlag(new Byte(flag));

        boolean isSuccess = sceneryService.update(scenery);

        if (isSuccess) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "景点修改成功");
        } else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "景点修改失败");
        }

        return jsonObject;
    }

    /**
     * 删除景点
     * @param request
     * @return
     */

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteScenery(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = sceneryService.delete(Integer.parseInt(id));
        return flag;
    }

    /**
     * 按主键查询景点信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/getByPrimaryKey", method = RequestMethod.GET)
    public Object getByPrimaryKey(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        Scenery scenery = sceneryService.getByPrimaryKey(Integer.parseInt(id));
        return scenery;
    }

    /**
     * 查询所有景点信息
     * @param request
     * @return
     */

    @RequestMapping(value = "/getAllScenery", method = RequestMethod.GET)
    public Object getAllScenery(HttpServletRequest request) {
        List<Scenery> allScenery = sceneryService.getAllScenery();
        return allScenery;
    }

    /**
     * 获取一级景点信息
     * @param request
     * @return
     */

    @RequestMapping(value = "/getFirstScenery", method = RequestMethod.GET)
    public Object getFirstScenery(HttpServletRequest request) {
        List<Scenery> firstScenery = sceneryService.getFirstScenery();
        return firstScenery;
    }


    /**
     * 获取二级景点信息
     * @param request
     * @return
     */

    @RequestMapping(value = "/getSecondScenery", method = RequestMethod.GET)
    public Object getSecondScenery(HttpServletRequest request) {
        List<Scenery> secondScenery = sceneryService.getSecondScenery();
        return secondScenery;
    }

    /**
     * 切换景点是否可用
     * @param request
     * @return
     */

    @RequestMapping(value = "/toggleFlag", method = RequestMethod.GET)
    public Object toggleFlag(HttpServletRequest request) {
        String flag = request.getParameter("flag").trim();
        String id = request.getParameter("id").trim();
        boolean issuccess = sceneryService.toggleFlag(Integer.parseInt(flag), Integer.parseInt(id));
        return issuccess;
    }


    /**
     * 切换景点类型
     * @param request
     * @return
     */

    @RequestMapping(value = "/updateType", method = RequestMethod.GET)
    public Object updateType(HttpServletRequest request) {
        String type = request.getParameter("type").trim();
        String id = request.getParameter("id").trim();
        boolean issuccess = sceneryService.updateType(Integer.parseInt(type), Integer.parseInt(id));
        return issuccess;
    }


    /**
     * 改变景点的父景点ID
     * @param request
     * @return
     */

    @RequestMapping(value = "/updateParentId", method = RequestMethod.GET)
    public Object updateParentId(HttpServletRequest request) {
        boolean issuccess = false;
        String id = request.getParameter("id").trim();
        if (request.getParameter("parentId").equals("null") ) {
            issuccess = sceneryService.updateParentId(null, Integer.parseInt(id));
        } else {
            String parentId = request.getParameter("parentId").trim();
            issuccess = sceneryService.updateParentId(Integer.parseInt(parentId), Integer.parseInt(id));
        }
        return issuccess;
    }



}
