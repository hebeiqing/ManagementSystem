package com.hwua.ManagementSystem.entity;

public class Score {
	private String  ScoreID;//�ɼ���id
	private String score;
	
	private String CourseID;//�γ̱��
	private String StuId; //ѧ��id
	
	private Course course;
	private Student Student;
	public String getScoreID() {
		return ScoreID;
	}
	public void setScoreID(String scoreID) {
		ScoreID = scoreID;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
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
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public Student getStudent() {
		return Student;
	}
	public void setStudent(Student student) {
		Student = student;
	}

}
