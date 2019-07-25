package com.hwua.ManagementSystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录验证过滤器
 */
@WebFilter(urlPatterns={"/admin/*","/admin","/admin/"})
public class AdminLoginValidationFilter implements Filter{

	public void destroy() {
		System.out.println("管理员登录验证过滤器已销毁...");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("管理员登录验证过滤器进行过滤！！！！");
		//把ServletRequest和ServletResponse转换为HttpServletRequest和HttpServletResponse
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//通过request获取session
		HttpSession session = request.getSession();
		//判断session中是否保存有登录管理员信息
		if(session.getAttribute("loginAdmin")!=null){
			//如果登录管理员信息，则正常访问原来要访问的资源
			chain.doFilter(request, response);
		}else{
			//如果没有登录管理员信息，则跳转到管理员登录页面
			response.sendRedirect(request.getContextPath()+"/Match/login.jsp");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("管理员登录验证过滤器初始化...");
	}
}
