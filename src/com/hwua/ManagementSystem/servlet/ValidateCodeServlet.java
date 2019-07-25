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
		//������֤�����
		ValidateCodeUtil vCode = new ValidateCodeUtil(160,40,4,150);
		
		//�����ɵ��������֤�뱣�浽session�У����û���¼ʱ���û��������֤����жԱ�
		HttpSession session = request.getSession();
		session.setAttribute("vCode", vCode.getCode());
		
		//����֤��ͼƬ�������response��������У�ͼƬ���ͻ���ʾ��ҳ���img��ǩ��
		vCode.write(response.getOutputStream());
	}
}
