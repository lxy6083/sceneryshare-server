package com.lxy.sceneryshare.service.impl;

import com.lxy.sceneryshare.dao.AdminMapper;
import com.lxy.sceneryshare.domain.Admin;
import com.lxy.sceneryshare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员service实现类
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    /**
     * 验证用户名密码是否正确
     * @param username
     * @param password
     * @return
     */

    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username, password) > 0;
    }

    /**
     * 通过名字获取管理员信息
     * @param name
     * @return
     */

    @Override
    public Admin getByName(String name) {
        return adminMapper.getByName(name);
    }


}
