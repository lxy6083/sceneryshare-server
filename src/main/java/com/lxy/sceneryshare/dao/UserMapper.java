package com.lxy.sceneryshare.dao;

import com.lxy.sceneryshare.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao
 */

@Repository
public interface UserMapper {

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */

    public int update(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */

    public int delete(Integer id);

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

    public int verifyPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 验证用户名邮箱是否正确
     * @param username
     * @param email
     * @return
     */

    public int verifyEmail(@Param("username") String username, @Param("email") String email, @Param("password") String password);

    /**
     * 更新最近的登录时间
     * @param id
     * @return
     */
    public int updateLoginTime(Integer id);

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
    public int toggleFlag(@Param("flag") Integer flag, @Param("id") Integer id);

    /**
     * 用户是否被锁定
     * @param id
     * @return
     */
    public int isLocked(Integer id);
}
