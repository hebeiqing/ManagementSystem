package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.dao.impl.MajorDaoImpl;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.service.DepartmentService;
import com.hwua.ManagementSystem.service.MajorService;
import com.hwua.ManagementSystem.service.impl.DepartmentServiceImpl;
import com.hwua.ManagementSystem.service.impl.MajorServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;
/*
 * 专业类别
 * 
 * */
@WebServlet("/admin/major")

public class MajorServlet  extends HttpServlet{
	
	private MajorService majorService;
	private DepartmentService departmentService;
	public MajorServlet() {
		majorService=new MajorServiceImpl();
		departmentService=new DepartmentServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String act=request.getParameter("act");	
		Major major=null;
		 int row;
		switch (act) {
		case "list":
			  List<Major> list = majorService.findAll();  //查看所有专业		
				List<Department> dp = departmentService.findAll();
				request.setAttribute("list", list);	
				request.setAttribute("dp", dp);
				request.getRequestDispatcher("major_list.jsp").forward(request, response);			
			break;
			
		case "edit":
			String upid=request.getParameter("id");
			if(upid!=null){
				major=  majorService.findById(upid);
			}
			else{
				major=new Major();
				List<Department> department = departmentService.findAll();
				request.setAttribute("departmentlist", department);
			   request.getRequestDispatcher("Majorcreat.jsp").forward(request, response);
				
			}
			List<Department> department = departmentService.findAll();
			request.setAttribute("departmentlist", department);
			request.setAttribute("major", major);
			request.getRequestDispatcher("Majorcreat.jsp").forward(request, response);
			break;	
		case "save":
			//添加专业	
			String id=request.getParameter("id");
			String major_name=request.getParameter("maname");
			String dpid=request.getParameter("dpid");
	  if(id==null || id.equals("")){
			 major=new Major();
			 major.setMaid(CommonUtil.getUUID());
			 major.setMajor_name(major_name);
			 major.setDepartmentID(dpid);//选择添加专业的id
			row=majorService.create(major);
		if(row>0){
				 response.sendRedirect("major?act=list");  //添加成功则刷新页面
				 
				 }else{
				  request.setAttribute("error", "创建专业失败");
				   request.getRequestDispatcher("major?act=edit").forward(request, response);
				 }	
				}
		else{
				major=new Major();
				major.setDepartmentID(dpid);
				major.setMajor_name(major_name);
				major.setMaid(id);
				row=majorService.update(major);
				if(row>0){
			       response.sendRedirect("major?act=list");  //添加成功则刷新页面
						 
			 }
			   else{
			     request.setAttribute("error", "修改专业失败");
				 request.getRequestDispatcher("major?act=edit&id"+id).forward(request, response);
				 }			
	       }
			  
		    break;	
		  case "delete":
			String deid=request.getParameter("id");
			  row=majorService.delete(deid);	
			  if(row>0){
				  response.sendRedirect("major?act=list"); 
			  }else{
				  request.setAttribute("error", "删除专业失败");
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
