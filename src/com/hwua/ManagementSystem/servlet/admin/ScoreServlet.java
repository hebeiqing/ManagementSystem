package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Score;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.service.CourseService;
import com.hwua.ManagementSystem.service.ScoreService;
import com.hwua.ManagementSystem.service.StudentService;
import com.hwua.ManagementSystem.service.impl.CourseServiceImpl;
import com.hwua.ManagementSystem.service.impl.ScoreServiceImpl;
import com.hwua.ManagementSystem.service.impl.StudentServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;

@WebServlet("/admin/score")
public class ScoreServlet  extends HttpServlet{
	
	private ScoreService scoreService;
	private CourseService courseService;
	private StudentService   studentservice;
	
	public ScoreServlet() {
		scoreService=new ScoreServiceImpl();
		courseService=new CourseServiceImpl();	
		studentservice=new StudentServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String act=request.getParameter("act");
		int row;
		Score score=null;
		switch (act) {
		case "list":
			
			List<Score> list = scoreService.findAll();
			request.setAttribute("score", list);
			request.getRequestDispatcher("score_list.jsp").forward(request, response);
			break;
		case "edit":
			String id=request.getParameter("id");
			if(id!=null){
  				 score=scoreService.findById(id);

  					 
				}
				else{
				score=new Score();
				List<Course> couse = courseService.findAll();	
				 List<Student> student = studentservice.findAll();
			    request.setAttribute("course", couse);				
			     request.setAttribute("student", student);
				  request.getRequestDispatcher("score_edit.jsp").forward(request, response);
				}
			   
			     List<Course> couse = courseService.findAll();	
			     request.setAttribute("course", couse);
				request.setAttribute("idscore", score);
				request.getRequestDispatcher("score_edit.jsp").forward(request, response);
			
			
			break;
		case "save":
			String crid=request.getParameter("id");
			String stuid=request.getParameter("stuid");
			String corseid=request.getParameter("corseid");
			String sc=request.getParameter("score");
			String updateid=request.getParameter("updateid");
			if(crid==null || crid.equals("")){
				score=new Score();
				score.setScoreID(CommonUtil.getUUID());
				score.setStuId(stuid);
				score.setScore(sc);
				score.setCourseID(corseid);
				row=scoreService.create(score);
				if(row>0){
	 			response.sendRedirect("score?act=list"); 
	 			  }else{
	 			request.setAttribute("error", "Ìí¼Ó³É¼¨Ê§°Ü");
	 			request.getRequestDispatcher("score_edit.jsp").forward(request, response);
	 			  }
			}
		else{
			score=new Score();
			score.setScoreID(crid);
			score.setCourseID(corseid);
			score.setScore(sc);
			score.setStuId(updateid);
			row=scoreService.update(score);
			if(row>0){
		 	response.sendRedirect("score?act=list"); 
		 	}else{
		 	request.setAttribute("error", "ÐÞ¸Ä³É¼¨Ê§°Ü");
		 	request.getRequestDispatcher("score_edit.jsp").forward(request, response);
		 	}
			}
			
			
			
			break;
		case "delect":
			String deid=request.getParameter("id");
			 row=scoreService.delete(deid);
			 if(row>0){
 				  response.sendRedirect("score?act=list"); 
 			  }else{
 				  request.setAttribute("error", "É¾³ý³É¼¨Ê§°Ü");
 				  request.getRequestDispatcher("score_edit.jsp").forward(request, response);
 			  }
			break;
		
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
