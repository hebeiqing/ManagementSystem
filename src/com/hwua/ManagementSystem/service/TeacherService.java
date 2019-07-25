package com.hwua.ManagementSystem.service;

import java.util.List;

import com.hwua.ManagementSystem.entity.Teacher;

public interface TeacherService {
	int create(Teacher teachers);
	int update(Teacher teachers);
	int delete(String id);
	Teacher findById(String id);
	List<Teacher> findAll();
	Teacher findByTeachername(String teachername);
	List<Teacher> findByCourse(String id);
	List<Teacher> findByStudent(String id);
	List<Teacher> findByscore(String id);
}
