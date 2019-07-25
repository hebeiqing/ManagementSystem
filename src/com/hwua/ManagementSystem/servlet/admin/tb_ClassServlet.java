package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.service.CourseService;
import com.hwua.ManagementSystem.service.DepartmentService;
import com.hwua.ManagementSystem.service.MajorService;
import com.hwua.ManagementSystem.service.tb_ClassService;
import com.hwua.ManagementSystem.service.impl.CourseServiceImpl;
import com.hwua.ManagementSystem.service.impl.DepartmentServiceImpl;
import com.hwua.ManagementSystem.service.impl.MajorServiceImpl;
import com.hwua.ManagementSystem.service.impl.tb_ClassServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;
@WebServlet("/admin/classmg")
public class tb_ClassServlet  extends HttpServlet{
	private tb_ClassService tb_ClassService;
	private DepartmentService departmentService;
	private CourseService courseService;
	private MajorService majorService;
	public tb_ClassServlet() {
		tb_ClassService=new tb_ClassServiceImpl();
		departmentService=new DepartmentServiceImpl();
		courseService=new CourseServiceImpl();	
		majorService=new MajorServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		tb_Class tbclass=null;
		tb_Class classmg=null;
		int row;
		switch (act) {
		   case "list":
			   List<tb_Class> list = tb_ClassService.findAll();
			   request.setAttribute("tb_class", list);
			   request.getRequestDispatcher("Class_list.jsp").forward(request, response);
			break;
			case "edit":
				String id=request.getParameter("id");
				if(id!=null){
					classmg= tb_ClassService.findById(id);	
					
				}
				else{
					tbclass=new tb_Class();
					List<Department> f1 = departmentService.findAll();
					//根据部门id查询专业
					List<Major> findAllmajor = tb_ClassService.findAllmajor("c5c1e6e8737348df9279e9cee9526fc6");
					//List<Major> f2 = majorService.findAll();
					//request.setAttribute("ff", f2);
					request.getRequestDispatcher("Class_eait.jsp").forward(request,response);
				}
				List<Department> f1 = departmentService.findAll();
				//List<Major> f2 = majorService.findAll();
				
				request.setAttribute("f", f1);
				//request.setAttribute("ff", f2);
				request.setAttribute("idmsg", classmg);
				request.getRequestDispatcher("Class_eait.jsp").forward(request,response);
			break;
			case "save":
				String crid=request.getParameter("id");
				String name=request.getParameter("name");
				String num=request.getParameter("num");
				String maid=request.getParameter("city");
				String dpid=request.getParameter("province");
			/*	String courseid=request.getParameter("courseid");*/
				if(crid==null || crid.equals("")){
					tbclass=new tb_Class();
					tbclass.setClassId(CommonUtil.getUUID());
					tbclass.setClass_name(name);
					tbclass.setNum(num);
					tbclass.setMaid(maid);
					tbclass.setDepartmentID(dpid);
					/*tbclass.setCourseID(courseid);*/
					row=tb_ClassService.create(tbclass);
					if(row>0){
				 response.sendRedirect("classmg?act=list");  //添加成功则刷新页面
						 
				  }else{
				 request.setAttribute("error", "创建班级失败");
				 request.getRequestDispatcher("classmg?act=edit").forward(request, response);
				}
				}
				else{
					tbclass=new tb_Class();
					tbclass.setClassId(crid);
					tbclass.setClass_name(name);
					tbclass.setNum(num);
					tbclass.setMaid(maid);
					tbclass.setDepartmentID(dpid);
				/*	tbclass.setCourseID(courseid);*/
					row=tb_ClassService.update(tbclass);
					if(row>0){
					 response.sendRedirect("classmg?act=list");  //添加成功则刷新页面
								 
					 }else{
					 request.setAttribute("error", "修改班级失败");
				     request.getRequestDispatcher("classmg?act=edit").forward(request, response);
				}
				}
			break;
			case "delect":
				String deid=request.getParameter("id");
				row=tb_ClassService.delete(deid);
				if(row>0){
				 response.sendRedirect("classmg?act=list");  //添加成功则刷新页面
								 
				}else{
				request.setAttribute("error", "删除班级失败");
				request.getRequestDispatcher("classmg?act=edit").forward(request, response);
				}
	
	         break;
		}
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
