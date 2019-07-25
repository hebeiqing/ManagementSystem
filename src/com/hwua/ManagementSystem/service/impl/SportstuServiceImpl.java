package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.t_sportstudao;
import com.hwua.ManagementSystem.dao.impl.T_sportstudaoImpl;
import com.hwua.ManagementSystem.entity.T_sportstu;
import com.hwua.ManagementSystem.service.SportstuService;

public class SportstuServiceImpl implements SportstuService {

	private t_sportstudao soprtdao;
	
	public SportstuServiceImpl() {
		soprtdao=new T_sportstudaoImpl();
	}

	@Override
	public int create(T_sportstu t_sportstu) {
		// TODO Auto-generated method stub
		return soprtdao.create(t_sportstu);
	}

	@Override
	public int update(T_sportstu t_sportstu) {
		// TODO Auto-generated method stub
		return soprtdao.update(t_sportstu);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return soprtdao.delete(id);
	}

	@Override
	public T_sportstu findById(String id) {
		// TODO Auto-generated method stub
		return soprtdao.findById(id);
	}

	@Override
	public List<T_sportstu> findAll() {
		// TODO Auto-generated method stub
		return soprtdao.findAll();
	}

	@Override
	public T_sportstu findByT_sportstuname(String t_sportstuname) {
		// TODO Auto-generated method stub
		return soprtdao.findByT_sportstuname(t_sportstuname);
	}

}
