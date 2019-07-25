package com.hwua.ManagementSystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;

/**
 * 编码过滤器
 */
@WebFilter("/*")
public abstract class EncodingFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("编码过滤器初始化...");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//System.out.println("编码过滤器进行过滤...");
		
		//把ServletRequest和ServletResponse转换为HttpServletRequest和HttpServletResponse
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		//设置request和response的编码
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//继续进行下一个链chain
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		System.out.println("编码过滤器已销毁...");
	}
}
