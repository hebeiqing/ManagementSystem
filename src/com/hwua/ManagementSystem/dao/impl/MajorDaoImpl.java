package com.hwua.ManagementSystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.hwua.ManagementSystem.dao.MajorDao;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.util.JDBCUtil;
import com.sun.org.apache.regexp.internal.recompile;

public class MajorDaoImpl  implements MajorDao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

	@Override
	public int create(Major major) {
		String sql = "INSERT INTO t_Major(maid,Major_name,DepartmentID) VALUES(?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql, major.getMaid(), major.getMajor_name(),major.getDepartmentID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(Major major) {
		String sql = "UPDATE t_Major SET major_name=?,DepartmentID=? WHERE maid=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, major.getMajor_name(),major.getDepartmentID(), major.getMaid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE FROM t_Major WHERE maid=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Major findById(String id) {
		String sql = "SELECT * FROM t_Major WHERE maid=?";
		Major major = null;
		try {
			major = queryRunner.query(sql, new BeanHandler<Major>(Major.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return major;
	}

	@Override
	public List<Major> findAll() {
		//String sql = "SELECT * FROM t_Major ";
		String sql="SELECT *,d.Department_name from t_major m,t_department d  WHERE m.DepartmentID=d.DepartmentID";
		List<Major> majorList = null;
		try {
			/*majorList = queryRunner.query(sql, new BeanListHandler<Major>(Major.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){});*/
			majorList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){});
			for(Map<String, Object> map:list){
				Major major=new Major();
				String maid=map.get("maid").toString();
				major.setMaid(maid);
				major.setMajor_name(map.get("major_name").toString());
				major.setDepartmentID(map.get("DepartmentID").toString());
				Department department=new Department();
				department.setDepartment_name(map.get("Department_name").toString());
				major.setDepartment(department);
				majorList.add(major);	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return majorList;
	}

	@Override
	public Major findByMajorname(String majorname) {
		String sql = "SELECT * FROM t_Major WHERE major_name=?";
		Major major = null;
		try {
			major = queryRunner.query(sql, new BeanHandler<Major>(Major.class){}, majorname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return major;
	}
	

}
