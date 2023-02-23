package com.so.modules.plan.controller;

import cn.hutool.core.date.DateUtil;
import com.so.modules.plan.bean.PlanDemandInfoBean;
import com.so.modules.plan.service.PlanDemandInfoService;
import com.so.modules.plan.service.impl.PlanDemandInfoServiceImpl;
import org.apache.commons.utils.BaseServlet;
import org.apache.commons.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 方案需求 servlet控制器
 * @author admin
 * @version 2022-07-02 16:15:31
 */
@WebServlet("/planDemandInfo")
public class PlanDemandInfoController extends BaseServlet<PlanDemandInfoController> {

	PlanDemandInfoService planDemandInfoService = new PlanDemandInfoServiceImpl();
  
  /**
  * 保存 方案需求
  */
	public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String requirementItemNo = request.getParameter("requirementItemNo");
		String experimentName = request.getParameter("experimentName");
		String experimentalDescription = request.getParameter("experimentalDescription");
		String dateOfPreliminaryReview = request.getParameter("dateOfPreliminaryReview");
		String preliminaryExaminer = request.getParameter("preliminaryExaminer");
		String applicantDepartment = request.getParameter("applicantDepartment");
		String nameOfApplicant = request.getParameter("nameOfApplicant");
		String applicationDate = request.getParameter("applicationDate");
		PlanDemandInfoBean planDemandInfoBean = new PlanDemandInfoBean();
		planDemandInfoBean.setId(id);
		planDemandInfoBean.setRequirementItemNo(requirementItemNo);
		planDemandInfoBean.setExperimentName(experimentName);
		planDemandInfoBean.setExperimentalDescription(experimentalDescription);
		planDemandInfoBean.setDateOfPreliminaryReview(DateUtil.parseDate(dateOfPreliminaryReview));
		planDemandInfoBean.setPreliminaryExaminer(preliminaryExaminer);
		planDemandInfoBean.setApplicantDepartment(applicantDepartment);
		planDemandInfoBean.setNameOfApplicant(nameOfApplicant);
		planDemandInfoBean.setApplicationDate(DateUtil.parseDate(applicationDate));
		if (planDemandInfoBean.getId()!=null && !"".equals(planDemandInfoBean.getId())) {
   			planDemandInfoService.update(planDemandInfoBean);
		}else{
   			planDemandInfoService.add(planDemandInfoBean);
		}
		response.sendRedirect(contextPath+"/planDemandInfo?method=list");
	}
  
	//根据ID删除 方案需求
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		planDemandInfoService.delete(id);
		response.sendRedirect(contextPath+"/planDemandInfo?method=list");
	}
  
	//列表查询
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlanDemandInfoBean planDemandInfoBean = new PlanDemandInfoBean();
		//分页有关
		Page<PlanDemandInfoBean> page = new Page<PlanDemandInfoBean>();
		//设置查询页
		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr != null && pageNoStr != "") {
			page.setPageNo(Integer.parseInt(pageNoStr));
		}
		//设置查询条件
		String requirementItemNo = request.getParameter("requirementItemNo");
		if (requirementItemNo != null && requirementItemNo != "") {
			planDemandInfoBean.setRequirementItemNo(requirementItemNo);
			request.setAttribute("requirementItemNo", requirementItemNo);
		}
		String experimentName = request.getParameter("experimentName");
		if (experimentName != null && experimentName != "") {
			planDemandInfoBean.setExperimentName(experimentName);
			request.setAttribute("experimentName", experimentName);
		}
		String applicantDepartment = request.getParameter("applicantDepartment");
		if (applicantDepartment != null && applicantDepartment != "") {
			planDemandInfoBean.setApplicantDepartment(applicantDepartment);
			request.setAttribute("applicantDepartment", applicantDepartment);
		}
		String nameOfApplicant = request.getParameter("nameOfApplicant");
		if (nameOfApplicant != null && nameOfApplicant != "") {
			planDemandInfoBean.setNameOfApplicant(nameOfApplicant);
			request.setAttribute("nameOfApplicant", nameOfApplicant);
		}
		
		//判断提示信息
		Object msg = request.getSession().getAttribute("msg");
		if (msg != null) {
			request.setAttribute("msg", msg.toString());
			request.getSession().removeAttribute("msg");
		}
		
		page = planDemandInfoService.page(planDemandInfoBean, page);
		request.setAttribute("page", page);
		request.getRequestDispatcher(viewPrefix + "plan/planDemandInfoList.jsp").forward(request, response);
	}
	
	//form跳转页面
	public void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PlanDemandInfoBean planDemandInfoBean = new PlanDemandInfoBean();
		if (id!=null && id!="") {
			planDemandInfoBean = planDemandInfoService.getById(id);
		}
		request.setAttribute("planDemandInfoBean", planDemandInfoBean);
		request.getRequestDispatcher(viewPrefix + "plan/planDemandInfoForm.jsp").forward(request, response);
	}

}




































