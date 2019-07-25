package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.entity.t_tealass;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.service.CourseService;
import com.hwua.ManagementSystem.service.MajorService;
import com.hwua.ManagementSystem.service.TeacherService;
import com.hwua.ManagementSystem.service.t_tealassService;
import com.hwua.ManagementSystem.service.tb_ClassService;
import com.hwua.ManagementSystem.service.impl.CourseServiceImpl;
import com.hwua.ManagementSystem.service.impl.MajorServiceImpl;
import com.hwua.ManagementSystem.service.impl.TeacherServiceImpl;
import com.hwua.ManagementSystem.service.impl.t_tealassServiceImpl;
import com.hwua.ManagementSystem.service.impl.tb_ClassServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;
@WebServlet("/admin/tealass")
public class T_tealassServlet  extends HttpServlet{
	private MajorService majorService;
	 private t_tealassService  classService;
	 private TeacherService teacherService;
	 private tb_ClassService tb_ClassService;
	 private CourseService courseService;
public T_tealassServlet() {
	classService=new t_tealassServiceImpl();
	teacherService=new TeacherServiceImpl();
	tb_ClassService=new tb_ClassServiceImpl();
	courseService=new CourseServiceImpl();	
	majorService=new MajorServiceImpl();
}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		t_tealass t_tealass=null;
		int row;
		switch (act) {
		case "list":
			
			List<t_tealass> findAll = classService.findAll();   
			request.setAttribute("teacherclass", findAll);
			request.getRequestDispatcher("teacherclass.jsp").forward(request, response);
			break;
			
            case "edit":
            	 String id=request.getParameter("id");
            	 if(id!=null){
            		 t_tealass=classService.findById(id);
            	 }
            	 else{
            		 t_tealass=new t_tealass(); 
            		 List<Teacher> teacher = teacherService.findAll();
            		 List<tb_Class> teclass = tb_ClassService.findAll();
            		 List<Course> couse = courseService.findAll();
            		 request.setAttribute("teacher", teacher);
            		 request.setAttribute("teclass", teclass);
            		 request.setAttribute("couse", couse);
            		 request.getRequestDispatcher("teacherclasseait.jsp").forward(request, response);
            	 }
            	 List<Teacher> teacher = teacherService.findAll();
        		 List<tb_Class> teclass = tb_ClassService.findAll();
        		 List<Course> couse = courseService.findAll();
        		 request.setAttribute("teacher", teacher);
        		 request.setAttribute("teclass", teclass);
        		 request.setAttribute("couse", couse);
            	 request.setAttribute("idteacherclass",  t_tealass);
            	 request.getRequestDispatcher("teacherclasseait.jsp").forward(request, response);
            break;
            
            case "save":
            	String crid=request.getParameter("id");
            	String classid=request.getParameter("classid");
            	String courseid=request.getParameter("courseid");
            	String teacherid=request.getParameter("teacherid");
            	if(crid==null || crid.equals("")){
            		t_tealass=new t_tealass();
            		t_tealass.setTealass_ID(CommonUtil.getUUID());
            		t_tealass.setClassId(classid);
            		t_tealass.setCourseID(courseid);
            		t_tealass.setTeacherId(teacherid);
            		row=classService.create(t_tealass);
            		if(row>0){
        	 	   response.sendRedirect("tealass?act=list"); 
        	 	    }else{
        	 		request.setAttribute("error", "Ñ¡¿ÎÊ§°Ü");
        	 		request.getRequestDispatcher("teacherclasseait.jsp").forward(request, response);
        	 	   }
            		
            	}
            	else{
            		t_tealass=new t_tealass();
            		t_tealass.setTealass_ID(crid);
            		t_tealass.setClassId(classid);
            		t_tealass.setCourseID(courseid);
            		t_tealass.setTeacherId(teacherid);
            		row=classService.update(t_tealass);
            		if(row>0){
        	 	   response.sendRedirect("tealass?act=list"); 
        	 	    }else{
        	 		request.setAttribute("error", "ÐÞ¸ÄÑ¡¿ÎÊ§°Ü");
        	 		request.getRequestDispatcher("teacherclasseait.jsp").forward(request, response);
        	 	   }
            		
            	}
            	
            break;
            
            case "delect":
            	String deid=request.getParameter("id");
            	row=classService.delete(deid);
            	if(row>0){
         	 	 response.sendRedirect("tealass?act=list"); 
         	 	  }else{
         	    request.setAttribute("error", "É¾³ýÊ§°Ü");
         	    request.getRequestDispatcher("teacherclasseait.jsp").forward(request, response);
         	 	  }
             break;
            	
		
		}
		
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
