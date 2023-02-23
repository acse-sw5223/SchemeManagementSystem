package com.so.modules.plan.service;

import com.so.modules.plan.bean.AuditRecordsBean;
import org.apache.commons.utils.Page;

import java.util.List;

/**
 * 审批记录
 * @author admin
 * @version 2022-07-03 09:44:37
 */
public interface AuditRecordsService {
	/**
	 * 添加审批记录
	 * @param auditRecordsBean 审批记录
	 * @return 操作行
	 */
	int add(AuditRecordsBean auditRecordsBean);

	/**
	 * 根据ID删除审批记录
	 * @param id 待删除的审批记录ID
	 * @return 操作行
	 */
	int delete(String id);

	/**
	 * 根据文章
	 * @param auditRecordsBean 审批记录
	 * @return 操作行
	 */
	int update(AuditRecordsBean auditRecordsBean);

	/**
	 * 分页查询
	 * @param auditRecordsBean 查询条件
	 * @param page 分页对象
	 * @return 分页结果
	 */
	Page<AuditRecordsBean> page(AuditRecordsBean auditRecordsBean, Page<AuditRecordsBean> page);

	/**
	 * 根据ID查询审批记录
	 * @param id id
	 * @return 操作行
	 */
	AuditRecordsBean getById(String id);

	/**
	 * 获取所有审批记录
	 * @param auditRecordsBean 查询条件
	 * @return 满足条件的所有审批记录
	 */
	List<AuditRecordsBean> findAll(AuditRecordsBean auditRecordsBean);
}






































