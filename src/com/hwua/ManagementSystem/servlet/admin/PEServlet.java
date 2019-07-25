package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.T_sportstu;
import com.hwua.ManagementSystem.service.SportstuService;
import com.hwua.ManagementSystem.service.StudentService;
import com.hwua.ManagementSystem.service.impl.SportstuServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;

@WebServlet("/sportstu")
public class PEServlet  extends HttpServlet{
	
	private SportstuService  sportstuService;
	private StudentService   studentservice;
	
	public PEServlet() {
		sportstuService=new SportstuServiceImpl();
		studentservice=new StudentServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//学生选修体育课
		String stuid=request.getParameter("id");
		String sportsid=request.getParameter("sportsid");
		if(stuid!=null || stuid.equals("") ||sportsid!=null || sportsid.equals("")){
			T_sportstu sportstu=new T_sportstu();
			sportstu.setStuId(stuid);
			sportstu.setUn_ID(sportsid);
			sportstu.setSportStu_ID(CommonUtil.getUUID());
			 int  row=sportstuService.create(sportstu);
			  if(row>0){
				  
				  List<Student> finBysportsCourse = studentservice.finBysportsCourse(sportstu.getStuId());
				 request.setAttribute("finBysportsCourse", finBysportsCourse);
				  request.setAttribute("message", "选修成功，可查看当前体育选修课，请勿重复选修"); 
				  request.getRequestDispatcher("Student.jsp").forward(request, response);
			      }else{
				  request.setAttribute("message", "选课失败");
				  request.getRequestDispatcher("Student.jsp").forward(request, response);
				  }
		}		
}
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
	
	
}
