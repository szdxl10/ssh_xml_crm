package com.wangzhanxiong.crm.dao.impl;

import com.wangzhanxiong.crm.dao.UserDao;
import com.wangzhanxiong.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 用户管理的DAO的实现类
 * @author Wangzhanxiong
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    // DAO中根据用户名和密码进行查询的方法:
    public User login(User user) {
        List<User> list = (List<User>) this.getHibernateTemplate().find(
                "from User where user_code=? and user_password = ?", user.getUser_code(), user.getUser_password());
        // 判断一下:
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
