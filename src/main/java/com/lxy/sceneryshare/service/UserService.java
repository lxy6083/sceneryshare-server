package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前端用户service层
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean insert(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */

    public boolean update(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */

    public boolean delete(Integer id);

    /**
     * 按主键查找
     * @param id
     * @return
     */

    public User getByPrimaryKey(Integer id);

    /**
     * 获取所有用户列表
     * @return
     */

    public List<User> getAllUser();

    /**
     * 验证用户名密码是否正确
     * @param username
     * @param password
     * @return
     */

    public boolean verifyPassword(String username, String password);

    /**
     * 验证用户名邮箱是否正确
     * @param username
     * @param email
     * @return
     */

    public boolean verifyEmail(String username, String email, String password);

    /**
     * 更新最近的登录时间
     * @param id
     * @return
     */
    public boolean updateLoginTime(Integer id);

    /**
     * 通过用户名查找
     * @param username
     * @return
     */

    public User getByUsername(String username);

    /**
     * 切换是否锁定
     * @param flag
     * @param id
     * @return
     */
    public boolean toggleFlag(Integer flag, Integer id);

    /**
     * 用户是否被锁定
     * @param id
     * @return
     */
    public boolean isLocked(Integer id);

}
