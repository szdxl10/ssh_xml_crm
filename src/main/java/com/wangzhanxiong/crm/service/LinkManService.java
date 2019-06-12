package com.wangzhanxiong.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wangzhanxiong.crm.domain.LinkMan;
import com.wangzhanxiong.crm.domain.PageBean;

/**
 * 联系人的Service的接口
 * @author Wangzhanxiong
 *
 */
public interface LinkManService {

	PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

}
