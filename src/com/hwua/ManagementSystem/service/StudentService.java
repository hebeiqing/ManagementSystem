package com.hwua.ManagementSystem.service;

import java.util.List;

import com.hwua.ManagementSystem.entity.Student;

public interface StudentService {
	int create(Student Student);
	int update(Student Student);
	int delete(String id);
	Student findById(String id);
	List<Student> findAll();
	List<Student> finByStudenCourse(String id);
	List<Student> finBysportsCourse(String id);
	List<Student> finBymaidCourse(String id);
}
