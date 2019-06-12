package com.wangzhanxiong.crm.service;

import java.util.List;

import com.wangzhanxiong.crm.domain.BaseDict;

/**
 * 字典的业务层的接口
 * @author Wangzhanxiong
 *
 */
public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
