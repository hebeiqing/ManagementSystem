package com.hwua.ManagementSystem.service;

import java.util.List;

import com.hwua.ManagementSystem.dao.Departmentdao;
import com.hwua.ManagementSystem.entity.Department;

public interface DepartmentService {
	int create(Department department);
	int update(Department department);
	int delete(String id);
	Department findById(String id);
	List<Department> findAll();
	Department findByDepartmentname(String departmentname);
}
