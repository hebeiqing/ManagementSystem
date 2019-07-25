package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.Teacherdao;
import com.hwua.ManagementSystem.dao.impl.TeachersDaoImpl;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
   
	private Teacherdao teacherdao;
	
	public TeacherServiceImpl() {
		teacherdao=new TeachersDaoImpl();
	}
	
	@Override
	public int create(Teacher teachers) {
		return teacherdao.create(teachers);
	}

	@Override
	public int update(Teacher teachers) {
	return teacherdao.update(teachers);
	}

	@Override
	public int delete(String id) {
		return teacherdao.delete(id);
	}

	@Override
	public Teacher findById(String id) {	
		return teacherdao.findById(id);
	}

	@Override
	public List<Teacher> findAll() {
		return teacherdao.findAll();
	}

	@Override
	public Teacher findByTeachername(String teachername) {
		return teacherdao.findByTeachername(teachername);
	}

	@Override
	public List<Teacher> findByCourse(String id) {
		return teacherdao.findByCourse(id);
	}

	@Override
	public List<Teacher> findByStudent(String id) {
		// TODO Auto-generated method stub
		return teacherdao.findByStudent(id);
	}

	@Override
	public List<Teacher> findByscore(String id) {
		// TODO Auto-generated method stub
		return teacherdao.findByscore(id);
	}

}
