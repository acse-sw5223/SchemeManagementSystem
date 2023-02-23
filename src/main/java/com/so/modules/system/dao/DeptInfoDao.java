package com.so.modules.system.dao;

import cn.hutool.core.util.IdUtil;
import com.so.modules.system.bean.DeptInfoBean;
import org.apache.commons.utils.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门信息
 * @author admin
 * @version 2022-07-02 15:53:14
 */
public class DeptInfoDao {
	/**
	 * 添加 部门信息
	 * @param con 数据库链接
	 * @param deptInfoBean 部门信息
	 * @return 操作行
	 * @throws Exception 异常
	 */
  public int add(Connection con,DeptInfoBean deptInfoBean) throws Exception{
		deptInfoBean.setId(IdUtil.fastSimpleUUID());
		PreparedStatement preparedStatement = con.prepareStatement("insert into sys_dept_info values(?,?,?)");
		preparedStatement.setString(1, deptInfoBean.getId());
		preparedStatement.setString(2, deptInfoBean.getDeptName());
		preparedStatement.setString(3, deptInfoBean.getDeptDesc());
		return preparedStatement.executeUpdate();
	}
  
	/**
	 * 删除 部门信息
	 * @param con 数据库链接
	 * @param id id
	 * @return 删除行数
	 * @throws Exception 异常
	 */
	public int delete(Connection con,String id) throws Exception{
		PreparedStatement preparedStatement = con.prepareStatement("delete from sys_dept_info where id= ?");
		preparedStatement.setString(1, id);
		return preparedStatement.executeUpdate();
	}
  
	/**
	 * 更新  部门信息
	 * @param con 数据库链接
	 * @param deptInfoBean  部门信息
	 * @return 更新行数
	 * @throws Exception 异常
	 */
  public int update(Connection con, DeptInfoBean deptInfoBean) throws Exception{
		PreparedStatement preparedStatement = con.prepareStatement("update sys_dept_info set dept_name=?,dept_desc=? where id = ?");
		preparedStatement.setString(3,deptInfoBean.getId());
		preparedStatement.setString(1,deptInfoBean.getDeptName());
		preparedStatement.setString(2,deptInfoBean.getDeptDesc());
		return preparedStatement.executeUpdate();
	}
  
	/**
	 * 分页查询
	 * @param con 数据库链接
	 * @param deptInfoBean 部门信息
	 * @return 分页集合
	 * @throws Exception 异常
	 */
  public List<DeptInfoBean> list(Connection con, DeptInfoBean deptInfoBean, Page<DeptInfoBean> page) throws Exception{
		List<DeptInfoBean> list = new ArrayList<DeptInfoBean>();
		DeptInfoBean entity = null;
		StringBuffer sqlBuffer = new StringBuffer("select * from sys_dept_info a where 1=1");
		//拼接分页条件
		String deptName = deptInfoBean.getDeptName();
		if(deptName != null && deptName !=""){
			sqlBuffer.append(" and dept_name = '"+deptName+"'");
		}
		String sql = Page.pageSql(sqlBuffer, page.getPageNo(), page.getPageSize());
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			entity = getDictFormDb(rs);
			list.add(entity);
		}
		return list;
	}
  
	/**
	 * 根据条件查询所有满足条件的数据
	 * @param con 数据库链接
	 * @param deptInfoBean 查询条件
	 * @return 所有部门信息
	 * @throws Exception 异常
	 */
	public List<DeptInfoBean> findAll(Connection con,DeptInfoBean deptInfoBean) throws Exception{
		List<DeptInfoBean> list = new ArrayList<DeptInfoBean>();
		DeptInfoBean entity;
      StringBuffer sqlBuffer = new StringBuffer("select * from sys_dept_info where 1=1");
		//拼接分页条件
		String deptName = deptInfoBean.getDeptName();
		if(deptName != null && deptName !=""){
			sqlBuffer.append(" and dept_name = '"+deptName+"'");
		}
		
		String sql = sqlBuffer.toString();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			entity = getDictFormDb(rs);
			list.add(entity);
		}
		return list;
	}
  
	/**
	 * 根据id查询
	 * @param con 数据库链接
	 * @param id id
	 * @return 部门信息
	 * @throws Exception 异常
	 */
  public DeptInfoBean getById(Connection con, String id) throws Exception{
		DeptInfoBean deptInfoBean = null;
  		StringBuffer stringBuffer = new StringBuffer("select * from sys_dept_info where id = ?");
		PreparedStatement preparedStatement = con.prepareStatement(stringBuffer.toString());
		preparedStatement.setString(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			deptInfoBean = getDictFormDb(rs);
		}
		return deptInfoBean;
	}

	/**
	 * 获取总数 分页查询计算分页信息用
	 * @param con 数据库链接
	 * @param deptInfoBean 查询条件
	 * @return 总数
	 * @throws Exception 异常
	 */
	public int count(Connection con, DeptInfoBean deptInfoBean) throws Exception{
		int count = 0;
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select count(*) as count from sys_dept_info where 1=1");
		//拼接分页条件
		String deptName = deptInfoBean.getDeptName();
		if(deptName != null && deptName !=""){
			sqlBuffer.append(" and dept_name = '"+deptName+"'");
		}

		String sql = sqlBuffer.toString();
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			count = rs.getInt("count");
		}
		return count;
	}
	
   /**
   * 映射数据库返回值到javaben对象
   */
	private DeptInfoBean getDictFormDb(ResultSet rs) throws SQLException{
		DeptInfoBean deptInfoBean = new DeptInfoBean();
		deptInfoBean.setId(rs.getString("id"));
		deptInfoBean.setDeptName(rs.getString("dept_name"));
		deptInfoBean.setDeptDesc(rs.getString("dept_desc"));
		return deptInfoBean;
	}
}






































