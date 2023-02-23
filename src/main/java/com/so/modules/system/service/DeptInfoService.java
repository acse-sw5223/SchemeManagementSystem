package com.so.modules.system.service;

import com.so.modules.system.bean.DeptInfoBean;
import org.apache.commons.utils.Page;

import java.util.List;

/**
 * 部门信息
 * @author admin
 * @version 2022-07-02 15:53:14
 */
public interface DeptInfoService {
	/**
	 * 添加部门信息
	 * @param deptInfoBean 部门信息
	 * @return 操作行
	 */
	int add(DeptInfoBean deptInfoBean);

	/**
	 * 根据ID删除部门信息
	 * @param id 待删除的部门信息ID
	 * @return 操作行
	 */
	int delete(String id);

	/**
	 * 根据文章
	 * @param deptInfoBean 部门信息
	 * @return 操作行
	 */
	int update(DeptInfoBean deptInfoBean);

	/**
	 * 分页查询
	 * @param deptInfoBean 查询条件
	 * @param page 分页对象
	 * @return 分页结果
	 */
	Page<DeptInfoBean> page(DeptInfoBean deptInfoBean, Page<DeptInfoBean> page);

	/**
	 * 根据ID查询部门信息
	 * @param id id
	 * @return 操作行
	 */
	DeptInfoBean getById(String id);

	/**
	 * 获取所有部门信息
	 * @param deptInfoBean 查询条件
	 * @return 满足条件的所有部门信息
	 */
	List<DeptInfoBean> findAll(DeptInfoBean deptInfoBean);
}






































