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

import com.hwua.ManagementSystem.dao.t_tealassdao;
import com.hwua.ManagementSystem.entity.t_tealass;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.util.JDBCUtil;

public class t_tealassdaoImpl  implements t_tealassdao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

	
	public int create(t_tealass t) {
		String sql = "INSERT INTO t_tealass (tealass_ID,classId,TeacherId,CourseID) VALUES(?,?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql,  t.getTealass_ID(),t.getClassId(),t.getTeacherId(),t.getCourseID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	
	public int update(t_tealass t) {
		String sql = "UPDATE t_tealass SET classId=?,TeacherId=?,CourseID=? WHERE tealass_ID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, t.getClassId(),t.getTeacherId(),t.getCourseID(),t.getTealass_ID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	
	public int delete(String id) {
		String sql = "DELETE FROM t_tealass WHERE tealass_ID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}


	public t_tealass findById(String id) {
		String sql = "SELECT * FROM t_tealass  WHERE tealass_ID=?";
		t_tealass t_tealass = null;
		try {
			t_tealass = queryRunner.query(sql, new BeanHandler<t_tealass>(t_tealass.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_tealass;
	}


	public List<t_tealass> findAll() {
		
		String sql="SELECT s.class_name ,c.CourseName ,t.TeacherName ,"
				+ " l.tealass_ID,c.CourseID,t.TeacherId,s.classId"
				+ "  FROM t_tealass l ,t_course c ,t_teacher t ,tb_class s  "
				+ " WHERE l.classId=s.classId and l.CourseID=c.CourseID "
				+ " and l.TeacherId=t.TeacherId";
		List<t_tealass> t_tealassList = null;
		try {
			t_tealassList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){});
			for(Map<String, Object> map:list){
				t_tealass l=new t_tealass();
				String tealass_ID=map.get("tealass_ID").toString();
				l.setTealass_ID(tealass_ID);
				l.setClassId(map.get("ClassId").toString());
				l.setCourseID(map.get("CourseID").toString());
				l.setTeacherId(map.get("TeacherId").toString());
				tb_Class class1=new tb_Class();
				class1.setClass_name(map.get("Class_name").toString());
				l.setClassa(class1);
				Course course=new Course();
				course.setCourseName(map.get("CourseName").toString());
				l.setCourse(course);
				Teacher teacher=new Teacher();
				teacher.setTeacherName(map.get("TeacherName").toString());
				l.setTeacher(teacher);
				t_tealassList.add(l);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_tealassList;
	}


	public t_tealass findByt_tealassname(String t_tealassname) {
		String sql = "SELECT * FROM t_tealass WHERE t_tealassName=?";
		t_tealass t_tealass = null;
		try {
			t_tealass = queryRunner.query(sql, new BeanHandler<t_tealass>(t_tealass.class){}, t_tealassname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_tealass;
	}
	

}
