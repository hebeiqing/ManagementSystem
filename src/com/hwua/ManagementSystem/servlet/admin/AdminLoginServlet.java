package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.ManagementSystem.service.UserService;
import com.hwua.ManagementSystem.service.impl.UserServiceImpl;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet{
	
	private UserService userService;
	
	public AdminLoginServlet() {
		userService = new UserServiceImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//从页面接收的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//调用userService的方法
		Map<String, Object> resultMap = userService.adminLogin(username, password);
		if((Boolean)resultMap.get("ok")){
			//登录成功就保存管理员对象到session中，并跳转到后台管理首页
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", resultMap.get("loginAdmin"));
			//跳转到后台管理首页
			//response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
			response.sendRedirect(request.getContextPath()+ "/Match/main.jsp");
		}else{
			//登录失败就跳回登录页面，继续登录
			request.setAttribute("error", resultMap.get("error"));
			//request.getRequestDispatcher("admin_login.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}
}
