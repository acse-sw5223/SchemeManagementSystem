package com.so.modules.plan.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 方案需求
 * @author admin
 * @version 2022-07-02 16:15:31
 */
public class PlanDemandInfoBean implements Serializable  {
	
	private static final long serialVersionUID = 1L;
  
	/**
	 * 主键ID
	*/
	private String id;
	/**
	 * 需求项编号
	*/
	private String requirementItemNo;
	/**
	 * 实验名
	*/
	private String experimentName;
	/**
	 * 实验描述
	*/
	private String experimentalDescription;
	/**
	 * 初审日期
	*/
	private Date dateOfPreliminaryReview;
	/**
	 * 初审员
	*/
	private String preliminaryExaminer;
	/**
	 * 申请人部门
	*/
	private String applicantDepartment;
	/**
	 * 申请人姓名
	*/
	private String nameOfApplicant;
	/**
	 * 申请日期
	*/
	private Date applicationDate;
      
	public void setId(String id) {
      this.id = id;
	}; 
  
	public String getId(){
      return this.id;
	};
	public void setRequirementItemNo(String requirementItemNo) {
      this.requirementItemNo = requirementItemNo;
	}; 
  
	public String getRequirementItemNo(){
      return this.requirementItemNo;
	};
	public void setExperimentName(String experimentName) {
      this.experimentName = experimentName;
	}; 
  
	public String getExperimentName(){
      return this.experimentName;
	};
	public void setExperimentalDescription(String experimentalDescription) {
      this.experimentalDescription = experimentalDescription;
	}; 
  
	public String getExperimentalDescription(){
      return this.experimentalDescription;
	};
	public void setDateOfPreliminaryReview(Date dateOfPreliminaryReview) {
      this.dateOfPreliminaryReview = dateOfPreliminaryReview;
	}; 
  
	public Date getDateOfPreliminaryReview(){
      return this.dateOfPreliminaryReview;
	};
	public void setPreliminaryExaminer(String preliminaryExaminer) {
      this.preliminaryExaminer = preliminaryExaminer;
	}; 
  
	public String getPreliminaryExaminer(){
      return this.preliminaryExaminer;
	};
	public void setApplicantDepartment(String applicantDepartment) {
      this.applicantDepartment = applicantDepartment;
	}; 
  
	public String getApplicantDepartment(){
      return this.applicantDepartment;
	};
	public void setNameOfApplicant(String nameOfApplicant) {
      this.nameOfApplicant = nameOfApplicant;
	}; 
  
	public String getNameOfApplicant(){
      return this.nameOfApplicant;
	};
	public void setApplicationDate(Date applicationDate) {
      this.applicationDate = applicationDate;
	}; 
  
	public Date getApplicationDate(){
      return this.applicationDate;
	};
}




































