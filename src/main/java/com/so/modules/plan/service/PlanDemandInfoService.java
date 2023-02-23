package com.so.modules.plan.service;

import com.so.modules.plan.bean.PlanDemandInfoBean;
import org.apache.commons.utils.Page;

import java.util.List;

/**
 * 方案需求
 * @author admin
 * @version 2022-07-02 16:15:31
 */
public interface PlanDemandInfoService {
	/**
	 * 添加方案需求
	 * @param planDemandInfoBean 方案需求
	 * @return 操作行
	 */
	int add(PlanDemandInfoBean planDemandInfoBean);

	/**
	 * 根据ID删除方案需求
	 * @param id 待删除的方案需求ID
	 * @return 操作行
	 */
	int delete(String id);

	/**
	 * 根据文章
	 * @param planDemandInfoBean 方案需求
	 * @return 操作行
	 */
	int update(PlanDemandInfoBean planDemandInfoBean);

	/**
	 * 分页查询
	 * @param planDemandInfoBean 查询条件
	 * @param page 分页对象
	 * @return 分页结果
	 */
	Page<PlanDemandInfoBean> page(PlanDemandInfoBean planDemandInfoBean, Page<PlanDemandInfoBean> page);

	/**
	 * 根据ID查询方案需求
	 * @param id id
	 * @return 操作行
	 */
	PlanDemandInfoBean getById(String id);

	/**
	 * 获取所有方案需求
	 * @param planDemandInfoBean 查询条件
	 * @return 满足条件的所有方案需求
	 */
	List<PlanDemandInfoBean> findAll(PlanDemandInfoBean planDemandInfoBean);
}






































