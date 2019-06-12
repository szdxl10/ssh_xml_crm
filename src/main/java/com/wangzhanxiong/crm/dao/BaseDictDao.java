package com.wangzhanxiong.crm.dao;

import java.util.List;

import com.wangzhanxiong.crm.domain.BaseDict;

/**
 * 字典DAO的接口
 * @author Wangzhanxiong
 *
 */
public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

}
