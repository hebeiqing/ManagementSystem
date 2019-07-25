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
			resultMap.put("error", "�û��������벻��Ϊ�գ�");
		}else{
			User user = userDao.findByUsername(username);
			if(user==null){
				resultMap.put("error", "�û����������");
			}else{
				if(user.getPassword().equals(password)){
					resultMap.put("ok", true);
					resultMap.put("loginAdmin", user);//�ѵ�¼�ɹ��Ĺ���Ա���󱣴浽map������servlet�㱣�浽session��
				}else{
					resultMap.put("error", "�����������");
				}
			}
		}
		return resultMap;
	}

	public Map<String, Object> studnetLogin(String username, String password) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ok", false);
		
		//�ж��û����Ƿ����
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
					resultMap.put("error", "��¼ʧ�ܣ��û����Ͳ�ƥ�䣡");
				}
			}else{
				resultMap.put("error", "��¼ʧ�ܣ����벻��ȷ��");
			}
		}else{
			resultMap.put("error", "��¼ʧ�ܣ��û��������ڣ�");
		}
		
		return resultMap;
	}

	
	
	
	@Override
	public Map<String, Object> teacherLogin(String username, String password) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ok", false);
		
		//�ж��û����Ƿ����
		Teacher  teacher = teacherdao.findByTeachername(username);
		 List<Teacher> findByCourse = teacherdao.findByCourse(teacher.getTeacherId());
		 List<Teacher> findByStudent = teacherdao.findByStudent(teacher.getTeacherId()); //���ݵ�ǰ�Ľ�ʦid��ѯ��ǰ��ѡ��ѧ��
		 List<Teacher> findByscore = teacherdao.findByscore(teacher.getTeacherId());
		if(teacher!=null){
			if(teacher.getPassword().equals(password)){
				if(teacher.getType().equals("2")){
					resultMap.put("ok", true);
					resultMap.put("loginTeacher", teacher);
					resultMap.put("Teachercourse", findByCourse); //��ѯ��ǰ��ʦ��ѧ�Ŀγ�
					resultMap.put("TeacherStudent", findByStudent);//��ѯ��ǰ����ʦ���̿γ̵�ѧ��
					resultMap.put("findByscore", findByscore);
					
				}else{
					resultMap.put("error", "��¼ʧ�ܣ����û����Ͳ�ƥ�䣡");
				}
			}else{
				resultMap.put("error", "��¼ʧ�ܣ����벻��ȷ��");
			}
		}else{
			resultMap.put("error", "��¼ʧ�ܣ��û��������ڣ�");
		}
		
		return resultMap;
	}
	
	
	
	
	
	
	public Map<String, Object> userRegister(String username, String password, String mobile, String sex) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ok", false);
		
		//�ж��û����Ƿ��ѱ�ע��
		User user = userDao.findByUsername(username);
		if(user==null){
			user = new User();
			user.setId(CommonUtil.getUUID());
			user.setUsername(username);
			user.setPassword(password);
			user.setMobile(mobile);
			user.setSex(sex);
			user.setType(1);//��������Ϊ1�����ǹ���Ա
			user.setCreateTime(new Date());
			//���浽���ݿ�
			int row = userDao.create(user);
			if(row>0){
				resultMap.put("ok", true);
			}else{
				resultMap.put("error", "ע��ʧ�ܣ�����ϵ��վ����Ա��");
			}
		}else{
			resultMap.put("error", "ע��ʧ�ܣ����û��ѱ�ע�ᣡ");
		}
		return resultMap;
	}

	

}
