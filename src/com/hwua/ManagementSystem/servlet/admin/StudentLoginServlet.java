package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.ManagementSystem.dao.Scoredao;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.service.ScoreService;
import com.hwua.ManagementSystem.service.StudentService;
import com.hwua.ManagementSystem.service.StudentUnionservice;
import com.hwua.ManagementSystem.service.UserService;
import com.hwua.ManagementSystem.service.impl.ScoreServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentUnionServiceImpl;
import com.hwua.ManagementSystem.service.impl.UserServiceImpl;


@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet{
	
private UserService userService;
private StudentService studentservice;
private StudentUnionservice  unservice;
private  ScoreService scoreService;

	public StudentLoginServlet() {
		userService = new UserServiceImpl();
		studentservice=new StudentServiceImpl();
		unservice=new StudentUnionServiceImpl();
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String name=request.getParameter("studentname");
		  String password=request.getParameter("studentpassword");
			//����userService�ķ���
			Map<String, Object> resultMap = userService.studnetLogin(name, password);
			List<StudentUnion> union = unservice.findAll();
			if((Boolean)resultMap.get("ok")){
				//��¼�ɹ��ͱ������Ա����session�У�����ת����̨������ҳ
				HttpSession session = request.getSession();
				session.setAttribute("studentlogin", resultMap.get("loginStudent"));
				session.setAttribute("stuidmsg", resultMap.get("stuidmsg"));
				session.setAttribute("course", resultMap.get("finByStudenCourse"));
				session.setAttribute("score", resultMap.get("findByidscore"));
				session.setAttribute("finBysportsCourse", resultMap.get("finBysportsCourse"));
				session.setAttribute("union", union);
				
				//��ת����̨������ҳ
				response.sendRedirect(request.getContextPath()+ "/Studnet/main.jsp");
				//response.sendRedirect("\\Studnet\\main.jsp");  //ѧ������ҳ��
			}else{
				//��¼ʧ�ܾ����ص�¼ҳ�棬������¼
				request.setAttribute("error", resultMap.get("error"));
				//request.getRequestDispatcher("admin_login.jsp").forward(request, response);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
			
			
			
			
		  
		
	}

}
