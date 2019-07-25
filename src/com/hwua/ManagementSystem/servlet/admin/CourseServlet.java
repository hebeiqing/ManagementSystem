package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.service.CourseService;
import com.hwua.ManagementSystem.service.MajorService;
import com.hwua.ManagementSystem.service.impl.CourseServiceImpl;
import com.hwua.ManagementSystem.service.impl.MajorServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;

@WebServlet("/admin/course")
public class CourseServlet extends HttpServlet {
	
	private CourseService courseService;
	private MajorService majorService;
	public CourseServlet() {
		courseService=new CourseServiceImpl();	
		majorService=new MajorServiceImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act=request.getParameter("act");
		Course course=null;
		int row;
		switch (act) {
		case "list":
			List<Course> list = courseService.findAll();	
			request.setAttribute("course", list);
			request.getRequestDispatcher("Course_list.jsp").forward(request, response);
			break;

		case "edit":
			String upid=request.getParameter("id");
			if(upid!=null){
				course=courseService.findById(upid);
			}
			else{
				course=new Course();
				 List<Major> major = majorService.findAll();  //查看所有专业		
				request.setAttribute("major", major);
				request.getRequestDispatcher("Course_edit.jsp").forward(request, response);
			}
			 List<Major> major = majorService.findAll();  //查看所有专业		
			request.setAttribute("major", major);
		    request.setAttribute("editcourse", course);
		    request.getRequestDispatcher("Course_edit.jsp").forward(request, response);
					
			break;
		case "save":
			String id=request.getParameter("id");
			String coursename=request.getParameter("name");
			String creDits=request.getParameter("creDits");
			String maid=request.getParameter("maid");
			if(id==null || id.equals("")){
				course=new Course();
				course.setCourseID(CommonUtil.getUUID());
				course.setCourseName(coursename);
				course.setCreDits(creDits);
				course.setMaid(maid);
				row=courseService.create(course);
				if(row>0){
					response.sendRedirect("course?act=list");
				}
				else{
					request.setAttribute("error", "添加课程失败");
					request.getRequestDispatcher("Course_edit.jsp").forward(request, response);
				}
				
			}
			else{
				course=courseService.findById(id);
				course.setCourseName(coursename); //只能修改课程与学分 
				course.setCreDits(creDits);
				course.setMaid(maid);
				row=courseService.update(course);
				if(row>0){
					response.sendRedirect("course?act=list");
				}
				else{
					request.setAttribute("error", "修改课程失败");
					request.getRequestDispatcher("Course_edit.jsp").forward(request, response);
				}
			}
			
			
			break;
		case "delect":
			String deid=request.getParameter("id");
				row=courseService.delete(deid);
				if(row>0){
					response.sendRedirect("course?act=list");
				}
				else{
					request.setAttribute("error", "删除失败");
					  request.getRequestDispatcher("Course_edit.jsp").forward(request, response);
				}
				
			break;
		}
		
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
