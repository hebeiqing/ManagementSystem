package com.hwua.ManagementSystem.dao;

import java.util.List;

import com.hwua.ManagementSystem.entity.Department;
public interface Departmentdao {
	int create(Department department);
	int update(Department department);
	int delete(String id);
	Department findById(String id);
	List<Department> findAll();
	Department findByDepartmentname(String departmentname);
}
