package com.so.modules.plan.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 方案制定书
 * @author admin
 * @version 2022-07-02 17:04:37
 */
public class BookMakesBean implements Serializable  {
	
	private static final long serialVersionUID = 1L;
  
	/**
	 * 编号
	*/
	private String id;
	/**
	 * 方案编号
	*/
	private Long schemeNo;
	/**
	 * 方案描述
	*/
	private String schemeDescription;
	/**
	 * 方案细则
	*/
	private String schemeProgramRules;
	/**
	 * 制定员
	*/
	private String schemeFormulator;
	/**
	 * 制定日期
	*/
	private Date createTime;
	/**
	 * 需求编号
	*/
	private Long requirementItemNo;
	/**
	 * 方案状态
	 */
	private String planStatus;
      
	public void setId(String id) {
      this.id = id;
	}; 
  
	public String getId(){
      return this.id;
	};
	public void setSchemeNo(Long schemeNo) {
      this.schemeNo = schemeNo;
	}; 
  
	public Long getSchemeNo(){
      return this.schemeNo;
	};
	public void setSchemeDescription(String schemeDescription) {
      this.schemeDescription = schemeDescription;
	}; 
  
	public String getSchemeDescription(){
      return this.schemeDescription;
	};
	public void setSchemeProgramRules(String schemeProgramRules) {
      this.schemeProgramRules = schemeProgramRules;
	}; 
  
	public String getSchemeProgramRules(){
      return this.schemeProgramRules;
	};
	public void setSchemeFormulator(String schemeFormulator) {
      this.schemeFormulator = schemeFormulator;
	}; 
  
	public String getSchemeFormulator(){
      return this.schemeFormulator;
	};
	public void setCreateTime(Date createTime) {
      this.createTime = createTime;
	}; 
  
	public Date getCreateTime(){
      return this.createTime;
	};
	public void setRequirementItemNo(Long requirementItemNo) {
      this.requirementItemNo = requirementItemNo;
	}; 
  
	public Long getRequirementItemNo(){
      return this.requirementItemNo;
	};

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	private String createUser;
	private String needAudits;
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getNeedAudits() {
		return needAudits;
	}

	public void setNeedAudits(String needAudits) {
		this.needAudits = needAudits;
	}
}




































