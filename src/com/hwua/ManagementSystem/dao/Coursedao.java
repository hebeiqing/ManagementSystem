package com.hwua.ManagementSystem.dao;

import java.util.List;

import com.hwua.ManagementSystem.entity.Course;
public interface Coursedao {
	int create(Course course);
	int update(Course course);
	int delete(String id);
	Course findById(String id);
	List<Course> findAll();
	Course findByCoursename(String coursename);
}
