package com.hwua.ManagementSystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.ManagementSystem.dao.Departmentdao;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.util.JDBCUtil;
import com.hwua.ManagementSystem.entity.Department;

public class DepartmentdaoImpl  implements Departmentdao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();
	@Override
	public int create(Department department) {
		String sql = "INSERT INTO t_Department(department_name,DepartmentID) VALUES(?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql,department.getDepartment_name(),department.getDepartmentID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(Department department) {
		String sql = "UPDATE t_Department SET department_name=? WHERE DepartmentID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, department.getDepartment_name(), department.getDepartmentID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE FROM t_Department WHERE DepartmentID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Department findById(String id) {
		String sql = "SELECT * FROM t_Department WHERE DepartmentID=?";
		Department department = null;
		try {
			department = queryRunner.query(sql, new BeanHandler<Department>(Department.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public List<Department> findAll() {
		String sql = "SELECT * FROM t_Department ";
		List<Department> departmentList = null;
		try {
			departmentList = queryRunner.query(sql, new BeanListHandler<Department>(Department.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departmentList;
	}

	@Override
	public Department findByDepartmentname(String departmentname) {
		String sql = "SELECT * FROM t_Department WHERE department_name=?";
		Department department = null;
		try {
			department = queryRunner.query(sql, new BeanHandler<Department>(Department.class){}, departmentname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}
	
	
}
