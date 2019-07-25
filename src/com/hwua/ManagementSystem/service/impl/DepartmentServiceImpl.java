package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.Departmentdao;
import com.hwua.ManagementSystem.dao.impl.DepartmentdaoImpl;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
 
	   private Departmentdao  departmentdao;
	   public DepartmentServiceImpl() {
		   departmentdao=new DepartmentdaoImpl();
	}
	   
	@Override
	public int create(Department department) {
		
		return departmentdao.create(department);
	}

	@Override
	public int update(Department department) {
		// TODO Auto-generated method stub
		return departmentdao.update(department);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return departmentdao.delete(id);
	}

	@Override
	public Department findById(String id) {
		// TODO Auto-generated method stub
		return departmentdao.findById(id);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentdao.findAll();
	}

	@Override
	public Department findByDepartmentname(String departmentname) {
		// TODO Auto-generated method stub
		return departmentdao.findByDepartmentname(departmentname);
	}

}
