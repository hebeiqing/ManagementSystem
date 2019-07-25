package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hwua.ManagementSystem.dao.impl.DepartmentdaoImpl;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.service.DepartmentService;
import com.hwua.ManagementSystem.service.impl.DepartmentServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;
@WebServlet("/admin/department")
public class DepartmentServlet  extends HttpServlet{
	
	private DepartmentService departmentService;
	public DepartmentServlet() {
		departmentService=new DepartmentServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String act=request.getParameter("act");
		Department department=null;
		int row;
		switch (act) {
		case "list":
			List<Department> list = departmentService.findAll();
			request.setAttribute("department", list);
			request.getRequestDispatcher("department_list.jsp").forward(request, response);
			//转为json格式
			/*String json=JSON.toJSONString(list);
		//	response.setContentType("application/json; charset=utf-8");
			//response.getWriter().write(json);
*/		request.getRequestDispatcher("department_list.jsp").forward(request, response);
			break;
		case "edit":
			String upid=request.getParameter("id");
			if(upid!=null){
				department=departmentService.findById(upid);//如果id不为空，就是修改，不然就新建一个对象
			}
			else{
				department=new Department();
			}	
			request.setAttribute("deid", department);
			request.getRequestDispatcher("departmentedit.jsp").forward(request, response);
			break;
		case "save":
			String name=request.getParameter("dpname");
			String saveid=request.getParameter("id");
			if(saveid==null || saveid.equals("")){
			department=new Department();
			department.setDepartment_name(name);
			department.setDepartmentID(CommonUtil.getUUID());
			  int rows=departmentService.create(department);
			if(rows>0){
			response.sendRedirect("department?act=list");
			}else{
			request.setAttribute("error", "添加系部失败");
			request.getRequestDispatcher("department?act=edit").forward(request, response);
			}
			}
			else{
				department=departmentService.findById(saveid);
				department.setDepartment_name(name);
				row=departmentService.update(department);
				if(row>0){
				response.sendRedirect("department?act=list");
				}else{
				request.setAttribute("error", "修改系部名称失败");
				request.getRequestDispatcher("department?act=edit").forward(request, response);
				}
			}
		   break;
		case "delete":
			String id=request.getParameter("id");
			row=departmentService.delete(id);
			if(row>0){
			response.sendRedirect("department?act=list");
			}else{
			request.setAttribute("error", "删除失败");
			request.getRequestDispatcher("department_list.jsp").forward(request, response);
			}
			
			break;
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
