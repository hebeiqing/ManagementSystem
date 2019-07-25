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

import com.hwua.ManagementSystem.dao.Studentdao;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Department;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.StudentUnion;
import com.hwua.ManagementSystem.util.JDBCUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
public class StudentdaoImpl implements Studentdao {
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

	@Override
	public int create(Student s) {
		String sql = "INSERT INTO tb_student(StuId,StuName,password,Sex,BirthDate,"
				+ " Natives,EntranceTime,PoliticalFace,Address,"
				+ "  PerPhone,IDNum,classId,National,DepartmentID,maid )"
				+ "  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql,s.getStuId(),s.getStuName(),s.getPassword(),s.getSex(),s.getBirthDate(),s.getNatives(),
					 s.getEntranceTime(),s.getPoliticalFace(),s.getAddress(),s.getPerPhone(),s.getIDNum(),s.getClassId(),s.getNational(),
					 s.getDepartmentID(),s.getMaid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(Student s) {
		String sql = "UPDATE tb_student SET StuName=?,password=?,Sex=?,BirthDate=?,Natives=?,EntranceTime=?,PoliticalFace=?,Address=? ,"
				+ " PerPhone=?,IDNum=?,classId=?,National=?,DepartmentID=?,maid=? WHERE StuId=?";
		int row = 0;
		try {
			row = queryRunner.update(sql,s.getStuName(),s.getPassword(),s.getSex(),s.getBirthDate(),s.getNatives(),
					 s.getEntranceTime(),s.getPoliticalFace(),s.getAddress(),s.getPerPhone(),s.getIDNum(),s.getClassId(),s.getNational(),
					 s.getDepartmentID(),s.getMaid(),s.getStuId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String id) {
		String sql="DELETE FROM tb_student where StuId=?";
		int row=0;
		try {
			row=queryRunner.update(sql,id);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Student findById(String id) {
		/*String sql="SELECT *,d.Department_name,c.CourseName,m.major_name,u.Un_name,b.class_name from "
				+ " tb_student s,t_department d,t_course c ,t_major m ,t_studentunion u ,tb_class b  "
				+ " where s.DepartmentID=d.DepartmentID  and "
				+ " s.maid=m.maid and s.Un_ID=u.Un_ID and s.classId=b.classId and s.StuId=?";*/
		String sql="SELECT *,d.Department_name,m.major_name,b.class_name from"
				+ "   tb_student s,t_department d,t_major m ,tb_class b"
				+ "    where s.DepartmentID=d.DepartmentID  and s.maid=m.maid  "
				+ " and s.classId=b.classId and s.StuId=?";
		Student student=null;
		
		try {
			student = queryRunner.query(sql, new BeanHandler<Student>(Student.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return student;
	}

	@Override
	public List<Student> findAll() {
		/*String sql="SELECT *,d.Department_name,c.CourseName,m.major_name,u.Un_name,b.class_name from "
				+ " tb_student s,t_department d,t_course c ,t_major m ,t_studentunion u ,tb_class b  "
				+ " where s.DepartmentID=d.DepartmentID  and "
				+ " s.maid=m.maid and s.Un_ID=u.Un_ID and s.classId=b.classId;";*/
		String sql="SELECT *,d.Department_name,m.major_name,b.class_name from"
				+ "   tb_student s,t_department d,t_major m ,tb_class b"
				+ "    where s.DepartmentID=d.DepartmentID  and s.maid=m.maid  "
				+ " and s.classId=b.classId;";
		List<Student> studentlist=null;
		try {
			studentlist=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){});
			for(Map<String, Object> map:list){
				Student s=new Student();
				String Stuid=map.get("StuId").toString();
				s.setStuId(Stuid);
				s.setStuName(map.get("StuName").toString());
				s.setPassword(map.get("password").toString());
				s.setStuName(map.get("StuName").toString());
				s.setSex(map.get("Sex").toString());
				s.setBirthDate(map.get("BirthDate").toString());
				s.setNatives(map.get("Natives").toString());
				s.setEntranceTime(map.get("EntranceTime").toString());
				s.setPoliticalFace(map.get("PoliticalFace").toString());
				s.setAddress(map.get("Address").toString());
				s.setPerPhone(map.get("PerPhone").toString());
				s.setIDNum(map.get("IDNum").toString());
				s.setClassId(map.get("classId").toString());
				s.setNational(map.get("National").toString());
				/*s.setUn_ID(map.get("Un_ID").toString());*/
			/*	s.setCourseID(map.get("CourseID").toString());*/
				s.setDepartmentID(map.get("DepartmentID").toString());		
				s.setMaid(map.get("maid").toString());	
				Department department=new Department();
				department.setDepartment_name(map.get("Department_name").toString());
				s.setDepartment(department);
				Major major=new Major();
				major.setMajor_name(map.get("Major_name").toString());
				s.setMajor(major);
				/*Course course=new Course();
				course.setCourseName(map.get("CourseName").toString());
				s.setCourse(course);*/
				tb_Class tb_class=new tb_Class();
				tb_class.setClass_name(map.get("Class_name").toString());
				s.setTb_class(tb_class);
				/*StudentUnion studentUnion=new StudentUnion();
				studentUnion.setUn_name(map.get("Un_name").toString());
				s.setStudentUnion(studentUnion);*/
				studentlist.add(s);	
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentlist;
	}

	@Override
	public Student findByStudentname(String Studentname) {
		String sql = "SELECT * FROM tb_student WHERE StuName=?";
		Student student = null;
		try {
			student = queryRunner.query(sql, new BeanHandler<Student>(Student.class){}, Studentname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> finByStudenCourse(String id) {
		String sql="SELECT  s.StuId,c.CourseID,m.maid,c.CourseName,s.StuName,m.major_name ,b.class_name FROM t_course c ,tb_student s,t_major m ,tb_class b "
				+ " WHERE c.maid=s.maid and s.maid=m.maid  and s.classId=b.classId and s.StuId=?";
	
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

	@Override
	public List<Student> finBysportsCourse(String id) {
		String sql="SELECT  s.StuId,u.Un_name "
				+ " FROM tb_student s,t_studentunion u,t_sportstu p "
				+ "  WHERE   u.Un_ID=p.Un_ID "
				+ " and s.StuId=p.StuId and s.StuId=?";
		
		List<Student> studentlist=null;
		try {
			studentlist=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
			for(Map<String, Object> map:list){
				Student s=new Student();
				String Stuid=map.get("StuId").toString();
				s.setStuId(Stuid);
			/*	s.setUn_ID(map.get("Un_ID").toString());*/
				StudentUnion studentUnion=new StudentUnion();
				studentUnion.setUn_name(map.get("Un_name").toString());
				s.setStudentUnion(studentUnion);
				studentlist.add(s);		
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentlist;
	}

	
	
	
}
