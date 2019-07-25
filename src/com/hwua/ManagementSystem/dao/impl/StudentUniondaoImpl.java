package com.hwua.ManagementSystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.ManagementSystem.dao.Departmentdao;
import com.hwua.ManagementSystem.dao.StudentUniondao;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.util.JDBCUtil;
import com.hwua.ManagementSystem.entity.Department;

public class StudentUniondaoImpl  implements StudentUniondao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();
	@Override
	public int create(StudentUnion studentUnion) {
		String sql = "INSERT INTO t_StudentUnion(Un_ID,Un_name) VALUES(?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql,studentUnion.getUn_ID(),studentUnion.getUn_name());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(StudentUnion studentUnion) {
		String sql = "UPDATE t_StudentUnion SET Un_name=? WHERE Un_ID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql,studentUnion.getUn_name(),studentUnion.getUn_ID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE FROM t_StudentUnion WHERE Un_ID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public StudentUnion findById(String id) {
		String sql = "SELECT * FROM t_StudentUnion  WHERE Un_ID=?";
		StudentUnion studentUnion  = null;
		try {
			studentUnion = queryRunner.query(sql, new BeanHandler<StudentUnion>(StudentUnion.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentUnion;
	}

	@Override
	public List<StudentUnion> findAll() {
		String sql = "SELECT * FROM t_StudentUnion ";
		List<StudentUnion> departmentList = null;
		try {
			departmentList = queryRunner.query(sql, new BeanListHandler<StudentUnion>(StudentUnion.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departmentList;
	}

	@Override
	public StudentUnion findBystudentUnionname(String departmentname) {
		String sql = "SELECT * FROM t_StudentUnion WHERE Un_name=?";
		StudentUnion studentUnion  = null;
		try {
			studentUnion = queryRunner.query(sql, new BeanHandler<StudentUnion>(StudentUnion.class){}, departmentname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentUnion;
	}

	
	
}
