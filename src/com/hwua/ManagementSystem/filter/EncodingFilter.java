package com.hwua.ManagementSystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;

/**
 * ���������
 */
@WebFilter("/*")
public abstract class EncodingFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("�����������ʼ��...");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//System.out.println("������������й���...");
		
		//��ServletRequest��ServletResponseת��ΪHttpServletRequest��HttpServletResponse
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		//����request��response�ı���
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//����������һ����chain
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		System.out.println("���������������...");
	}
}
