package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.dao.impl.DepartmentdaoImpl;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.service.DepartmentService;
import com.hwua.ManagementSystem.service.StudentUnionservice;
import com.hwua.ManagementSystem.service.impl.DepartmentServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentUnionServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;
@WebServlet("/admin/studentUnion")
public class StudentUnionServlet  extends HttpServlet{
	
	private StudentUnionservice studentUnionservice;
	public StudentUnionServlet() {
		studentUnionservice=new StudentUnionServiceImpl();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String act=request.getParameter("act");
		StudentUnion studentUnion=null;
		int row;
		switch (act) {
		case "list":
			List<StudentUnion> list = studentUnionservice.findAll();
			request.setAttribute("StudentUnion", list);
			request.getRequestDispatcher("studentUnion_list.jsp").forward(request, response);
			break;
		case "edit":
			String upid=request.getParameter("id");
			if(upid!=null){
				studentUnion=studentUnionservice.findById(upid);
			}
			else{
				studentUnion=new StudentUnion();
			}	
			request.setAttribute("Unonid", studentUnion);
			request.getRequestDispatcher("studentUnion_edit.jsp").forward(request, response);
			break;
		case "save":
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			 if(id==null || id.equals("")){
				 studentUnion=new StudentUnion();
				 studentUnion.setUn_ID(CommonUtil.getUUID());
				 studentUnion.setUn_name(name);
			  int rows=studentUnionservice.create(studentUnion);
			if(rows>0){
			response.sendRedirect("studentUnion?act=list");
			}else{
			request.setAttribute("error", "Ìí¼ÓÉçÍÅÊ§°Ü");
			request.getRequestDispatcher("studentUnion?act=edit").forward(request, response);
			}
			  }
			else{
				studentUnion=studentUnionservice.findById(id);
				studentUnion.setUn_name(name);
				row=studentUnionservice.update(studentUnion);
				if(row>0){
				response.sendRedirect("studentUnion?act=list");
				}else{
				request.setAttribute("error", "ÐÞ¸ÄÏµ²¿Ãû³ÆÊ§°Ü");
				request.getRequestDispatcher("studentUnion?act=edit").forward(request, response);
				}
			}
		   break;
		case "delete":
			String deid=request.getParameter("id");
			row=studentUnionservice.delete(deid);
			if(row>0){
			response.sendRedirect("studentUnion?act=list");
			}else{
			request.setAttribute("error", "É¾³ýÊ§°Ü");
			request.getRequestDispatcher("studentUnion_list.jsp").forward(request, response);
			}
			
			break;
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
