package com.wangzhanxiong.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.wangzhanxiong.crm.dao.SaleVisitDao;
import com.wangzhanxiong.crm.domain.PageBean;
import com.wangzhanxiong.crm.domain.SaleVisit;
import com.wangzhanxiong.crm.service.SaleVisitService;

/**
 * 客户拜访记录的业务层的实现类
 * 
 * @author Wangzhanxiong
 *
 */
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {



	// 注入客户拜访记录的DAO:
//	@Resource(name = "saleVisitDao")
	private SaleVisitDao saleVisitDao;
//	public SaleVisitDao getSaleVisitDao() {
//		return saleVisitDao;
//	}
//
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
	@Override
	// 业务层分页显示拜访记录的方法:
	public PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();
		// 设置当前页数:
		pageBean.setCurrPage(currPage);
		// 设置每页显示记录数:
		pageBean.setPageSize(pageSize);
		// 设置总记录数:
		Integer totalCount = saleVisitDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		// 设置总页数：
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 设置每页显示的数据的集合:
		Integer begin = (currPage - 1) * pageSize;
		List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDao.save(saleVisit);
	}
}
