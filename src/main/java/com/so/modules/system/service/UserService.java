package com.so.modules.system.service;

import com.so.modules.system.bean.User;
import org.apache.commons.utils.Page;

import java.util.List;

/**
 * 系统用户DAO接口
 * @author so
 * @version V1.0
 */
public interface UserService {

	/**
	 * 添加用户
	 * @param user 添加对象
	 * @return 操作行
	 */
	int add(User user);

	/**
	 * 根据ID删除用户
	 * @param id id
	 * @return 操作行
	 */
	int delete(String id);

	/**
	 * 修改用户
	 * @param user 修改对象
	 * @return 操作行
	 */
	int update(User user);

	/**
	 * 分页查询用户
	 * @param user 查询条件
	 * @param page 分页对象
	 * @return 分页结果
	 */
	Page<User> page(User user, Page<User> page);

	/**
	 * 根据ID查询用户
	 * @param id id
	 * @return 用户对象
	 */
	User getById(String id);

	/**
	 * 获取所有的用户
	 * @param user 查询条件
	 * @return 所有用户
	 */
	List<User> findAll(User user);

	/**
	 * 用户登录
	 * @param username 账号
	 * @param password 密码
	 * @return 登录对象
	 */
	User login(String username, String password);
		
}