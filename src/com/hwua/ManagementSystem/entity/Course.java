package com.hwua.ManagementSystem.entity;

public class Course {
	
	private String CourseID;//�γ̱��
	private String CourseName;//�γ�����
	private String CreDits;//ѧ��
	private String maid; //רҵ���
	private String major_name;//רҵ����
	
	
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getMaid() {
		return maid;
	}
	public void setMaid(String maid) {
		this.maid = maid;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCreDits() {
		return CreDits;
	}
	public void setCreDits(String creDits) {
		CreDits = creDits;
	}
	
}
