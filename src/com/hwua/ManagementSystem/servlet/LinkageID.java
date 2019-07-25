package com.hwua.ManagementSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.service.tb_ClassService;
import com.hwua.ManagementSystem.service.impl.tb_ClassServiceImpl;
@WebServlet("/texts")
public class LinkageID extends HttpServlet {
	private tb_ClassService tb_ClassService;
	
	public LinkageID() {
		tb_ClassService=new tb_ClassServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("pid");
		String classid=request.getParameter("classid");
		if(classid==null || classid.equals("")){
			List<Major> findAllmajor = tb_ClassService.findAllmajor(id);
			String json=JSON.toJSONString(findAllmajor);
			response.getWriter().println(json);
		}  
		else {
			List<Major> findAllmajor = tb_ClassService.findAllmajor(id);
			String json=JSON.toJSONString(findAllmajor);
			response.getWriter().println(json);
			List<tb_Class> findAllclass = tb_ClassService.findAllclass(classid);
			
			String classjson=JSON.toJSONString(findAllclass);
			response.getWriter().println(classjson);
		}
	}
	
	
	
	
	
}
