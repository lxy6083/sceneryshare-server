package com.lxy.sceneryshare.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxy.sceneryshare.domain.User;
import com.lxy.sceneryshare.service.UserService;
import com.lxy.sceneryshare.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 前端用户控制类
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();  //用户名
        String password = request.getParameter("password").trim();  //密码
        String sex = request.getParameter("sex").trim();    //性别
        String mobile = request.getParameter("mobile").trim();  //手机号
        String email = request.getParameter("email").trim();    //邮箱
        String birthday = request.getParameter("birthday").trim();  //生日
        String province = request.getParameter("province").trim();  //省
        String city = request.getParameter("city").trim();  //市
        String district = request.getParameter("district").trim();  //区
        String avatar = request.getParameter("avatar").trim();  //头像

        //判断用户名是否为空
        if (username == null || "".equals(username)) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不能为空");
            return jsonObject;
        }

        //判断用户名是否存在
        if (userService.getByUsername(username) != null) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名已经存在");
            return jsonObject;
        }

        //判断密码是否为空

        if (password == null || "".equals(password)) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"密码不能为空");
            return jsonObject;
        }



        //把生日转换成date格式

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        if (birthday != null) {
            try {
                birthDate = dateFormat.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //保存到前端用户的对象中
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(new Byte(sex));
        user.setMobile(mobile);
        user.setEmail(email);
        user.setBirthday(birthDate);
        user.setProvince(province);
        user.setCity(city);
        user.setDistrict(district);
        user.setAvatar(avatar);

        boolean flag = userService.insert(user);

        if (flag) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"用户注册成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户注册失败");
            return jsonObject;
        }
    }

    /**
     * 判断登录是否成功
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getByUsername(username);
        boolean flag = userService.verifyPassword(username,password);
        boolean isLocked = userService.isLocked(user.getId());
        if (flag && !isLocked) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG,"登陆成功");
            jsonObject.put("userMsg", user);
            userService.updateLoginTime(user.getId());
            return jsonObject;
        } else if (isLocked == true) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG,"用户已被锁定，请联系管理员解锁");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG,"用户名或密码错误");
        return jsonObject;
    }

    /**
     * 找回密码
     */

    @RequestMapping(value = "/recoverPwd",method = RequestMethod.POST)
    public Object recoverPwd(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean flag = userService.verifyEmail(username, email, password);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "密码修改成功");
            return jsonObject;
        }

        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG,"用户名或邮箱输入错误");
        return jsonObject;
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateUser(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String username = request.getParameter("username").trim();  //用户名
        String sex = request.getParameter("sex").trim();    //性别
        String mobile = request.getParameter("mobile").trim();  //手机号
        String email = request.getParameter("email").trim();    //邮箱
        String birthday = request.getParameter("birthday").trim();  //生日
        String province = request.getParameter("province").trim();  //省
        String city = request.getParameter("city").trim();  //市
        String district = request.getParameter("district").trim();  //区

        //判断用户名是否为空
        if (username == null || "".equals(username)) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不能为空");
            return jsonObject;
        }


        //判断用户名是否存在 且 不是所要修改的用户的ID下的用户名
        if ((userService.getByUsername(username) != null) && (userService.getByUsername(username).getId() != Integer.parseInt(id))) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名已经存在");
            return jsonObject;
        }
        //把生日转换成date格式

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();

        try {
            birthDate = dateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //保存到前端用户的对象中
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setSex(new Byte(sex));
        user.setMobile(mobile);
        user.setEmail(email);
        user.setBirthday(birthDate);
        user.setProvince(province);
        user.setCity(city);
        user.setDistrict(district);

        boolean flag = userService.update(user);

        if (flag) {
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"用户修改成功");
            return jsonObject;
        } else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户修改失败");
            return jsonObject;
        }
    }

    /**
     * 删除前端用户
     * @param request
     * @return
     */

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteUser(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = userService.delete(Integer.parseInt(id));
        return flag;
    }

    /**
     * 按主键查询用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/getByPrimaryKey", method = RequestMethod.GET)
    public Object getByPrimaryKey(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        User user = userService.getByPrimaryKey(Integer.parseInt(id));
        return user;
    }

    /**
     * 查询所有用户信息
     * @param request
     * @return
     */

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public Object getAllUser(HttpServletRequest request) {
        List<User> allUser = userService.getAllUser();
        return allUser;
    }

    /**
     * 更新前端用户的头像
     * @param avatarFile
     * @param id
     * @return
     */

    @RequestMapping(value = "/updateUserAvatar",method = RequestMethod.POST)
    public Object updateUserAvatar(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        if (avatarFile.isEmpty()) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
            return jsonObject;
        }

        //文件名 = 当前时间（到毫秒）+原来的文件名
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();

        //文件路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "avatarImages";

        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        //实际的文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);

        //存储到数据库里的相对文件地址
        String storeAvatarPath = "/avatarImages/" + fileName;
        try {
            avatarFile.transferTo(dest);
            User user = new User();
            user.setId(id);
            user.setAvatar(storeAvatarPath);
            boolean flag = userService.update(user);
            if (flag) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"头像上传成功");
                jsonObject.put("avatar",storeAvatarPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"头像上传失败");
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"头像上传失败" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }

    /**
     * 切换用户是否锁定
     * @param request
     * @return
     */

    @RequestMapping(value = "/toggleFlag", method = RequestMethod.GET)
    public Object toggleFlag(HttpServletRequest request) {
        String flag = request.getParameter("flag").trim();
        String id = request.getParameter("id").trim();
        boolean issuccess = userService.toggleFlag(Integer.parseInt(flag), Integer.parseInt(id));
        return issuccess;
    }

}
