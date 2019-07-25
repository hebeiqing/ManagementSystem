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
		//��ҳ����յ��û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//����userService�ķ���
		Map<String, Object> resultMap = userService.adminLogin(username, password);
		if((Boolean)resultMap.get("ok")){
			//��¼�ɹ��ͱ������Ա����session�У�����ת����̨������ҳ
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", resultMap.get("loginAdmin"));
			//��ת����̨������ҳ
			//response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
			response.sendRedirect(request.getContextPath()+ "/Match/main.jsp");
		}else{
			//��¼ʧ�ܾ����ص�¼ҳ�棬������¼
			request.setAttribute("error", resultMap.get("error"));
			//request.getRequestDispatcher("admin_login.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}
}
