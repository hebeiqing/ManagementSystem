package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Score;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.service.DepartmentService;
import com.hwua.ManagementSystem.service.ScoreService;
import com.hwua.ManagementSystem.service.TeacherService;
import com.hwua.ManagementSystem.service.impl.DepartmentServiceImpl;
import com.hwua.ManagementSystem.service.impl.ScoreServiceImpl;
import com.hwua.ManagementSystem.service.impl.TeacherServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;
import com.mysql.fabric.xmlrpc.base.Data;

@WebServlet("/admin/Teacher")
public class TeacherServlet  extends HttpServlet{
	private ScoreService scoreService;
	  private TeacherService teacherService;
	  private DepartmentService departmentService;
	  public TeacherServlet() {
		  teacherService=new TeacherServiceImpl();
		  departmentService=new DepartmentServiceImpl();
		  scoreService=new ScoreServiceImpl();
	}
	
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
	  Teacher teacher=null;
	  int row;
		switch (act) {
		case "list":
			List<Teacher> list = teacherService.findAll();
			request.setAttribute("Teacher", list);
			request.getRequestDispatcher("Teacher_list.jsp").forward(request, response);
			break;
		case "edit":
			String id=request.getParameter("id");
			if(id!=null){
		  teacher=teacherService.findById(id);
			}
			else{
				teacher=new Teacher();
				List<Department> department = departmentService.findAll();
				request.setAttribute("department", department);
				request.getRequestDispatcher("teacher_edit.jsp").forward(request,response);
				
			}
			List<Department> department = departmentService.findAll();
			request.setAttribute("department", department);
			request.setAttribute("teacherid", teacher);
			request.getRequestDispatcher("teacher_edit.jsp").forward(request,response);
			
			break;
        case "save":
        	String crid=request.getParameter("id");
        	String name=request.getParameter("name");
        	String passsword=request.getParameter("password");
        	String date=request.getParameter("date");
        	String face=request.getParameter("face");
        	String natives=request.getParameter("natives");
        	String phone=request.getParameter("phone");
        	String idnum=request.getParameter("idnum");
        	String intime=request.getParameter("intime");
        	String highe=request.getParameter("highe");
        	String position=request.getParameter("position");
        	/*String photo=request.getParameter("photo");*/
        	String national=request.getParameter("national");
        	String depid=request.getParameter("depid");
        	String sex=request.getParameter("sex");
        	if(crid==null || crid.equals("")){
        		teacher=new Teacher();
        		teacher.setTeacherId(CommonUtil.getUUID());
        		teacher.setTeacherName(name);
        		teacher.setPassword(passsword);
        		teacher.setSex(sex);
        		teacher.setBirthDate(date);
        		teacher.setPoliticaFace(face);
        		teacher.setNatives(natives);
        		teacher.setTePhone(phone);
        		teacher.setIDNum(idnum);
        		teacher.setAdmissionTime(intime);
        		teacher.setHighesDegree(highe);
        		teacher.setPosition(position);
        		teacher.setPhoto("无");
        		teacher.setNational(national);  		
        		teacher.setDepartmentID(depid);
        		int create = teacherService.create(teacher);
        		if(create>0){
  				  response.sendRedirect("Teacher?act=list"); 
  			  }else{
  				  request.setAttribute("error", "添加老师失败");
  				  request.getRequestDispatcher("major_list.jsp").forward(request, response);
  			  }
        	}
        	else{
        		String upid=request.getParameter("id");
        		String dpid=request.getParameter("depart");
        		teacher=teacherService.findById(upid);
        		teacher.setTeacherId(upid);
        		teacher.setTeacherName(name);
        		teacher.setPassword(passsword);
        		teacher.setSex(sex);
        		teacher.setBirthDate(date);
        		teacher.setPoliticaFace(face);
        		teacher.setNatives(natives);
        		teacher.setTePhone(phone);
        		teacher.setIDNum(idnum);
        		teacher.setAdmissionTime(intime);
        		teacher.setHighesDegree(highe);
        		teacher.setPosition(position);
        		teacher.setPhoto("无");
        		teacher.setNational(national); 
        		if(depid!=null || dpid.equals("")){
        			teacher.setDepartmentID(depid);
        		}
        		else{
        			teacher.setDepartmentID(dpid);
        		}
        		
        		row=teacherService.update(teacher);
        		if(row>0){
    				  response.sendRedirect("Teacher?act=list"); 
    			  }else{
    				  request.setAttribute("error", "修改老师失败");
    				  request.getRequestDispatcher("major_list.jsp").forward(request, response);
    			  }
        	}
        	
		    
			break;
		case "delect":
			String deid=request.getParameter("id");
			 row=teacherService.delete(deid);
			  if(row>0){
				  response.sendRedirect("Teacher?act=list"); 
			  }else{
				  request.setAttribute("error", "删除老师失败");
				  request.getRequestDispatcher("major_list.jsp").forward(request, response);
			  }
			
			break;
		}	
		}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
