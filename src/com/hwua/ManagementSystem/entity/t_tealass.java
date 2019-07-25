package com.hwua.ManagementSystem.entity;

public class t_tealass {

	private String tealass_ID;
	private String classId;
	private String TeacherId;
	private String CourseID;
	
	private tb_Class classa;
	private Teacher teacher;
	private Course course;
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
	public String getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(String teacherId) {
		TeacherId = teacherId;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public tb_Class getClassa() {
		return classa;
	}
	public void setClassa(tb_Class classa) {
		this.classa = classa;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
}
