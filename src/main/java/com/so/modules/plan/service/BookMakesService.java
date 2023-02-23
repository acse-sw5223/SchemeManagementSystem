package com.so.modules.plan.service;

import com.so.modules.plan.bean.BookMakesBean;
import com.so.modules.plan.bean.PlanFixRecordsBean;
import org.apache.commons.utils.Page;

import java.util.List;

/**
 * 方案制定书
 * @author admin
 * @version 2022-07-02 17:04:37
 */
public interface BookMakesService {
	/**
	 * 添加方案制定书
	 * @param bookMakesBean 方案制定书
	 * @return 操作行
	 */
	int add(BookMakesBean bookMakesBean);

	/**
	 * 根据ID删除方案制定书
	 * @param id 待删除的方案制定书ID
	 * @return 操作行
	 */
	int delete(String id);

	/**
	 * 根据文章
	 * @param bookMakesBean 方案制定书
	 * @return 操作行
	 */
	int update(BookMakesBean bookMakesBean);

	/**
	 * 更新审批状态
	 * @param bookMakesBean
	 * @return
	 */
	int updatePlanStatus(BookMakesBean bookMakesBean);

	/**
	 * 分页查询
	 * @param bookMakesBean 查询条件
	 * @param page 分页对象
	 * @return 分页结果
	 */
	Page<BookMakesBean> page(BookMakesBean bookMakesBean, Page<BookMakesBean> page);

	/**
	 * 根据ID查询方案制定书
	 * @param id id
	 * @return 操作行
	 */
	BookMakesBean getById(String id);

	/**
	 * 获取所有方案制定书
	 * @param bookMakesBean 查询条件
	 * @return 满足条件的所有方案制定书
	 */
	List<BookMakesBean> findAll(BookMakesBean bookMakesBean);

	List<PlanFixRecordsBean> fixList(PlanFixRecordsBean planFixRecordsBean);
}






































