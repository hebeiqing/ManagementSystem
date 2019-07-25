package com.hwua.ManagementSystem.service;

import java.util.List;

import com.hwua.ManagementSystem.entity.T_sportstu;

public interface SportstuService {
	int create(T_sportstu t_sportstu);
	int update(T_sportstu t_sportstu);
	int delete(String id);
	T_sportstu findById(String id);
	List<T_sportstu> findAll();
	T_sportstu findByT_sportstuname(String t_sportstuname);
}
