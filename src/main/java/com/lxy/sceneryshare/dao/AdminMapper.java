package com.lxy.sceneryshare.dao;

import com.lxy.sceneryshare.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 管理员Dao
 */

@Repository
public interface AdminMapper {

    /**
     * 验证用户名密码是否正确
     * @param username
     * @param password
     * @return
     */

    public int verifyPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 通过名字获取管理员信息
     * @param name
     * @return
     */
    public Admin getByName(String name);

}
