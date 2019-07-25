package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.entity.T_sportstu;
import com.hwua.ManagementSystem.service.SportstuService;
import com.hwua.ManagementSystem.service.StudentService;
import com.hwua.ManagementSystem.service.StudentUnionservice;
import com.hwua.ManagementSystem.service.impl.SportstuServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentUnionServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;

@WebServlet("/admin/Sportstu")
public class T_sportstuServlet extends HttpServlet {
	
	private SportstuService  sportstuService;
	private StudentService   studentservice;
	private StudentUnionservice studentUnionservice;
	public T_sportstuServlet() {
		sportstuService=new SportstuServiceImpl();
		 studentservice=new StudentServiceImpl();
		 studentUnionservice=new StudentUnionServiceImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		T_sportstu sportstu=null;
		int row;
		switch (act) {
		case "list":
			List<T_sportstu> findAll = sportstuService.findAll();
			request.setAttribute("sportstuall",findAll );
			request.getRequestDispatcher("sportstu_list.jsp").forward(request, response);
			break;
			
			case "edit":
				String id=request.getParameter("id");
				if(id!=null){
					sportstu=sportstuService.findById(id);	
				}
				else{
					sportstu=new T_sportstu();
					List<Student> student = studentservice.findAll();
					List<StudentUnion> unin = studentUnionservice.findAll();
					request.setAttribute("student", student);
					request.setAttribute("unin", unin);
				}
				List<StudentUnion> unin = studentUnionservice.findAll();
				request.setAttribute("unin", unin);
				request.setAttribute("idstuun", sportstu);
				request.getRequestDispatcher("sportstu_eait.jsp").forward(request, response);
				break;
			case "save":
				String crid=request.getParameter("id");
				String unid=request.getParameter("unid");
				String Stuid=request.getParameter("stuid");
				if(crid==null || crid.equals("")){
					sportstu=new T_sportstu();
					sportstu.setSportStu_ID(CommonUtil.getUUID());
					sportstu.setStuId(Stuid);
					sportstu.setUn_ID(unid);
					row=sportstuService.create(sportstu);
					if(row>0){
				    response.sendRedirect("Sportstu?act=list");  //添加成功则刷新页面
							 
				    }else{
					  request.setAttribute("error", "添加学生选修课失败");
					 request.getRequestDispatcher("Sportstu?act=edit").forward(request, response);
				}	
				}
				else{
					sportstu=new T_sportstu();
					sportstu.setStuId(crid);
					sportstu.setUn_ID(unid);
					row=sportstuService.update(sportstu);
					if(row>0){
					 response.sendRedirect("Sportstu?act=list");  //添加成功则刷新页面
								 
					  }else{
					request.setAttribute("error", "修改失败");
					request.getRequestDispatcher("Sportstu?act=edit").forward(request, response);
					}
				}
				
				break;
				
			case "delete":
				String deid=request.getParameter("id");
				row=sportstuService.delete(deid);
				if(row>0){
				 response.sendRedirect("Sportstu?act=list");  //添加成功则刷新页面
					 
				}else{
			     request.setAttribute("error", "删除失败");
			     request.getRequestDispatcher("Sportstu?act=edit").forward(request, response);
				}	
				break;
			
		}
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
