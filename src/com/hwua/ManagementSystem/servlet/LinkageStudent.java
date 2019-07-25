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
@WebServlet("/student")
public class LinkageStudent  extends HttpServlet{
	private StudentService studentService;
	
	public LinkageStudent() {
		studentService=new StudentServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("pid");
		if(id==null || id.equals("")){
			List<Student> findAllStudent = studentService.findAll();
			String studen=JSON.toJSONString(findAllStudent);
			response.getWriter().println(studen);
		}
		else{
			List<Student> finByStudenCourse = studentService.finByStudenCourse(id);
			String IDstuden=JSON.toJSONString(finByStudenCourse);
			response.getWriter().println(IDstuden);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
