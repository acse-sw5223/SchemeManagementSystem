package com.so.modules.plan.controller;

import com.so.commons.enums.DictEnums;
import com.so.commons.enums.RoleEnum;
import com.so.modules.plan.bean.BookMakesBean;
import com.so.modules.plan.bean.PlanFixRecordsBean;
import com.so.modules.plan.service.BookMakesService;
import com.so.modules.plan.service.impl.BookMakesServiceImpl;
import com.so.modules.system.utils.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.utils.BaseServlet;
import org.apache.commons.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * 方案制定书 servlet控制器
 *
 * @author admin
 * @version 2022-07-02 17:04:37
 */
@WebServlet("/bookMakes")
public class BookMakesController extends BaseServlet<BookMakesController> {

    BookMakesService bookMakesService = new BookMakesServiceImpl();

    /**
     * 保存 方案制定书
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String schemeDescription = request.getParameter("schemeDescription");
        String schemeProgramRules = request.getParameter("schemeProgramRules");
        String requirementItemNo = request.getParameter("requirementItemNo");
        BookMakesBean bookMakesBean = new BookMakesBean();
        bookMakesBean.setCreateUser(UserUtil.currentUser(request).getId());
        bookMakesBean.setId(id);
        bookMakesBean.setSchemeDescription(schemeDescription);
        bookMakesBean.setSchemeProgramRules(schemeProgramRules);
        bookMakesBean.setCreateTime(new Date());
        bookMakesBean.setRequirementItemNo(Long.valueOf(requirementItemNo));
        if (bookMakesBean.getId() != null && !"".equals(bookMakesBean.getId())) {
            String schemeNo = request.getParameter("schemeNo");
            bookMakesBean.setSchemeNo(Long.valueOf(schemeNo));
            bookMakesService.update(bookMakesBean);
        } else {
            bookMakesBean.setSchemeFormulator(UserUtil.currentUser(request).getId());
            bookMakesService.add(bookMakesBean);
        }

        response.sendRedirect(contextPath + "/bookMakes?method=list");
    }

    //根据ID删除 方案制定书
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        bookMakesService.delete(id);
        response.sendRedirect(contextPath + "/bookMakes?method=list");
    }

	/**
	 * 提交审批部
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void submitToAudit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BookMakesBean byId = bookMakesService.getById(id);
		if (DictEnums.PLAN_STATUS_0.getDictValue().equals(byId.getPlanStatus())) {
			byId.setPlanStatus(DictEnums.PLAN_STATUS_1.getDictValue());
		} else {
			byId.setPlanStatus(DictEnums.PLAN_STATUS_3.getDictValue());
		}
		bookMakesService.updatePlanStatus(byId);
		response.sendRedirect(contextPath + "/bookMakes?method=list");
	}

    //列表查询
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookMakesBean bookMakesBean = new BookMakesBean();
        //分页有关
        Page<BookMakesBean> page = new Page<BookMakesBean>();
        //设置查询页
        String pageNoStr = request.getParameter("pageNo");
        if (pageNoStr != null && pageNoStr != "") {
            page.setPageNo(Integer.parseInt(pageNoStr));
        }
        //设置查询条件
        String schemeNo = request.getParameter("schemeNo");
        if (schemeNo != null && schemeNo != "") {
            request.setAttribute("schemeNo", schemeNo);
        }
        String schemeFormulator = request.getParameter("schemeFormulator");
        if (schemeFormulator != null && schemeFormulator != "") {
            bookMakesBean.setSchemeFormulator(schemeFormulator);
            request.setAttribute("schemeFormulator", schemeFormulator);
        }
        String requirementItemNo = request.getParameter("requirementItemNo");
        if (requirementItemNo != null && requirementItemNo != "") {
            bookMakesBean.setRequirementItemNo(Long.valueOf(requirementItemNo));
            request.setAttribute("requirementItemNo", requirementItemNo);
        }

        // 普通用户只看自己的
        if (UserUtil.currentUser(request).getRole().equals(RoleEnum.COMMON.getRoleId())) {
            bookMakesBean.setSchemeFormulator(UserUtil.currentUser(request).getId());
        }

        //判断提示信息
        Object msg = request.getSession().getAttribute("msg");
        if (msg != null) {
            request.setAttribute("msg", msg.toString());
            request.getSession().removeAttribute("msg");
        }

        page = bookMakesService.page(bookMakesBean, page);
        request.setAttribute("page", page);
        request.getRequestDispatcher(viewPrefix + "plan/bookMakesList.jsp").forward(request, response);
    }

    public void needAudit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookMakesBean bookMakesBean = new BookMakesBean();
        bookMakesBean.setNeedAudits("1,3");
        //分页有关
        Page<BookMakesBean> page = new Page<BookMakesBean>();
        //设置查询页
        String pageNoStr = request.getParameter("pageNo");
        if (pageNoStr != null && pageNoStr != "") {
            page.setPageNo(Integer.parseInt(pageNoStr));
        }
        //设置查询条件
        String schemeNo = request.getParameter("schemeNo");
        if (schemeNo != null && schemeNo != "") {
            request.setAttribute("schemeNo", schemeNo);
        }
        String schemeFormulator = request.getParameter("schemeFormulator");
        if (schemeFormulator != null && schemeFormulator != "") {
            bookMakesBean.setSchemeFormulator(schemeFormulator);
            request.setAttribute("schemeFormulator", schemeFormulator);
        }
        String requirementItemNo = request.getParameter("requirementItemNo");
        if (requirementItemNo != null && requirementItemNo != "") {
            bookMakesBean.setRequirementItemNo(Long.valueOf(requirementItemNo));
            request.setAttribute("requirementItemNo", requirementItemNo);
        }

        //判断提示信息
        Object msg = request.getSession().getAttribute("msg");
        if (msg != null) {
            request.setAttribute("msg", msg.toString());
            request.getSession().removeAttribute("msg");
        }

        page = bookMakesService.page(bookMakesBean, page);
        request.setAttribute("page", page);
        request.getRequestDispatcher(viewPrefix + "plan/bookMakesAuditList.jsp").forward(request, response);
    }

    //修改记录
    public void fixList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlanFixRecordsBean planFixRecordsBean = new PlanFixRecordsBean();
        //设置查询条件
        String schemeNo = request.getParameter("schemeNo");
        if (schemeNo != null && schemeNo != "") {
            planFixRecordsBean.setSchemeNo(Long.valueOf(schemeNo));
            request.setAttribute("schemeNo", schemeNo);
            BookMakesBean byId = bookMakesService.getById(schemeNo);
            request.setAttribute("bookMakesBean", byId);
        }

        //判断提示信息
        Object msg = request.getSession().getAttribute("msg");
        if (msg != null) {
            request.setAttribute("msg", msg.toString());
            request.getSession().removeAttribute("msg");
        }

        List<PlanFixRecordsBean> planFixRecordsBeans = bookMakesService.fixList(planFixRecordsBean);
        request.setAttribute("page", planFixRecordsBeans);
        request.getRequestDispatcher(viewPrefix + "plan/planFixRecordsList.jsp").forward(request, response);
    }

    //form跳转页面
    public void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BookMakesBean bookMakesBean = new BookMakesBean();
        if (StringUtils.isNotEmpty(id)) {
            bookMakesBean = bookMakesService.getById(id);
        }
        String requirementItemNo = request.getParameter("requirementItemNo");
        if (StringUtils.isNotEmpty(requirementItemNo)) {
            bookMakesBean.setRequirementItemNo(Long.valueOf(requirementItemNo));
        }
        request.setAttribute("bookMakesBean", bookMakesBean);
        request.getRequestDispatcher(viewPrefix + "plan/bookMakesForm.jsp").forward(request, response);
    }

}




































