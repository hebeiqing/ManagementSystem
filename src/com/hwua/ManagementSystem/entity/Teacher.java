package com.hwua.ManagementSystem.entity;

import java.util.Date;

public class Teacher {
	private String TeacherId;//��ʦid
	private String TeacherName;//��ʦ����
	
	private String Sex;//��ʦ�Ա�
	private String BirthDate;//��ʦ��������
	private String PoliticaFace;//��ʦ������ò
	private String Natives;//��ʦ����
	private String TePhone;//��ʦ�绰
	 private String Department_name;
	private String IDNum;//��ʦ���֤
	private String AdmissionTime;//��ʦ��Уʱ��
	private String HighesDegree;//��ʦ���ѧ��
	private String Position;//��ʦְ��
	private String photo;//��ʦ��Ƭ
	private String National;//��ʦ����
	private String DepartmentID;
	
	private String password;
	private String type;
	
	 private String tealass_ID;
	 
	 private String classId;
	 private tb_Class class1;
	 private String CourseID;
	 private Course course;	 
	 private Student student;
	 private String StuId;
	 private Score score; 
	 private String ScoreID;
	 
	 
	 

	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public String getScoreID() {
		return ScoreID;
	}
	public void setScoreID(String scoreID) {
		ScoreID = scoreID;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getTealass_ID() {
		return tealass_ID;
	}
	public void setTealass_ID(String tealass_ID) {
		this.tealass_ID = tealass_ID;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public tb_Class getClass1() {
		return class1;
	}
	public void setClass1(tb_Class class1) {
		this.class1 = class1;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepartment_name() {
		return Department_name;
	}
	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}
	public String getNatives() {
		return Natives;
	}
	public void setNatives(String natives) {
		Natives = natives;
	}
	public String getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}
	public String getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(String teacherId) {
		TeacherId = teacherId;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	

	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public String getPoliticaFace() {
		return PoliticaFace;
	}
	public void setPoliticaFace(String politicaFace) {
		PoliticaFace = politicaFace;
	}
	
	public String getTePhone() {
		return TePhone;
	}
	public void setTePhone(String tePhone) {
		TePhone = tePhone;
	}
	public String getIDNum() {
		return IDNum;
	}
	public void setIDNum(String iDNum) {
		IDNum = iDNum;
	}
	public String getAdmissionTime() {
		return AdmissionTime;
	}
	public void setAdmissionTime(String admissionTime) {
		AdmissionTime = admissionTime;
	}
	public String getHighesDegree() {
		return HighesDegree;
	}
	public void setHighesDegree(String highesDegree) {
		HighesDegree = highesDegree;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNational() {
		return National;
	}
	public void setNational(String national) {
		National = national;
	}
	@Override
	public String toString() {
		return "Teacher [TeacherId=" + TeacherId + ", TeacherName=" + TeacherName + ", Sex=" + Sex + ", BirthDate="
				+ BirthDate + ", PoliticaFace=" + PoliticaFace + ", Natives=" + Natives + ", TePhone=" + TePhone
				+ ", Department_name=" + Department_name + ", IDNum=" + IDNum + ", AdmissionTime=" + AdmissionTime
				+ ", HighesDegree=" + HighesDegree + ", Position=" + Position + ", photo=" + photo + ", National="
				+ National + ", DepartmentID=" + DepartmentID + "]";
	}
	

	
}
