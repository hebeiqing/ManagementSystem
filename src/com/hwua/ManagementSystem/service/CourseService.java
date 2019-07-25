package com.hwua.ManagementSystem.service;

import java.util.List;
import com.hwua.ManagementSystem.entity.Course;
public interface CourseService {
	int create(Course course);
	int update(Course course);
	int delete(String id);
	Course findById(String id);
	List<Course> findAll();
	Course findByCoursename(String coursename);

}
