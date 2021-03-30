package com.lxy.sceneryshare.service.impl;


import com.lxy.sceneryshare.dao.UserMapper;
import com.lxy.sceneryshare.domain.User;
import com.lxy.sceneryshare.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前端用户service实现类
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     * @param user
     * @return
     */

    @Override
    public boolean insert(User user) {
        return userMapper.insert(user) > 0;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */

    @Override
    public boolean update(User user) {
        return userMapper.update(user) > 0;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */

    @Override
    public boolean delete(Integer id) {
        return userMapper.delete(id) > 0;
    }

    /**
     * 按主键查找
     * @param id
     * @return
     */

    @Override
    public User getByPrimaryKey(Integer id) {
        return userMapper.getByPrimaryKey(id);
    }

    /**
     * 获取所有用户列表
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }


    /**
     * 验证用户名密码是否正确
     * @param username
     * @param password
     * @return
     */

    @Override
    public boolean verifyPassword(String username, String password) {
        return userMapper.verifyPassword(username,password) > 0;
    }

    /**
     * 验证用户名邮箱是否正确
     * @param username
     * @param email
     * @return
     */

    public boolean verifyEmail(String username, String email, String password) {
        return userMapper.verifyEmail(username, email, password) > 0;
    }

    /**
     * 更新最近的登录时间
     * @param id
     * @return
     */
    public boolean updateLoginTime(Integer id) {
        return userMapper.updateLoginTime(id) > 0;
    }

    /**
     * 通过用户名查找
     * @param username
     * @return
     */

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    /**
     * 切换是否锁定
     * @param flag
     * @param id
     * @return
     */
    @Override
    public boolean toggleFlag(Integer flag, Integer id) {
        return userMapper.toggleFlag(flag,id) > 0;
    }

    /**
     * 用户是否被锁定
     * @param id
     * @return
     */
    @Override
    public boolean isLocked(Integer id) {
        return userMapper.isLocked(id) > 0;
    }


}
