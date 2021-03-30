package com.lxy.sceneryshare.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.Admin;
import com.lxy.sceneryshare.service.AdminService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 判断登录是否成功
     */
    @RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean flag = adminService.verifyPassword(name,password);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG,"登陆成功");
            Admin admin = adminService.getByName(name);
            jsonObject.put("adminMsg",admin);
            session.setAttribute(Consts.NAME,name);
            return jsonObject;
        }

        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG,"用户名或密码错误");
        return jsonObject;
    }



}
