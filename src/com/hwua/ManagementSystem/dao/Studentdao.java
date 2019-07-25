package com.hwua.ManagementSystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.Teacher;
public interface Studentdao {
	int create(Student Student);
	int update(Student Student);
	int delete(String id);
	Student findById(String id);
	List<Student> findAll();
	Student findByStudentname(String Studentname);
	List<Student> finByStudenCourse(String id);
	List<Student> finBysportsCourse(String id);
	
	
}
