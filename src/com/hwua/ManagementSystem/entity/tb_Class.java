package com.hwua.ManagementSystem.entity;
/*
 * 班级表
 * */

public class tb_Class {
	/*工具表 用来统计班级的人数和该班级的课程*/
	private String classId; //班级id
	private String class_name; //班级名称
	private  String Num;  //班级人数
	private String maid; //专业编号
	private String DepartmentID; //系部编号
	private String CourseID;//课程编号
	private Department department;
	private Course course;
	private Major major;

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public String getMaid() {
		return maid;
	}
	public void setMaid(String maid) {
		this.maid = maid;
	}
	public String getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	@Override
	public String toString() {
		return "tb_Class [classId=" + classId + ", class_name=" + class_name + ", Num=" + Num + ", maid=" + maid
				+ ", DepartmentID=" + DepartmentID + ", CourseID=" + CourseID + ", department=" + department
				+ ", course=" + course + ", major=" + major + "]";
	}
	
	

}
