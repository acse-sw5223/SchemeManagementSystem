package com.so.commons.utils;

import com.so.modules.system.bean.User;
import com.so.modules.system.utils.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.utils.DateUtils;
import org.apache.commons.utils.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 安全过滤器
 *
 */
@WebFilter("/*")
public class SerFilter implements Filter {
	//定义放行的URL
	static List<String> exceptUrls = new ArrayList<String>();
	
	static{
		//静态代码块 里面代码只执行一次
		System.out.println(DateUtils.getDateTime()+"---初始化放行的URL。。。");
		exceptUrls.add("regit");
		exceptUrls.add("login");
		exceptUrls.add("logout");
		exceptUrls.add("checkUserName");//注册验证用户名的方法放行
	}

    /**
     * Default constructor. 
     */
    public SerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println(DateUtils.getDateTime()+"---开始安全过滤。。。");
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("utf-8");
		HttpServletResponse res = (HttpServletResponse) response;
		res.setContentType("text/html;charset=utf-8");
		String parameter = request.getParameter("method");
		if (StringUtils.isEmpty(parameter) || exceptUrls.contains(parameter)) {
			chain.doFilter(req, res);
		}else{
			User login = UserUtil.currentUser(req);
			if (login==null) {
				String contextPath = req.getServletContext().getContextPath();
				res.getWriter().write("<script>alert('用户身份过期！');window.parent.location.href='"+contextPath+"/login.jsp'</script>");
			}else{
				chain.doFilter(req, res);
			}
		}
		//System.out.println(DateUtils.getDateTime()+"---结束安全过滤。。。");
	}

	/**
	 * @see
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		String value = PropertiesUtil.getValue("projectName");
		System.out.println(DateUtils.getDateTime()+"---欢迎使用--"+value+"---");
		fConfig.getServletContext().setAttribute("projectName", value);
	}

}
