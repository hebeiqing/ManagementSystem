package com.hwua.ManagementSystem.dao;

import java.util.List;

import com.hwua.ManagementSystem.entity.Major;
public interface MajorDao {
	int create(Major major);
	int update(Major major);
	int delete(String id);
	Major findById(String id);
	List<Major> findAll();
	Major findByMajorname(String majorname);
}
