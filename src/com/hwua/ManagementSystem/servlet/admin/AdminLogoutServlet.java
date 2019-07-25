package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 管理员注销Servlet
 */
@WebServlet("/adminLogout")
public class AdminLogoutServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.invalidate();//清空session
		session.removeAttribute("loginAdmin");//删除session中的登录管理员对象
	//	response.sendRedirect("admin_login.jsp");
		request.getRequestDispatcher("\\Match\\login.jsp").forward(request, response);
	}
}
