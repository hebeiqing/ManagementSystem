package com.hwua.ManagementSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.ManagementSystem.util.ValidateCodeUtil;

@WebServlet("/validateCode")
public class ValidateCodeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//创建验证码对象
		ValidateCodeUtil vCode = new ValidateCodeUtil(160,40,4,150);
		
		//把生成的随机的验证码保存到session中，在用户登录时与用户输入的验证码进行对比
		HttpSession session = request.getSession();
		session.setAttribute("vCode", vCode.getCode());
		
		//把验证码图片流输出到response的输出流中，图片流就会显示到页面的img标签中
		vCode.write(response.getOutputStream());
	}
}
