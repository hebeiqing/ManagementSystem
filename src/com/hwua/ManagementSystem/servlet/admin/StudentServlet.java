package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.entity.T_sportstu;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.service.CourseService;
import com.hwua.ManagementSystem.service.DepartmentService;
import com.hwua.ManagementSystem.service.MajorService;
import com.hwua.ManagementSystem.service.SportstuService;
import com.hwua.ManagementSystem.service.StudentService;
import com.hwua.ManagementSystem.service.StudentUnionservice;
import com.hwua.ManagementSystem.service.tb_ClassService;
import com.hwua.ManagementSystem.service.impl.CourseServiceImpl;
import com.hwua.ManagementSystem.service.impl.DepartmentServiceImpl;
import com.hwua.ManagementSystem.service.impl.MajorServiceImpl;
import com.hwua.ManagementSystem.service.impl.SportstuServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentUnionServiceImpl;
import com.hwua.ManagementSystem.service.impl.tb_ClassServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;

@WebServlet("/admin/student")
public class StudentServlet extends HttpServlet {
	
	private SportstuService  sportstuService;
	private StudentService   studentservice;
	private tb_ClassService tb_ClassService;
	private DepartmentService departmentService;
	private CourseService courseService;
	private MajorService majorService;
	private StudentUnionservice studentUnionservice;
	
	public StudentServlet() {
		     studentservice=new StudentServiceImpl();
		     tb_ClassService=new tb_ClassServiceImpl();
			departmentService=new DepartmentServiceImpl();
			courseService=new CourseServiceImpl();	
			majorService=new MajorServiceImpl();
			studentUnionservice=new StudentUnionServiceImpl();
			sportstuService=new SportstuServiceImpl();
		     
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act=request.getParameter("act");
		int row;
		Student student=null;
		
		switch (act) {
		case "list":
			     List<Student> list = studentservice.findAll();
			     request.setAttribute("student", list);
			     request.getRequestDispatcher("Student_list.jsp").forward(request, response);
			break;

		case "edit":
			String id=request.getParameter("id");
			if(id!=null){
				student=studentservice.findById(id);	
			}
			else{
				student=new Student();	
				List<Department> f1 = departmentService.findAll();
				List<Major> f2 = majorService.findAll();
				List<Course> f3 = courseService.findAll();
				 List<tb_Class> f4 = tb_ClassService.findAll();
				 List<StudentUnion> f5= studentUnionservice.findAll();
				request.setAttribute("f", f1);
				request.setAttribute("ff", f2);
				request.setAttribute("fff", f3);
				request.setAttribute("ffff", f4);
				request.setAttribute("StudentUnion", f5);
				request.getRequestDispatcher("Student_edit.jsp").forward(request, response);
			}
			List<Department> f1 = departmentService.findAll();
			List<Major> f2 = majorService.findAll();
			List<Course> f3 = courseService.findAll();
			 List<tb_Class> f4 = tb_ClassService.findAll();
			 List<StudentUnion> f5= studentUnionservice.findAll();
			request.setAttribute("f", f1);
			request.setAttribute("ff", f2);
			request.setAttribute("fff", f3);
			request.setAttribute("ffff", f4);
			request.setAttribute("StudentUnion", f5);
			request.setAttribute("idstudent", student);
			request.getRequestDispatcher("Student_edit.jsp").forward(request, response);
			break;
		case "save":
			String crid=request.getParameter("id");
        	String name=request.getParameter("name");
        	String password=request.getParameter("password");
        	String sex=request.getParameter("sex");
        	String date=request.getParameter("birthDate");
        	String entranceTime=request.getParameter("entranceTime");
        	String natives=request.getParameter("natives");
        	String politicalFace=request.getParameter("politicalFace");
        	String perPhone=request.getParameter("perPhone");
        	String IDNum=request.getParameter("IDNum");
        	String address=request.getParameter("address");
        	String national=request.getParameter("national");
     
        	String dpid=request.getParameter("dpid");
        	String maid=request.getParameter("maid");
        	String classid=request.getParameter("classid");
        	String unid=request.getParameter("unid");
        	String courseid=request.getParameter("courseid");
        	if(crid==null || crid.equals("")){
        		student=new Student();
        		student.setStuId(CommonUtil.getUUID());
        		student.setStuName(name);
        		student.setPassword(password);
        		student.setSex(sex);
        		student.setBirthDate(date);
        		student.setEntranceTime(entranceTime);
        		student.setNatives(natives);
        		student.setPoliticalFace(politicalFace);
        		student.setPerPhone(perPhone);
        		student.setIDNum(IDNum);
        		student.setAddress(address);
        		student.setNational(national);
        		student.setDepartmentID(dpid);
        		student.setMaid(maid);
        		student.setClassId(classid);
        		student.setUn_ID(unid);
        		student.setCourseID(courseid);
        		row=studentservice.create(student);
        		if(row>0){
       			 response.sendRedirect("student?act=list"); 
       			  }else{
       			 request.setAttribute("error", "添加学生失败");
       			  request.getRequestDispatcher("Student_edit.jsp").forward(request, response);
       			  }
        	}
        	else{
        		student=new Student();
        		student.setStuId(crid);
        		student.setStuName(name);
        		student.setPassword(password);
        		student.setSex(sex);
        		student.setBirthDate(date);
        		student.setEntranceTime(entranceTime);
        		student.setNatives(natives);
        		student.setPoliticalFace(politicalFace);
        		student.setPerPhone(perPhone);
        		student.setIDNum(IDNum);
        		student.setAddress(address);
        		student.setNational(national);
        		student.setDepartmentID(dpid);
        		student.setMaid(maid);
        		student.setClassId(classid);
        		student.setUn_ID(unid);
        		student.setCourseID(courseid);
        		row=studentservice.update(student);
        		if(row>0){
          		response.sendRedirect("student?act=list"); 
          		}else{
          		request.setAttribute("error", "修改学生失败");
          	 request.getRequestDispatcher("Student_edit.jsp").forward(request, response);
          	  }
        	}
        	
        	
			break;
		case "delete":
			String deid=request.getParameter("id");
			row=studentservice.delete(deid);
			if(row>0){
			 response.sendRedirect("student?act=list"); 
			  }else{
			 request.setAttribute("error", "删除学生失败失败");
			  request.getRequestDispatcher("Student_list.jsp").forward(request, response);
			  }
	
	        break;
		}
		
		
	}
	
	
	
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
}
	

}
