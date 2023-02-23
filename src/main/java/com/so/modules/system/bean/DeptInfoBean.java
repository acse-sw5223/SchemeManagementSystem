package com.so.modules.system.bean;

import java.io.Serializable;

/**
 * 部门信息
 * @author admin
 * @version 2022-07-02 15:53:14
 */
public class DeptInfoBean implements Serializable  {
	
	private static final long serialVersionUID = 1L;
  
	/**
	 * 编号
	*/
	private String id;
	/**
	 * 部门名称
	*/
	private String deptName;
	/**
	 * 部门描述
	*/
	private String deptDesc;
      
	public void setId(String id) {
      this.id = id;
	}; 
  
	public String getId(){
      return this.id;
	};
	public void setDeptName(String deptName) {
      this.deptName = deptName;
	}; 
  
	public String getDeptName(){
      return this.deptName;
	};
	public void setDeptDesc(String deptDesc) {
      this.deptDesc = deptDesc;
	}; 
  
	public String getDeptDesc(){
      return this.deptDesc;
	};
}




































