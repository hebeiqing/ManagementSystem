package com.hwua.ManagementSystem.entity;

public class T_sportstu {
	
	private String sportStu_ID;
	private String Un_ID;
	private StudentUnion studentUnion;
	private String StuId;
	private Student student;
	private Department department;
	private Major major;
	private tb_Class class1;

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public tb_Class getClass1() {
		return class1;
	}
	public void setClass1(tb_Class class1) {
		this.class1 = class1;
	}
	public String getSportStu_ID() {
		return sportStu_ID;
	}
	public void setSportStu_ID(String sportStu_ID) {
		this.sportStu_ID = sportStu_ID;
	}
	public String getUn_ID() {
		return Un_ID;
	}
	public void setUn_ID(String un_ID) {
		Un_ID = un_ID;
	}
	public StudentUnion getStudentUnion() {
		return studentUnion;
	}
	public void setStudentUnion(StudentUnion studentUnion) {
		this.studentUnion = studentUnion;
	}
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
