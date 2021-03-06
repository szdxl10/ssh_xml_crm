package com.wangzhanxiong.crm.service.impl;

import com.wangzhanxiong.crm.dao.UserDao;
import com.wangzhanxiong.crm.domain.User;
import com.wangzhanxiong.crm.service.UserService;
import com.wangzhanxiong.crm.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户管理的Service的实现类
 * @author Wangzhanxiong
 *
 */
@Transactional
public class UserServiceImpl implements UserService {

    // 注入DAO:
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    // 业务层注册用户的方法
    public void regist(User user) {
        // 对密码进行加密处理：
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        // 调用DAO
        userDao.save(user);
    }

    @Override
    // 业务层用户登录的方法
    public User login(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        // 调用DAO
        return userDao.login(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
