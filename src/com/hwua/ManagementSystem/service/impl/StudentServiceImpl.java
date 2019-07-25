package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.Studentdao;
import com.hwua.ManagementSystem.dao.impl.StudentdaoImpl;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.service.StudentService;

public class StudentServiceImpl  implements StudentService{

	private Studentdao studentdao;
	
	public StudentServiceImpl() {
		studentdao=new StudentdaoImpl();
	}
	
	@Override
	public int create(Student Student) {
		// TODO Auto-generated method stub
		return studentdao.create(Student);
	}

	@Override
	public int update(Student Student) {
		// TODO Auto-generated method stub
		return studentdao.update(Student);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return studentdao.delete(id);
	}

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return studentdao.findById(id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentdao.findAll();
	}

	@Override
	public List<Student> finByStudenCourse(String id) {
	return studentdao.finByStudenCourse(id);
	}

	@Override
	public List<Student> finBysportsCourse(String id) {
		// TODO Auto-generated method stub
		return studentdao.finBysportsCourse(id);
	}

	@Override
	public List<Student> finBymaidCourse(String id) {
		// TODO Auto-generated method stub
		String mag="Çë°Édao²ã´úÂëÍêÉÆ¼´ºÃ";
		return null ;
	}

	

}
