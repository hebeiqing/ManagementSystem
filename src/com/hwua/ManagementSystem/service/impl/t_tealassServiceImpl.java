package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.t_tealassdao;
import com.hwua.ManagementSystem.dao.impl.t_tealassdaoImpl;
import com.hwua.ManagementSystem.entity.t_tealass;
import com.hwua.ManagementSystem.service.t_tealassService;

public class t_tealassServiceImpl implements t_tealassService {
	
	private t_tealassdao dao;
	
	public t_tealassServiceImpl() {
		dao=new t_tealassdaoImpl();
	}
	
	

	@Override
	public int create(t_tealass t_tealass) {
		// TODO Auto-generated method stub
		return dao.create(t_tealass);
	}

	@Override
	public int update(t_tealass t_tealass) {
		// TODO Auto-generated method stub
		return dao.update(t_tealass);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public t_tealass findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<t_tealass> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public t_tealass findByt_tealassname(String t_tealassname) {
		// TODO Auto-generated method stub
		return null;
	}

}
