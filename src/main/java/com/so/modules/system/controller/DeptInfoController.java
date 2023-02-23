package com.so.modules.system.controller;

import com.so.modules.system.bean.DeptInfoBean;
import com.so.modules.system.service.DeptInfoService;
import com.so.modules.system.service.impl.DeptInfoServiceImpl;
import org.apache.commons.utils.BaseServlet;
import org.apache.commons.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 部门信息 servlet控制器
 * @author admin
 * @version 2022-07-02 15:53:14
 */
@WebServlet("/deptInfo")
public class DeptInfoController extends BaseServlet<DeptInfoController> {

	DeptInfoService deptInfoService = new DeptInfoServiceImpl();
  
  /**
  * 保存 部门信息
  */
	public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String deptName = request.getParameter("deptName");
		String deptDesc = request.getParameter("deptDesc");
		DeptInfoBean deptInfoBean = new DeptInfoBean();
		deptInfoBean.setId(id);
		deptInfoBean.setDeptName(deptName);
		deptInfoBean.setDeptDesc(deptDesc);
		if (deptInfoBean.getId()!=null && !"".equals(deptInfoBean.getId())) {
   			deptInfoService.update(deptInfoBean);
		}else{
   			deptInfoService.add(deptInfoBean);
		}
		response.sendRedirect(contextPath+"/deptInfo?method=list");
	}
  
	//根据ID删除 部门信息
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		deptInfoService.delete(id);
		response.sendRedirect(contextPath+"/deptInfo?method=list");
	}
  
	//列表查询
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptInfoBean deptInfoBean = new DeptInfoBean();
		//分页有关
		Page<DeptInfoBean> page = new Page<DeptInfoBean>();
		//设置查询页
		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr != null && pageNoStr != "") {
			page.setPageNo(Integer.parseInt(pageNoStr));
		}
		//设置查询条件
		String id = request.getParameter("id");
		if (id != null && id != "") {
			deptInfoBean.setId(id);
			request.setAttribute("id", id);
		}
		String deptDesc = request.getParameter("deptDesc");
		if (deptDesc != null && deptDesc != "") {
			deptInfoBean.setDeptDesc(deptDesc);
			request.setAttribute("deptDesc", deptDesc);
		}
		
		//判断提示信息
		Object msg = request.getSession().getAttribute("msg");
		if (msg != null) {
			request.setAttribute("msg", msg.toString());
			request.getSession().removeAttribute("msg");
		}
		
		page = deptInfoService.page(deptInfoBean, page);
		request.setAttribute("page", page);
		request.getRequestDispatcher(viewPrefix + "system/deptInfoList.jsp").forward(request, response);
	}
	
	//form跳转页面
	public void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DeptInfoBean deptInfoBean = new DeptInfoBean();
		if (id!=null && id!="") {
			deptInfoBean = deptInfoService.getById(id);
		}
		request.setAttribute("deptInfoBean", deptInfoBean);
		request.getRequestDispatcher(viewPrefix + "system/deptInfoForm.jsp").forward(request, response);
	}

}




































