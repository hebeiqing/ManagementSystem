package com.hwua.ManagementSystem.entity;

import java.util.Date;

/**
 * �û��ࣨt_user��
 */
public class User {
	private String id;
	private String username;//�û���
	private String password;//����
	private String mobile;//�ֻ�
	private String sex;//�Ա�
	private Date createTime;//ע��ʱ��
	private Integer type;//�û����ͣ�0-��ͨ�û���1-����Ա��
	private Integer status;//״̬��1��������0����ɾ����
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
