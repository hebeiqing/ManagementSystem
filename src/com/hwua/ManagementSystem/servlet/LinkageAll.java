package com.hwua.ManagementSystem.servlet;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.service.DepartmentService;
import com.hwua.ManagementSystem.service.StudentService;
import com.hwua.ManagementSystem.service.tb_ClassService;
import com.hwua.ManagementSystem.service.impl.DepartmentServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentServiceImpl;
@WebServlet("/text")
public class LinkageAll  extends HttpServlet{
	private DepartmentService departmentService;
	private StudentService studentService;
	
	public LinkageAll() {
		departmentService=new DepartmentServiceImpl();
		studentService=new StudentServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> findAll = departmentService.findAll();
		String json=JSON.toJSONString(findAll);
		response.getWriter().println(json);	
	}
	
	
	

}
