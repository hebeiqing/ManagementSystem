package com.hwua.ManagementSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.service.StudentService;
import com.hwua.ManagementSystem.service.impl.StudentServiceImpl;
@WebServlet("/teacherclass")
public class LinkageClass  extends HttpServlet{
	private StudentService studentService;
	
	public LinkageClass() {
		studentService=new StudentServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("pid");
			List<Student> finByStudenCourse = studentService.finBymaidCourse(id);
			String IDstuden=JSON.toJSONString(finByStudenCourse);
			response.getWriter().println(IDstuden);
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
