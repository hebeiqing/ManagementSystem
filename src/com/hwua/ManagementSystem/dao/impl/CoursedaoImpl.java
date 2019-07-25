package com.hwua.ManagementSystem.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.hwua.ManagementSystem.dao.Coursedao;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.util.JDBCUtil;

public class CoursedaoImpl  implements Coursedao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

	
	public int create(Course course) {
		String sql = "INSERT INTO t_Course(CourseID,CourseName,CreDits,maid) VALUES(?,?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql,  course.getCourseID(),course.getCourseName(),course.getCreDits(),course.getMaid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	
	public int update(Course course) {
		String sql = "UPDATE t_Course SET CourseName=?,CreDits=?,maid=? WHERE CourseID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, course.getCourseName(),course.getCreDits(),course.getMaid(),course.getCourseID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	
	public int delete(String id) {
		String sql = "DELETE FROM t_Course WHERE CourseID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}


	public Course findById(String id) {
		String sql = "SELECT * FROM t_Course WHERE CourseID=?";
		Course course = null;
		try {
			course = queryRunner.query(sql, new BeanHandler<Course>(Course.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}


	public List<Course> findAll() {
		//String sql = "SELECT * FROM t_Course";
		String sql="SELECT * FROM t_course c ,t_major m  WHERE m.maid=c.maid";
		List<Course> courseList = null;
		try {
			courseList = queryRunner.query(sql, new BeanListHandler<Course>(Course.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseList;
	}


	public Course findByCoursename(String coursename) {
		String sql = "SELECT * FROM t_Course WHERE CourseName=?";
		Course course = null;
		try {
			course = queryRunner.query(sql, new BeanHandler<Course>(Course.class){}, coursename);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	

}
