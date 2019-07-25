package com.hwua.ManagementSystem.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hwua.ManagementSystem.dao.Scoredao;
import com.hwua.ManagementSystem.dao.Studentdao;
import com.hwua.ManagementSystem.dao.Teacherdao;
import com.hwua.ManagementSystem.dao.UserDao;
import com.hwua.ManagementSystem.dao.impl.ScoreDaoImpl;
import com.hwua.ManagementSystem.dao.impl.StudentdaoImpl;
import com.hwua.ManagementSystem.dao.impl.TeachersDaoImpl;
import com.hwua.ManagementSystem.dao.impl.UserDaoImpl;
import com.hwua.ManagementSystem.entity.Score;
import com.hwua.ManagementSystem.entity.Student;
import com.hwua.ManagementSystem.entity.Teacher;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.service.ScoreService;
import com.hwua.ManagementSystem.service.UserService;
import com.hwua.ManagementSystem.util.CommonUtil;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	private Studentdao studentdao;
	private Teacherdao teacherdao;
	private  ScoreService scoreService;
		
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
		studentdao=new StudentdaoImpl();
		teacherdao=new TeachersDaoImpl();
		scoreService=new ScoreServiceImpl();
	
	}
	
	public Map<String, Object> adminLogin(String username, String password) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ok", false);
		if(username==null||username.equals("")||password==null||password.equals("")){
			resultMap.put("error", "用户名或密码不能为空！");
		}else{
			User user = userDao.findByUsername(username);
			if(user==null){
				resultMap.put("error", "用户名输入错误！");
			}else{
				if(user.getPassword().equals(password)){
					resultMap.put("ok", true);
					resultMap.put("loginAdmin", user);//把登录成功的管理员对象保存到map，带到servlet层保存到session中
				}else{
					resultMap.put("error", "密码输入错误！");
				}
			}
		}
		return resultMap;
	}

	public Map<String, Object> studnetLogin(String username, String password) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ok", false);
		
		//判断用户名是否存在
		Student student =studentdao.findByStudentname(username);
		Student stuidmsg = studentdao.findById(student.getStuId());
		List<Student> finByStudenCourse = studentdao.finByStudenCourse(student.getStuId());
		List<Student> finBysportsCourse = studentdao.finBysportsCourse(student.getStuId());
	     List<Score> findByidscore = scoreService.findByidscore(student.getStuId());
	       
		
		if( student!=null){
			if(student.getPassword().equals(password)){
				if(student.getType().equals("3")){
					resultMap.put("ok", true);
					resultMap.put("loginStudent", student);
					resultMap.put("stuidmsg", stuidmsg);
					resultMap.put("finByStudenCourse", finByStudenCourse);
					resultMap.put("findByidscore", findByidscore);
					resultMap.put("finBysportsCourse", finBysportsCourse);
					
				}else{
					resultMap.put("error", "登录失败！用户类型不匹配！");
				}
			}else{
				resultMap.put("error", "登录失败！密码不正确！");
			}
		}else{
			resultMap.put("error", "登录失败！用户名不存在！");
		}
		
		return resultMap;
	}

	
	
	
	@Override
	public Map<String, Object> teacherLogin(String username, String password) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ok", false);
		
		//判断用户名是否存在
		Teacher  teacher = teacherdao.findByTeachername(username);
		 List<Teacher> findByCourse = teacherdao.findByCourse(teacher.getTeacherId());
		 List<Teacher> findByStudent = teacherdao.findByStudent(teacher.getTeacherId()); //根据当前的教师id查询当前的选课学生
		 List<Teacher> findByscore = teacherdao.findByscore(teacher.getTeacherId());
		if(teacher!=null){
			if(teacher.getPassword().equals(password)){
				if(teacher.getType().equals("2")){
					resultMap.put("ok", true);
					resultMap.put("loginTeacher", teacher);
					resultMap.put("Teachercourse", findByCourse); //查询当前老师教学的课程
					resultMap.put("TeacherStudent", findByStudent);//查询当前的老师所教课程的学生
					resultMap.put("findByscore", findByscore);
					
				}else{
					resultMap.put("error", "登录失败！该用户类型不匹配！");
				}
			}else{
				resultMap.put("error", "登录失败！密码不正确！");
			}
		}else{
			resultMap.put("error", "登录失败！用户名不存在！");
		}
		
		return resultMap;
	}
	
	
	
	
	
	
	public Map<String, Object> userRegister(String username, String password, String mobile, String sex) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ok", false);
		
		//判断用户名是否已被注册
		User user = userDao.findByUsername(username);
		if(user==null){
			user = new User();
			user.setId(CommonUtil.getUUID());
			user.setUsername(username);
			user.setPassword(password);
			user.setMobile(mobile);
			user.setSex(sex);
			user.setType(1);//设置类型为1，就是管理员
			user.setCreateTime(new Date());
			//保存到数据库
			int row = userDao.create(user);
			if(row>0){
				resultMap.put("ok", true);
			}else{
				resultMap.put("error", "注册失败！请联系网站管理员！");
			}
		}else{
			resultMap.put("error", "注册失败！此用户已被注册！");
		}
		return resultMap;
	}

	

}
