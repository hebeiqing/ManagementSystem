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
				
			//����userService�ķ���
			Map<String, Object> resultMap = userService.teacherLogin(name, password);
			if((Boolean)resultMap.get("ok")){
				//��¼�ɹ��ͱ������Ա����session�У�����ת����̨������ҳ
				HttpSession session = request.getSession();
				session.setAttribute("loginteacher", resultMap.get("loginTeacher"));
				session.setAttribute("Teachercourse", resultMap.get("Teachercourse"));
				session.setAttribute("TeacherStudent", resultMap.get("TeacherStudent"));
				/*session.setAttribute("findByscore", resultMap.get("findByscore"));*/
				//��ת����̨������ҳ
				response.sendRedirect(request.getContextPath()+"/Teachers/main.jsp");  //��ʦ����ҳ��
			}else{
				//��¼ʧ�ܾ����ص�¼ҳ�棬������¼
				request.setAttribute("error", resultMap.get("error"));
				//request.getRequestDispatcher("admin_login.jsp").forward(request, response);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		  
		
	}

}
