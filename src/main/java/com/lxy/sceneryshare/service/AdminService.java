package com.lxy.sceneryshare.service;

import com.lxy.sceneryshare.domain.Admin;

/**
 * 管理员service接口
 */


public interface AdminService {
    /**
     * 验证用户名密码是否正确
     * @param username
     * @param password
     * @return
     */

    public boolean verifyPassword(String username, String password);

    /**
     * 通过名字获取管理员信息
     * @param name
     * @return
     */
    public Admin getByName(String name);
}
