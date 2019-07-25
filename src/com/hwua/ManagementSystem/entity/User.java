package com.hwua.ManagementSystem.entity;

import java.util.Date;

/**
 * 用户类（t_user表）
 */
public class User {
	private String id;
	private String username;//用户名
	private String password;//密码
	private String mobile;//手机
	private String sex;//性别
	private Date createTime;//注册时间
	private Integer type;//用户类型（0-普通用户，1-管理员）
	private Integer status;//状态（1：正常，0：已删除）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
