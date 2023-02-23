package com.so.modules.system.utils;

import com.so.modules.system.bean.User;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {
	
	public static User currentUser(HttpServletRequest request){
		Object login = request.getSession().getAttribute("login");
		if (login!=null) {
			return (User) login;
		}else{
			return null;
		}
	}
}
