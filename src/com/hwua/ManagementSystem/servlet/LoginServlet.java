package com.hwua.ManagementSystem.servlet;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private UserService userService;
	
	public LoginServlet() {
		userService = new UserServiceImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username==null||username.equals("")||password==null||password.equals("")){
			request.setAttribute("error", "��¼ʧ�ܣ�����д������Ϣ��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			Map<String, Object> resultMap = userService.studnetLogin(username, password);
			if((Boolean)resultMap.get("ok")) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", resultMap.get("loginUser"));
				//��¼�ɹ���ת����ҳ
				response.sendRedirect(request.getContextPath());
			} else{
				request.setAttribute("error", resultMap.get("error"));
				request.getRequestDispatcher("login.jsp").forward(request, response);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}
}
