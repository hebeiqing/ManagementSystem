package com.hwua.ManagementSystem.service.impl;

import java.util.List;

import com.hwua.ManagementSystem.dao.MajorDao;
import com.hwua.ManagementSystem.dao.impl.MajorDaoImpl;
import com.hwua.ManagementSystem.entity.Major;
import com.hwua.ManagementSystem.service.MajorService;

public class MajorServiceImpl  implements MajorService{
  
	private MajorDao majorDao;
	
	public MajorServiceImpl() {
		majorDao=new MajorDaoImpl();
	}
	
	
	@Override
	public int create(Major major) {
		return majorDao.create(major);
	}

	@Override
	public int update(Major major) {
		return majorDao.update(major);
	}

	@Override
	public int delete(String id) {
		return majorDao.delete(id);
	}

	@Override
	public Major findById(String id) {
		return majorDao.findById(id);
	}

	@Override
	public List<Major> findAll() {
		return majorDao.findAll();
	}

	@Override
	public Major findByMajorname(String majorname) {
		return majorDao.findByMajorname(majorname);
	}

	public static void main(String[] args) {
		MajorServiceImpl ma= new MajorServiceImpl();
		List<Major> findAll = ma.findAll();
		System.out.println(findAll);
	}
}
