package com.hwua.ManagementSystem.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.ManagementSystem.service.UserService;
import com.hwua.ManagementSystem.service.impl.UserServiceImpl;

@WebServlet("/Adminregistered")

public class AdminRegistered  extends HttpServlet{
	
	private UserService userService;
	
	public AdminRegistered() {
		userService = new UserServiceImpl();
	}
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	String mobile=request.getParameter("mobile");
    	String sex=request.getParameter("sex");
    	
    	Map<String, Object> resultMap = userService.userRegister(username, password, mobile, sex);
    	if((Boolean)resultMap.get("ok")){
    		request.setAttribute("message", resultMap.get("message"));
    		request.setAttribute("message", "<h4>×¢²á³É¹¦<a href='admin_login.jsp'>µã»÷µÇÂ¼</a></h4>");
    		 request.getRequestDispatcher("Admin_edit.jsp").forward(request, response);	
    		/*request.getRequestDispatcher("admin_login.jsp").forward(request, response);		*/
    	}
    	else{
			//×¢²áÊ§°Ü¾ÍÌø»ØµÇÂ¼Ò³Ãæ£¬¼ÌÐøµÇÂ¼
			request.setAttribute("error", resultMap.get("error"));
		  request.getRequestDispatcher("Admin_edit.jsp").forward(request, response);	
		}
    	
    	
    	
    }
     
     
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
