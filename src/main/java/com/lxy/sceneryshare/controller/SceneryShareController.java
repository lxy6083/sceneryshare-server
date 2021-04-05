package com.lxy.sceneryshare.controller;


import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.SceneryShare;
import com.lxy.sceneryshare.domain.User;
import com.lxy.sceneryshare.service.SceneryShareService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 风景分享信息controller层
 */
@RestController
@RequestMapping("/sceneryshare")
public class SceneryShareController {

    @Autowired
    private SceneryShareService sceneryShareService;

    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSceneryShare(HttpServletRequest request, @RequestParam("file") MultipartFile picFile) {

        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId").trim();          //用户id
        String title = request.getParameter("title").trim();            //标题
        String content = request.getParameter("content").trim();        //内容
        String sceneryId = request.getParameter("sceneryId").trim();    //景点ID
        String weather = request.getParameter("weather").trim();        //天气
        String timeBucket = request.getParameter("timeBucket").trim();  //时段
        String season = request.getParameter("season").trim();          //季节
        String bearing = request.getParameter("bearing").trim();        //朝向

        if (picFile.isEmpty()) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"图片上传失败");
            return jsonObject;
        }

        //文件名 = 当前时间（到毫秒）+原来的文件名
        String fileName = System.currentTimeMillis() + picFile.getOriginalFilename();

        //文件路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "scenery";

        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        //实际的文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);

        //存储到数据库里的相对文件地址
        String storePicPath = "/scenery/" + fileName;
        try {
            picFile.transferTo(dest);
            SceneryShare sceneryShare = new SceneryShare();
            sceneryShare.setUserId(Integer.parseInt(userId));
            sceneryShare.setTitle(title);
            sceneryShare.setContent(content);
            sceneryShare.setSceneryId(Integer.parseInt(sceneryId));
            sceneryShare.setPic(storePicPath);
            sceneryShare.setWeather(Integer.parseInt(weather));
            sceneryShare.setTimeBucket(Integer.parseInt(timeBucket));
            sceneryShare.setSeason(Integer.parseInt(season));
            sceneryShare.setBearing(Integer.parseInt(bearing));
            boolean flag = sceneryShareService.insert(sceneryShare);

            if (flag) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"保存成功");
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"保存失败");
            return jsonObject;
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"保存失败" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }

    /**
     * 通过userId查找分享的动态
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/scenery", method = RequestMethod.GET)

    public Object getSceneryOfUser(HttpServletRequest request) {
        String userId = request.getParameter("userId").trim();
        return sceneryShareService.getSceneryByUserId(Integer.parseInt(userId));
    }

    /**
     * 删除动态
     * @param request
     * @return
     */

    @RequestMapping(value = "/delete", method = RequestMethod.GET)

    public Object deleteSceneryShare(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        return sceneryShareService.delete(Integer.parseInt(id));
    }

    /**
     * 设置/取消精华
     * @param request
     * @return
     */

    @RequestMapping(value = "/toggleEssence", method = RequestMethod.GET)

    public Object toggleEssence(HttpServletRequest request) {
        String essence = request.getParameter("essence").trim();
        String id = request.getParameter("id").trim();
        boolean isSuccess = sceneryShareService.toggleEssence(new Byte(essence), Integer.parseInt(id));
        return isSuccess;
    }

    /**
     * 获取所有的动态
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAllSceneryShare", method = RequestMethod.GET)

    public Object getAllSceneryShare(HttpServletRequest request) {
        List<SceneryShare> allSceneryShare = sceneryShareService.getAllSceneryShare();
        return allSceneryShare;
    }


    /**
     * 通过用户id获取用户总动态数
     * @param request
     * @return
     */

    @RequestMapping(value = "/getCountByUserId", method = RequestMethod.GET)

    public Object getCountByUserId(HttpServletRequest request) {
        String userId = request.getParameter("userId").trim();
        int countByUserId = sceneryShareService.getCountByUserId(Integer.parseInt(userId));
        return countByUserId;
    }

    /**
     * 是否可见
     * @param request
     * @return
     */

    @RequestMapping(value = "/toggleVisible", method = RequestMethod.GET)

    public Object toggleVisible(HttpServletRequest request) {
        String visible = request.getParameter("visible").trim();
        String id = request.getParameter("id").trim();
        boolean isSuccess = sceneryShareService.toggleEssence(new Byte(visible), Integer.parseInt(id));
        return isSuccess;
    }

    /**
     * 更新动态信息
     * @param request
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateScenery(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String sceneryId = request.getParameter("sceneryId").trim();
        String weather = request.getParameter("weather").trim();
        String timeBucket = request.getParameter("timeBucket").trim();
        String season = request.getParameter("season").trim();
        String bearing = request.getParameter("bearing").trim();

        SceneryShare sceneryShare = new SceneryShare();
        sceneryShare.setId(Integer.parseInt(id));
        sceneryShare.setSceneryId(Integer.parseInt(sceneryId));
        sceneryShare.setWeather(Integer.parseInt(weather));
        sceneryShare.setTimeBucket(Integer.parseInt(timeBucket));
        sceneryShare.setSeason(Integer.parseInt(season));
        sceneryShare.setBearing(Integer.parseInt(bearing));

        boolean isSuccess = sceneryShareService.update(sceneryShare);

        if (isSuccess) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "动态信息修改成功");
        } else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "动态信息修改失败");
        }

        return jsonObject;
    }

    /**
     * 通过主键获取动态
     * @param request
     * @return
     */

    @RequestMapping(value = "/getByPrimaryKey", method = RequestMethod.GET)

    public Object getByPrimaryKey(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        SceneryShare sceneryShare = sceneryShareService.getByPrimaryKey(Integer.parseInt(id));
        return sceneryShare;
    }

}
