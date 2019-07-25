package com.hwua.ManagementSystem.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.hwua.ManagementSystem.dao.tb_Classdao;
import com.hwua.ManagementSystem.dao.impl.tb_classdaoImpl;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.service.tb_ClassService;
import com.hwua.ManagementSystem.util.JDBCUtil;

public class tb_ClassServiceImpl  implements tb_ClassService{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();
	private tb_Classdao tb_classdao;
	
	public tb_ClassServiceImpl() {
		tb_classdao=new tb_classdaoImpl();
	}

	@Override
	public int create(tb_Class tb_Class) {
		// TODO Auto-generated method stub
		return tb_classdao.create(tb_Class);
	}

	@Override
	public int update(tb_Class tb_Class) {
		// TODO Auto-generated method stub
		return tb_classdao.update(tb_Class);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return tb_classdao.delete(id);
	}

	@Override
	public tb_Class findById(String id) {
		// TODO Auto-generated method stub
		return tb_classdao.findById(id);
	}

	@Override
	public List<tb_Class> findAll() {
		// TODO Auto-generated method stub
		return tb_classdao.findAll();
	}

	@Override
	public tb_Class findBytb_Classname(String tb_Classname) {
		// TODO Auto-generated method stub
		return tb_classdao.findBytb_Classname(tb_Classname);
	}
	
	public List<Major> findAllmajor(String id ) {
		String sql="SELECT *,d.Department_name from t_major m,t_department d  WHERE m.DepartmentID=d.DepartmentID and d.DepartmentID=?";
		List<Major> majorList = null;
		try {
			majorList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
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
	
	public List<tb_Class> findAllclass(String id) {
		String sql="SELECT t.class_name,t.Num,t.classId,t.maid,t.DepartmentID,d.Department_name,m.major_name from "
				+ " tb_class t ,t_department d ,t_major m where t.maid=m.maid and "
				+ " t.departmentID=d.DepartmentID and m.maid=?;";
		List<tb_Class> tb_classlist=null;
		try {
			tb_classlist=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
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
	
	public List<Student> finBymaidCourse(String id) {
		String sql="SELECT  s.StuId,c.CourseID,m.maid,c.CourseName,s.StuName,m.major_name ,b.class_name FROM t_course c ,tb_student s,t_major m ,tb_class b "
				+ " WHERE c.maid=s.maid and s.maid=m.maid  and s.classId=b.classId and s.maid=?";
	
		List<Student> studentlist=null;
		try {
			studentlist=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
			for(Map<String, Object> map:list){
				Student s=new Student();
				String Stuid=map.get("StuId").toString();
				s.setStuId(Stuid);
				s.setStuName(map.get("StuName").toString());
				/*s.setUn_ID(map.get("Un_ID").toString());*/
				s.setCourseID(map.get("CourseID").toString());	
				s.setMaid(map.get("maid").toString());	
				Major major=new Major();
				major.setMajor_name(map.get("Major_name").toString());
				s.setMajor(major);
				Course course=new Course();
				course.setCourseName(map.get("CourseName").toString());
				s.setCourse(course);
				tb_Class tb_class=new tb_Class();
				tb_class.setClass_name(map.get("Class_name").toString());
				s.setTb_class(tb_class);
				/*StudentUnion studentUnion=new StudentUnion();
				studentUnion.setUn_name(map.get("Un_name").toString());
				s.setStudentUnion(studentUnion);*/
				studentlist.add(s);		
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentlist;
	}
	
	
}
