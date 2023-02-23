package com.so.modules.plan.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 审批记录
 * @author admin
 * @version 2022-07-03 09:44:37
 */
public class AuditRecordsBean implements Serializable  {
	
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
	 * 审核日期
	*/
	private Date schemeAuditDate;
	/**
	 * 审核意见
	*/
	private String cchemeReviewComments;
	/**
	 * 审核结果
	 */
	private String auditStatus;
	/**
	 * 审核人
	*/
	private String schemeReviewer;
      
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
	public void setSchemeAuditDate(Date schemeAuditDate) {
      this.schemeAuditDate = schemeAuditDate;
	}; 
  
	public Date getSchemeAuditDate(){
      return this.schemeAuditDate;
	};
	public void setCchemeReviewComments(String cchemeReviewComments) {
      this.cchemeReviewComments = cchemeReviewComments;
	}; 
  
	public String getCchemeReviewComments(){
      return this.cchemeReviewComments;
	};
	public void setSchemeReviewer(String schemeReviewer) {
      this.schemeReviewer = schemeReviewer;
	}; 
  
	public String getSchemeReviewer(){
      return this.schemeReviewer;
	};

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
}




































