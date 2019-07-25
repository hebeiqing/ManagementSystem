package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.Coursedao;
import com.hwua.ManagementSystem.dao.impl.CoursedaoImpl;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.service.CourseService;

public class CourseServiceImpl implements CourseService {
	
  private Coursedao coursedao;
  
  public CourseServiceImpl() {
	  coursedao=new CoursedaoImpl();
}
	
	
	@Override
	public int create(Course course) {
		// TODO Auto-generated method stub
		return coursedao.create(course);
	}

	@Override
	public int update(Course course) {
		// TODO Auto-generated method stub
		return coursedao.update(course);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return coursedao.delete(id);
	}

	@Override
	public Course findById(String id) {
		// TODO Auto-generated method stub
		return coursedao.findById(id);
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return coursedao.findAll();
	}

	@Override
	public Course findByCoursename(String coursename) {
		// TODO Auto-generated method stub
		return coursedao.findByCoursename(coursename);
	}

}
