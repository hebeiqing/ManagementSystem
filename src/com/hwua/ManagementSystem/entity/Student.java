package com.hwua.ManagementSystem.entity;

import java.util.Date;

public class Student {
	private String StuId; //学生id
	private String StuName;//学生姓名
	private String password;
	private String Sex;//学生性别
	private String  BirthDate;//学生出生日期
	private String Natives;//学生籍贯
	private String EntranceTime;//学生入学时间
	private String PoliticalFace;//学生政治面貌
	private String Address;//学生家庭地址
	private String PerPhone;//学生电话
	private String IDNum;//学生id//学生身份证
	private String classId;//学生所在班级
	private String National;//学生民族
	private String Un_ID; //学生会id
	private String CourseID;//课程id
	private tb_Class tb_class;
	private String DepartmentID;
	private String maid;
	private String type;
	private Department department;
	private StudentUnion studentUnion;
	private Course course;
	private Major major;
	private String courseName;
	
	
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public tb_Class getTb_class() {
		return tb_class;
	}
	public void setTb_class(tb_Class tb_class) {
		this.tb_class = tb_class;
	}
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getNatives() {
		return Natives;
	}
	public void setNatives(String natives) {
		Natives = natives;
	}
	public String getEntranceTime() {
		return EntranceTime;
	}
	public void setEntranceTime(String entranceTime) {
		EntranceTime = entranceTime;
	}
	public String getPoliticalFace() {
		return PoliticalFace;
	}
	public void setPoliticalFace(String politicalFace) {
		PoliticalFace = politicalFace;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPerPhone() {
		return PerPhone;
	}
	public void setPerPhone(String perPhone) {
		PerPhone = perPhone;
	}
	public String getIDNum() {
		return IDNum;
	}
	public void setIDNum(String iDNum) {
		IDNum = iDNum;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getNational() {
		return National;
	}
	public void setNational(String national) {
		National = national;
	}
	public String getUn_ID() {
		return Un_ID;
	}
	public void setUn_ID(String un_ID) {
		Un_ID = un_ID;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}
	public String getMaid() {
		return maid;
	}
	public void setMaid(String maid) {
		this.maid = maid;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public StudentUnion getStudentUnion() {
		return studentUnion;
	}
	public void setStudentUnion(StudentUnion studentUnion) {
		this.studentUnion = studentUnion;
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
	@Override
	public String toString() {
		return "Student [StuId=" + StuId + ", StuName=" + StuName + ", password=" + password + ", Sex=" + Sex
				+ ", BirthDate=" + BirthDate + ", Natives=" + Natives + ", EntranceTime=" + EntranceTime
				+ ", PoliticalFace=" + PoliticalFace + ", Address=" + Address + ", PerPhone=" + PerPhone + ", IDNum="
				+ IDNum + ", classId=" + classId + ", National=" + National + ", Un_ID=" + Un_ID + ", CourseID="
				+ CourseID + ", tb_class=" + tb_class + ", DepartmentID=" + DepartmentID + ", maid=" + maid + ", type="
				+ type + ", department=" + department + ", studentUnion=" + studentUnion + ", course=" + course
				+ ", major=" + major + "]";
	}

	
	
	
}
