package com.hwua.ManagementSystem.service.impl;
import java.util.List;
import com.hwua.ManagementSystem.dao.StudentUniondao;
import com.hwua.ManagementSystem.dao.impl.StudentUniondaoImpl;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.service.StudentUnionservice;

public class StudentUnionServiceImpl  implements StudentUnionservice{

	private StudentUniondao studentUniondao;
	public StudentUnionServiceImpl() {
		 studentUniondao=new StudentUniondaoImpl();
	}
	@Override
	public int create(StudentUnion studentUnion) {
		// TODO Auto-generated method stub
		return studentUniondao.create(studentUnion);
	}
	@Override
	public int update(StudentUnion StudentUnion) {
		// TODO Auto-generated method stub
		return studentUniondao.update(StudentUnion);
	}
	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return studentUniondao.delete(id);
	}
	@Override
	public StudentUnion findById(String id) {
		// TODO Auto-generated method stub
		return studentUniondao.findById(id);
	}
	@Override
	public List<StudentUnion> findAll() {
		// TODO Auto-generated method stub
		return studentUniondao.findAll();
	}
	@Override
	public StudentUnion findBystudentUnionname(String StudentUnionname) {
		// TODO Auto-generated method stub
		return studentUniondao.findBystudentUnionname(StudentUnionname);
	}
	
	

}
