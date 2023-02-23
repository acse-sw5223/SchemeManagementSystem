package com.so.modules.system.controller;

import com.so.commons.enums.RoleEnum;
import com.so.modules.system.bean.User;
import com.so.modules.system.service.UserService;
import com.so.modules.system.service.impl.UserServiceImpl;
import com.so.modules.system.utils.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.utils.BaseServlet;
import org.apache.commons.utils.FileUtils;
import org.apache.commons.utils.MD5;
import org.apache.commons.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
@MultipartConfig
public class UserController extends BaseServlet<UserController> {
	public static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();

	/**
	 * 跳转到个人信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(viewPrefix + "system/userInfo.jsp").forward(request, response);
		
	}

	/**
	 * 保存修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void fixPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		User byId = userService.getById(id);
		byId.setPassword(password);
		userService.update(byId);
		request.setAttribute("msg", "密码修改成功");
		request.getSession().setAttribute("login", byId);
		request.getRequestDispatcher(viewPrefix + "system/userPassFix.jsp").forward(request, response);
		
	}

	/**
	 * 跳转到修改密码界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userPassFix(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(viewPrefix + "system/userPassFix.jsp").forward(request, response);
	}

	/**
	 * 验证旧密码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkPass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User currentUser = UserUtil.currentUser(request);
		if (currentUser!=null) {
			String oldpassword = request.getParameter("oldpassword");
			if (currentUser.getPassword().equals(MD5.Encrypt(currentUser.getUsername()+oldpassword))) {
				response.getWriter().write("true");
			}else{
				response.getWriter().write("false");
			}
		}else{
			response.getWriter().write("false");
		}
		
	}

	/**
	 * 验证用户名是否在数据库中存在
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		User user = new User();
		user.setUsername(username);
		List<User> findAll = userService.findAll(user);
		if (findAll!=null && findAll.size()>0) {
			//用户名存在
			System.out.println("用户名存在了");
			response.getWriter().write("false");
		}else{
			System.out.println("用户名不存在");
			response.getWriter().write("true");
		}
		
	}

	/**
	 * 安全退出，清空session
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.getSession().invalidate();
		response.getWriter().write("<script>alert('感谢使用！');window.location.href='"+contextPath+"/login.jsp';</script>");
		
	}

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		request.setAttribute("username", username);
		String password = request.getParameter("password");
		request.setAttribute("password", password);
		String code = request.getParameter("code");
		request.setAttribute("code", code);
		Object sRand = request.getSession().getAttribute("sRand");
		if (code.equals(sRand)) {
			User login = userService.login(username, password);
			if (login!=null) {
				request.getSession().setAttribute("login", login);
				response.getWriter().write("<script>alert('欢迎使用！');window.location.href='"+contextPath+"/index.jsp';</script>");
			}else{
				/*response.getWriter().write("<script>alert('用户名或者密码错误');window.location.href='"+contextPath+"/login.jsp';</script>");*/
				request.setAttribute("msg", "用户名密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "验证码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * 添加用户（注册）
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("trueName");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String content = request.getParameter("content");
		String role = request.getParameter("role");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setSex(sex);
		user.setPhone(phone);
		user.setContent(content);
		user.setRole(role);
		userService.add(user);
		response.getWriter().write("<script>alert('注册成功');window.location.href='"+contextPath+"/login.jsp';</script>");
	}

	/**
	 * 新增或修改用户，表单里含文件上传时调用此方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saveUser(request, response);
		response.sendRedirect(contextPath+"/user?method=list");
	}
	
	//删除
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		userService.delete(id);
		response.sendRedirect(contextPath+"/user?method=list");
	}
	
	//修改
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = saveUser(request, response);
		request.setAttribute("user", user);
		request.setAttribute("msg", "个人信息修改成功！！");
		request.getSession().setAttribute("login", user);
		request.getRequestDispatcher(viewPrefix + "system/userInfo.jsp").forward(request, response);
	}

	private User saveUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String role = request.getParameter("role");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String picture = FileUtils.uploadFile(request,"picture");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String content = request.getParameter("content");
		User user = new User();
		user.setId(id);
		user.setRole(role);
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setPicture(picture);
		user.setSex(sex);
		user.setPhone(phone);
		user.setContent(content);
		if (StringUtils.isNotEmpty(id)) {
			userService.update(user);
		} else {
			user.setRole(RoleEnum.ADMIN.getRoleId());
			userService.add(user);
		}
		return user;
	}

	//列表查询
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("---开始查询---");
		User user = new User();
		//分页有关
		Page<User> page = new Page<User>();
		//设置查询页
		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr != null && pageNoStr != "") {
			page.setPageNo(Integer.parseInt(pageNoStr));
		}
		//设置查询条件
		String username = request.getParameter("username");
		if (username != null && username != "") {
			user.setUsername(username);
			request.setAttribute("username", username);
		}
		String name = request.getParameter("name");
		if (name != null && name != "") {
			user.setName(name);
			request.setAttribute("name", name);
		}
		String sex = request.getParameter("sex");
		if (sex != null && sex != "") {
			user.setSex(sex);
			request.setAttribute("sex", sex);
		}
		
		page = userService.page(user, page);
		request.setAttribute("page", page);
		request.getRequestDispatcher(viewPrefix + "system/userList.jsp").forward(request, response);
	}
	
	//form跳转页面
	public void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = new User();
		if (id!=null && id!="") {
			user = userService.getById(id);
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher(viewPrefix + "system/userForm.jsp").forward(request, response);
	}
	
}