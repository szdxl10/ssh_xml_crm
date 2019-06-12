package com.wangzhanxiong.crm.dao;

import com.wangzhanxiong.crm.domain.User;

/**
 * 用户管理的DAO的接口
 * @author Wangzhanxiong
 *
 */
public interface UserDao extends BaseDao<User>{

    User login(User user);
}
