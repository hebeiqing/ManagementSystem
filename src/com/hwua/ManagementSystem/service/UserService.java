package com.hwua.ManagementSystem.service;

import java.util.Map;

/**
 * �û���ҵ���߼���
 */
public interface UserService {
	
	Map<String, Object> adminLogin(String username, String password);//����Ա��¼����
	Map<String, Object> studnetLogin(String username, String password);//ѧ����¼
	Map<String, Object> teacherLogin(String username, String password);//��ʦ��¼
	Map<String, Object> userRegister(String username, String password, String mobile, String sex);//��Աע��
}
