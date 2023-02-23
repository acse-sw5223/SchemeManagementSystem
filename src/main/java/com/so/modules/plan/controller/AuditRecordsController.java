package com.so.modules.plan.controller;

import com.so.commons.enums.DictEnums;
import com.so.modules.plan.bean.AuditRecordsBean;
import com.so.modules.plan.bean.BookMakesBean;
import com.so.modules.plan.service.AuditRecordsService;
import com.so.modules.plan.service.BookMakesService;
import com.so.modules.plan.service.impl.AuditRecordsServiceImpl;
import com.so.modules.plan.service.impl.BookMakesServiceImpl;
import com.so.modules.system.utils.UserUtil;
import org.apache.commons.utils.BaseServlet;
import org.apache.commons.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


/**
 * 审批记录 servlet控制器
 *
 * @author admin
 * @version 2022-07-03 09:44:37
 */
@WebServlet("/auditRecords")
public class AuditRecordsController extends BaseServlet<AuditRecordsController> {

    AuditRecordsService auditRecordsService = new AuditRecordsServiceImpl();

	BookMakesService bookMakesService = new BookMakesServiceImpl();

    /**
     * 保存 审批记录
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AuditRecordsBean auditRecordsBean = new AuditRecordsBean();
        String schemeNo = request.getParameter("schemeNo");
        auditRecordsBean.setSchemeNo(Long.valueOf(schemeNo));
        auditRecordsBean.setSchemeAuditDate(new Date());
        String cchemeReviewComments = request.getParameter("cchemeReviewComments");
        auditRecordsBean.setCchemeReviewComments(cchemeReviewComments);
        auditRecordsBean.setSchemeReviewer(UserUtil.currentUser(request).getUsername());
		String auditStatus = request.getParameter("auditStatus");
		auditRecordsBean.setAuditStatus(auditStatus);
		auditRecordsService.add(auditRecordsBean);
		//
		BookMakesBean byId = bookMakesService.getById(schemeNo);
		if (DictEnums.AUDIT_STATUS_0.getDictValue().equals(auditStatus)) {
			// 审批不通过
			byId.setPlanStatus(DictEnums.PLAN_STATUS_2.getDictValue());
		} else {
			// 审批通过
			byId.setPlanStatus(DictEnums.PLAN_STATUS_4.getDictValue());
		}
		bookMakesService.updatePlanStatus(byId);
		response.sendRedirect(contextPath + "/bookMakes?method=needAudit");
    }

    //根据ID删除 审批记录
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        auditRecordsService.delete(id);
        response.sendRedirect(contextPath + "/auditRecords?method=list");
    }

    //列表查询
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuditRecordsBean auditRecordsBean = new AuditRecordsBean();
        //分页有关
        Page<AuditRecordsBean> page = new Page<AuditRecordsBean>();
        //设置查询页
        String pageNoStr = request.getParameter("pageNo");
        if (pageNoStr != null && pageNoStr != "") {
            page.setPageNo(Integer.parseInt(pageNoStr));
        }
        //设置查询条件
        String schemeNo = request.getParameter("schemeNo");
        if (schemeNo != null && schemeNo != "") {
            auditRecordsBean.setSchemeNo(Long.valueOf(schemeNo));
            request.setAttribute("schemeNo", schemeNo);
        }

        //判断提示信息
        Object msg = request.getSession().getAttribute("msg");
        if (msg != null) {
            request.setAttribute("msg", msg.toString());
            request.getSession().removeAttribute("msg");
        }

        page = auditRecordsService.page(auditRecordsBean, page);
        request.setAttribute("page", page);
        request.getRequestDispatcher(viewPrefix + "plan/auditRecordsList.jsp").forward(request, response);
    }

    //form跳转页面
    public void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AuditRecordsBean auditRecordsBean = new AuditRecordsBean();
        if (id != null && id != "") {
            auditRecordsBean = auditRecordsService.getById(id);
        }
        request.setAttribute("auditRecordsBean", auditRecordsBean);
        request.getRequestDispatcher(viewPrefix + "plan/auditRecordsForm.jsp").forward(request, response);
    }

}




































