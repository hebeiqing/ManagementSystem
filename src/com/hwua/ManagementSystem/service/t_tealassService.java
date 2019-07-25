package com.hwua.ManagementSystem.service;

import java.util.List;

import com.hwua.ManagementSystem.entity.t_tealass;
public interface t_tealassService {
	int create(t_tealass t_tealass);
	int update(t_tealass t_tealass);
	int delete(String id);
	t_tealass findById(String id);
	List<t_tealass> findAll();
	t_tealass findByt_tealassname(String t_tealassname);
}
