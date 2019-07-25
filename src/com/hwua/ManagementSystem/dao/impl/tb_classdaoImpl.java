package com.hwua.ManagementSystem.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.hwua.ManagementSystem.dao.tb_Classdao;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.util.JDBCUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
public class tb_classdaoImpl implements tb_Classdao {
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

	@Override
	public int create(tb_Class tb_Class) {
		String sql = "INSERT INTO tb_class(classId,class_name,Num,maid,DepartmentID) VALUES(?,?,?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql,tb_Class.getClassId(),tb_Class.getClass_name(),tb_Class.getNum(),tb_Class.getMaid(),tb_Class.getDepartmentID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(tb_Class tb_Class) {
		String sql = "UPDATE tb_class SET class_name=?,Num=?,maid=?,DepartmentID=? WHERE classId=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, tb_Class.getClass_name(),tb_Class.getNum(),tb_Class.getMaid(),tb_Class.getDepartmentID(),tb_Class.getClassId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String id) {
		String sql="DELETE FROM tb_class where classId=?";
		int row=0;
		try {
			row=queryRunner.update(sql,id);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public tb_Class findById(String id) {
		String sql="SELECT t.class_name,t.Num,t.classId,t.maid,t.DepartmentID,d.Department_name,m.major_name from "
				+ " tb_class t,t_department d ,t_major m where t.maid=m.maid and "
				+ " t.departmentID=d.DepartmentID  AND t.classId=?";
		tb_Class tb_class=null;
		
		try {
			tb_class = queryRunner.query(sql, new BeanHandler<tb_Class>(tb_Class.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return tb_class;
	}

	@Override
	public List<tb_Class> findAll() {
		String sql="SELECT t.class_name,t.Num,t.classId,t.maid,t.DepartmentID,d.Department_name,m.major_name from "
				+ " tb_class t ,t_department d ,t_major m where t.maid=m.maid and "
				+ " t.departmentID=d.DepartmentID ;";
		List<tb_Class> tb_classlist=null;
		try {
			tb_classlist=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){});
			for(Map<String, Object> map:list){
				tb_Class tb_Class=new tb_Class();
				String classid=map.get("classId").toString();
				tb_Class.setClassId(classid);
				tb_Class.setClass_name(map.get("class_name").toString());
				tb_Class.setNum(map.get("Num").toString());
				tb_Class.setMaid(map.get("maid").toString());
				tb_Class.setDepartmentID(map.get("DepartmentID").toString());
				/*tb_Class.setCourseID(map.get("CourseID").toString());
				Course course=new Course();
				course.setCourseName(map.get("CourseName").toString());
				tb_Class.setCourse(course);*/
				Department department=new Department();
				department.setDepartment_name(map.get("Department_name").toString());
				tb_Class.setDepartment(department);
				Major major=new Major();
				major.setMajor_name(map.get("major_name").toString());
				tb_Class.setMajor(major);
				tb_classlist.add(tb_Class);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tb_classlist;
	}

	@Override
	public tb_Class findBytb_Classname(String tb_Classname) {
		
		return null;
	}

	/*public static void main(String[] args) {
		tb_Classdao cl=new tb_classdaoImpl();
		List<tb_Class> findAll = cl.findAll();
		System.out.println(findAll);
	}
*/
}
