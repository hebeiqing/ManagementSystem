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


@WebServlet("/teacherlogin")
public class teacherLoginServlet extends HttpServlet{
	
private UserService userService;

	public teacherLoginServlet() {
		userService = new UserServiceImpl();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String name=request.getParameter("teacharname");
		  String password=request.getParameter("teacharpassword");
				
			//调用userService的方法
			Map<String, Object> resultMap = userService.teacherLogin(name, password);
			if((Boolean)resultMap.get("ok")){
				//登录成功就保存管理员对象到session中，并跳转到后台管理首页
				HttpSession session = request.getSession();
				session.setAttribute("loginteacher", resultMap.get("loginTeacher"));
				session.setAttribute("Teachercourse", resultMap.get("Teachercourse"));
				session.setAttribute("TeacherStudent", resultMap.get("TeacherStudent"));
				/*session.setAttribute("findByscore", resultMap.get("findByscore"));*/
				//跳转到后台管理首页
				response.sendRedirect(request.getContextPath()+"/Teachers/main.jsp");  //教师管理页面
			}else{
				//登录失败就跳回登录页面，继续登录
				request.setAttribute("error", resultMap.get("error"));
				//request.getRequestDispatcher("admin_login.jsp").forward(request, response);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		  
		
	}

}
