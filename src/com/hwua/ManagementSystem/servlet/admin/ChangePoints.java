package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.entity.Score;
import com.hwua.ManagementSystem.service.ScoreService;
import com.hwua.ManagementSystem.service.TeacherService;
import com.hwua.ManagementSystem.service.impl.ScoreServiceImpl;
import com.hwua.ManagementSystem.service.impl.TeacherServiceImpl;
import com.hwua.ManagementSystem.util.CommonUtil;

@WebServlet("/ChangePoints")
public class ChangePoints  extends HttpServlet{
	private ScoreService scoreService;
	 private TeacherService teacherService;
	public ChangePoints() {
		 teacherService=new TeacherServiceImpl();
		 scoreService=new ScoreServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				String score=request.getParameter("score");
				String Stuid=request.getParameter("Stuid");
				String Coure=request.getParameter("courseid");
	          
				if(score!=null || Stuid!=null || Coure!=null){
					Score score2=new Score();
					score2.setScoreID(CommonUtil.getUUID());
					score2.setScore(score);
					score2.setStuId(Stuid);
					score2.setCourseID(Coure);
					int row =scoreService.create(score2);
					if(row>0){		
			     
			 response.sendRedirect("Teacher.jsp");  //教师管理页面
				   }else{
				   request.setAttribute("error", "添加成绩失败");
				   response.sendRedirect(request.getContextPath()+"/Teacher.jsp");  //教师管理页面
				    }
				    }
				
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
