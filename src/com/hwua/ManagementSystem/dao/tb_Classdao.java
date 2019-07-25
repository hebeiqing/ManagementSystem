package com.hwua.ManagementSystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hwua.ManagementSystem.entity.tb_Class;
public interface tb_Classdao {
	int create(tb_Class tb_Class);
	int update(tb_Class tb_Class);
	int delete(String id);
	tb_Class findById(String id);
	List<tb_Class> findAll();
	tb_Class findBytb_Classname(String tb_Classname);
}
