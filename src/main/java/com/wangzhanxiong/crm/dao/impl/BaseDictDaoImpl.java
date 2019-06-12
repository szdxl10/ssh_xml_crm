package com.wangzhanxiong.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wangzhanxiong.crm.dao.BaseDictDao;
import com.wangzhanxiong.crm.domain.BaseDict;

/**
 * 字典DAO的实现类
 * 
 * @author Wangzhanxiong
 *
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	// 根据类型编码查询字典数据
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?",
				dict_type_code);
	}

}
