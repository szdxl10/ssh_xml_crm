package com.wangzhanxiong.crm.service;

import com.wangzhanxiong.crm.domain.User;

import java.util.List;

/**
 * 用户管理的Service的接口
 * @author Wangzhanxiong
 *
 */
public interface UserService {

    void regist(User user);

    User login(User user);

    List<User> findAll();
}