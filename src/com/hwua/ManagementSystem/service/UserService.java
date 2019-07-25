package com.hwua.ManagementSystem.service;

import java.util.Map;

/**
 * 用户的业务逻辑层
 */
public interface UserService {
	
	Map<String, Object> adminLogin(String username, String password);//管理员登录方法
	Map<String, Object> studnetLogin(String username, String password);//学生登录
	Map<String, Object> teacherLogin(String username, String password);//教师登录
	Map<String, Object> userRegister(String username, String password, String mobile, String sex);//会员注册
}
