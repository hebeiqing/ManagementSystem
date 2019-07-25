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

import com.hwua.ManagementSystem.dao.Teacherdao;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Score;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.entity.tb_Class;
import com.hwua.ManagementSystem.util.JDBCUtil;

public class TeachersDaoImpl  implements Teacherdao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();
/*
 * private String TeacherId;//教师id
	private String TeacherName;//教师姓名
	private String Sex;//教师姓名
	private String BirthDate;//教师出生日期
	private String PoliticaFace;//教师政治面貌
	private String Native;//教师籍贯
	private String TePhone;//教师电话
	private String IDNum;//教师身份证
	private String AdmissionTime;//教师入校时间
	private String HighesDegree;//教师最高学历
	private String Position;//教师职务
	private String photo;//教师照片
	private String National;//教师民族
	DepartmentID
 * 
 * */
	@Override
	public int create(Teacher teacher) {
		String sql = "INSERT INTO t_Teacher(TeacherId,TeacherName,password,Sex,BirthDate,PoliticaFace,Natives,TePhone,IDNum,AdmissionTime,HighesDegree,Position,photo,National,DepartmentID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql, teacher.getTeacherId(),teacher.getTeacherName(),teacher.getPassword(),teacher.getSex(),teacher.getBirthDate(),
					teacher.getPoliticaFace(),teacher.getNatives(),teacher.getTePhone(),teacher.getIDNum(),
					teacher.getAdmissionTime(),teacher.getHighesDegree(),teacher.getPosition(),teacher.getPhoto(),teacher.getNational(),teacher.getDepartmentID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(Teacher teacher) {
		String sql = "UPDATE t_Teacher SET TeacherName=?,password=?,Sex=?,BirthDate=?,PoliticaFace=?,Natives=?,TePhone=?,IDNum=?,AdmissionTime=?,HighesDegree=?,Position=?,photo=?,National=?,DepartmentID=? WHERE TeacherId=?";
		int row = 0;
		try {
			row = queryRunner.update(sql,teacher.getTeacherName(),teacher.getPassword(),teacher.getSex(),teacher.getBirthDate(),
					teacher.getPoliticaFace(),teacher.getNatives(),teacher.getTePhone(),teacher.getIDNum(),
					teacher.getAdmissionTime(),teacher.getHighesDegree(),teacher.getPosition(),teacher.getPhoto(),teacher.getNational(),teacher.getDepartmentID(),teacher.getTeacherId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE FROM t_Teacher WHERE TeacherId=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Teacher findById(String id) {
		//String sql = "SELECT * FROM t_Teacher WHERE TeacherId=?";
		String sql="SELECT *,d.Department_name from t_teacher t , t_department d where t.DepartmentID=d.DepartmentID AND t.TeacherId=?";
		Teacher teacher = null;
		try {
			teacher = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public List<Teacher> findAll() {
		//String sql = "SELECT * FROM t_Teacher ";
		String sql="SELECT *,d.Department_name from t_teacher t , t_department d where t.DepartmentID=d.DepartmentID";
		List<Teacher> teacherList = null;
		try {
			teacherList = queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherList;
	}

	@Override
	public Teacher findByTeachername(String TeacherName) {
		String sql = "SELECT * FROM t_Teacher WHERE TeacherName=?";
		Teacher teacher = null;
		try {
			teacher = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class){}, TeacherName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public List<Teacher> findByCourse(String id) {
		String sql="SELECT t.TeacherId,c.classId,u.CourseID,l.tealass_ID ,"
				+ " t.TeacherName ,c.class_name ,u.CourseName"
				+ "  from t_tealass l , t_teacher t ,tb_class c,t_course u "
				+ "  WHERE  l.classId=c.classId  and l.TeacherId=t.TeacherId"
				+ "  and u.CourseID=l.CourseID  and l.TeacherId=?";
		List<Teacher> teacherList = null;
		
		try {
			teacherList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
			for(Map<String, Object> map:list){
				Teacher teacher=new Teacher();
				String tealass_ID=map.get("tealass_ID").toString();
				teacher.setTealass_ID(tealass_ID);
				teacher.setTeacherId(map.get("TeacherId").toString());
				teacher.setClassId(map.get("ClassId").toString());
				teacher.setCourseID(map.get("CourseID").toString());
				teacher.setTeacherName(map.get("TeacherName").toString());
				tb_Class class1=new tb_Class();
				class1.setClass_name(map.get("Class_name").toString());
				teacher.setClass1(class1);
				Course course=new Course();
				course.setCourseName(map.get("CourseName").toString());
				teacher.setCourse(course);
				teacherList.add(teacher);	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return teacherList;
	}

	@Override
	public List<Teacher> findByStudent(String id) {
		String sql="SELECT s.StuName,c.CourseName,a.class_name, "
				+ " t.tealass_ID,s.StuId,c.CourseID,a.classId from "
				+ " t_tealass t ,tb_student s,t_course c  ,tb_class a "
				+ " where s.classId=t.classId and t.classId=a.classId  "
				+ " and t.CourseID=c.CourseID"
				+ " and  t.TeacherId=? ";
		
		/*String sql="SELECT s.StuName,c.CourseName,a.class_name, "
				+ " o.score, t.tealass_ID,s.StuId,c.CourseID,a.classId "
				+ " from  t_tealass t ,tb_student s,t_course c  ,tb_class a ,t_score o"
				+ "  where s.classId=t.classId "
				+ "   AND s.StuId=o.StuId "
				+ " and t.CourseID=o.CourseID "
				+ " and t.classId=a.classId "
				+ "  and t.CourseID=c.CourseID and  t.TeacherId=?";*/
		List<Teacher> teacherList = null;     /*根据班级id和课程查找学生 根据学生查找成绩*/
		
		try {
			teacherList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
			for(Map<String, Object> map:list){
				Teacher teacher=new Teacher();
				String tealass_ID=map.get("tealass_ID").toString();
				teacher.setTealass_ID(tealass_ID);
				teacher.setClassId(map.get("ClassId").toString());
				teacher.setCourseID(map.get("CourseID").toString());
				teacher.setStuId(map.get("StuId").toString());
				tb_Class class1=new tb_Class();
				class1.setClass_name(map.get("Class_name").toString());
				teacher.setClass1(class1);
				Course course=new Course();
				course.setCourseName(map.get("CourseName").toString());
				teacher.setCourse(course);
				Student student=new Student();
				student.setStuName(map.get("StuName").toString());
				teacher.setStudent(student);
				/*Score score=new Score();
				teacher.setScoreID(map.get("ScoreID").toString());
				score.setScore(map.get("Score").toString());
				teacher.setScore(score);	*/
				teacherList.add(teacher);	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return teacherList;
	}
	
	
	public List<Teacher> findByscore(String id) {
		String sql="SELECT s.StuName,c.CourseName,a.class_name, "
		+ " t.tealass_ID,s.StuId,c.CourseID,a.classId from "
		+ " t_tealass t ,tb_student s,t_course c  ,tb_class a "
		+ " where s.classId=t.classId and t.classId=a.classId  "
		+ " and t.CourseID=c.CourseID"
		+ " and  t.TeacherId=? ";
		
		List<Teacher> teacherList = null;     /*根据班级id和课程查找学生 根据学生查找成绩*/
		
		try {
			teacherList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
			for(Map<String, Object> map:list){
				Teacher teacher=new Teacher();
				String tealass_ID=map.get("tealass_ID").toString();
				teacher.setTealass_ID(tealass_ID);
				teacher.setClassId(map.get("ClassId").toString());
				teacher.setCourseID(map.get("CourseID").toString());
				teacher.setStuId(map.get("StuId").toString());
				tb_Class class1=new tb_Class();
				class1.setClass_name(map.get("Class_name").toString());
				teacher.setClass1(class1);
				Course course=new Course();
				course.setCourseName(map.get("CourseName").toString());
				teacher.setCourse(course);
				Student student=new Student();
				student.setStuName(map.get("StuName").toString());
				teacher.setStudent(student);
				teacherList.add(teacher);	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return teacherList;
	}
	
	
	

}
