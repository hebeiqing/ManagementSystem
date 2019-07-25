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

import com.hwua.ManagementSystem.dao.Scoredao;
import com.hwua.ManagementSystem.entity.Course;
import com.hwua.ManagementSystem.entity.Score;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.util.JDBCUtil;

public class ScoreDaoImpl  implements Scoredao{
	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

	@Override
	public int create(Score score) {
		String sql = "INSERT INTO t_score(ScoreID,score,CourseID,StuId) VALUES(?,?,?,?)";
		int row = 0;
		try {
			row = queryRunner.update(sql, score.getScoreID(),score.getScore(),score.getCourseID(),score.getStuId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(Score score) {
		String sql = "UPDATE t_score SET score=?,CourseID=?, StuId=? WHERE ScoreID=?";  
		int row = 0;
		try {
			row = queryRunner.update(sql, score.getScore(),score.getCourseID(),score.getStuId(),score.getScoreID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE FROM t_score WHERE ScoreID=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Score findById(String id) {
		String sql = "SELECT * FROM t_score WHERE StuId=?";
		Score score = null;
		try {
			score = queryRunner.query(sql, new BeanHandler<Score>(Score.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}

	@Override
	public List<Score> findAll() {
		String sql = "SELECT r.score,r.CourseID,r.ScoreID,r.StuId,s.StuName,c.CourseName from t_score r ,tb_student s ,t_course c where r.StuId=s.StuId and r.CourseID=c.CourseID ";
		List<Score> scoreList = null;
		try {
			scoreList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){});
			for(Map<String, Object> map:list){
				Score score=new Score();
				String scoreid=map.get("ScoreID").toString();
				score.setScoreID(scoreid);
				score.setScore(map.get("score").toString());
				score.setCourseID(map.get("CourseID").toString());
			   Student student=new Student();
			   student.setStuName(map.get("stuName").toString());
			   score.setStudent(student);
			   Course course=new Course();
			   course.setCourseName(map.get("CourseName").toString());
			   score.setCourse(course);
				score.setStuId(map.get("StuId").toString());
				scoreList.add(score);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scoreList;
	}

	@Override
	public Score findByScorename(String scorename) {
		String sql = "SELECT * FROM t_score WHERE score=?";
		Score score = null;
		try {
			score = queryRunner.query(sql, new BeanHandler<Score>(Score.class){}, scorename);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}

	@Override
	public List<Score> findByidscore(String id) {
		String sql = "SELECT r.score,r.CourseID,r.ScoreID,r.StuId,s.StuName,c.CourseName from t_score r ,tb_student s ,t_course c where "
				+ " r.StuId=s.StuId and r.CourseID=c.CourseID and  s.StuId=?";
		List<Score> scoreList = null;
		try {
			scoreList=new ArrayList<>();
			List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(){},id);
			for(Map<String, Object> map:list){
				Score score=new Score();
				String scoreid=map.get("ScoreID").toString();
				score.setScoreID(scoreid);
				score.setScore(map.get("score").toString());
				score.setCourseID(map.get("CourseID").toString());
			   Student student=new Student();
			   student.setStuName(map.get("stuName").toString());
			   score.setStudent(student);
			   Course course=new Course();
			   course.setCourseName(map.get("CourseName").toString());
			   score.setCourse(course);
				score.setStuId(map.get("StuId").toString());
				scoreList.add(score);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scoreList;
	}
	

}
