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

import com.hwua.ManagementSystem.dao.t_sportstudao;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.entity.T_sportstu;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.util.JDBCUtil;

public class T_sportstudaoImpl  implements t_sportstudao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

	
	public int create(T_sportstu t) {
		String sql = "INSERT INTO t_sportstu(sportStu_ID,Un_ID,StuId) VALUES(?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql,t.getSportStu_ID(),t.getUn_ID(),t.getStuId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	
	public int update(T_sportstu t) {
		String sql = "UPDATE t_sportstu SET Un_ID=? WHERE StuId=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, t.getUn_ID(),t.getStuId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	
	public int delete(String id) {
		String sql = "DELETE FROM t_sportstu  WHERE sportStu_ID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}


	public T_sportstu findById(String id) {
		String sql = "SELECT * FROM t_sportstu WHERE sportStu_ID=?";
		T_sportstu sportstu = null;
		try {
			sportstu = queryRunner.query(sql, new BeanHandler<T_sportstu>(T_sportstu.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sportstu;
	}


	public List<T_sportstu> findAll() {
		String sql="SELECT s.StuName,c.class_name ,u.Un_name,d.Department_name ,m.major_name,"
				+ "p.sportStu_ID,s.StuId,u.Un_ID"
				+ " from t_sportstu p ,tb_student s,tb_class c ,t_studentunion u ,t_department d ,t_major m"
				+ "  where p.StuId=s.StuId  and s.classId=c.classId and p.Un_ID=u.Un_ID "
				+ "  and s.DepartmentID=d.DepartmentID and s.maid=m.maid;";
		List<T_sportstu> sportstuList = null;
		try {
			sportstuList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){});
			for(Map<String, Object> map:list){
				T_sportstu  sportstu=new T_sportstu();
				String  sportStu_ID=map.get("sportStu_ID").toString();
				sportstu.setSportStu_ID(sportStu_ID);
				sportstu.setStuId(map.get("StuId").toString());
				sportstu.setUn_ID(map.get("Un_ID").toString());
				Department department=new Department();
				department.setDepartment_name(map.get("Department_name").toString());
				sportstu.setDepartment(department);
				Major major=new Major();
				major.setMajor_name(map.get("Major_name").toString());
				sportstu.setMajor(major);
				tb_Class class1=new tb_Class();
				class1.setClass_name(map.get("Class_name").toString());
				sportstu.setClass1(class1);
				StudentUnion studentUnion=new StudentUnion();
				studentUnion.setUn_name(map.get("Un_name").toString());
				sportstu.setStudentUnion(studentUnion);
				Student student=new Student();
				student.setStuName(map.get("StuName").toString());
				sportstu.setStudent(student);
				sportstuList.add(sportstu);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sportstuList;
	}


	public T_sportstu findByT_sportstuname(String coursename) {
		String sql = "SELECT * FROM t_sportstu  WHERE StuId=?";
		T_sportstu ortstu = null;
		try {
			ortstu = queryRunner.query(sql, new BeanHandler<T_sportstu>(T_sportstu.class){}, coursename);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ortstu;
	}
	

}
