package com.hwua.ManagementSystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.ManagementSystem.dao.UserDao;
import com.hwua.ManagementSystem.entity.User;
import com.hwua.ManagementSystem.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	private QueryRunner queryRunner = JDBCUtil.getQueryRunner();
	
	public int create(User user) {
		String sql = "INSERT INTO t_user(id,username,password,sex,mobile,create_time,type,status) "
				+ "VALUES(?,?,?,?,?,?,?,1)";
		int row = 0;
		try {
			row = queryRunner.update(sql, user.getId(), user.getUsername(), user.getPassword(),
					user.getSex(), user.getMobile(), user.getCreateTime(), user.getType());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int update(User user) {
		String sql = "UPDATE t_user SET password=?,sex=?,mobile=? WHERE id=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, user.getPassword(), user.getSex(),user.getMobile(), user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int delete(String id) {
		// 假删除，就是不真正删除数据，只是把数据的状态修改为0
		String sql = "UPDATE t_user SET status=0 WHERE id=?";
		int row = 0;
		try {
			row = queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public User findById(String id) {
		String sql = "SELECT * FROM t_user WHERE id=?";
		User user = null;
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){}, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> findAll() {
		String sql = "SELECT * FROM t_user WHERE status=1";
		List<User> userList = null;
		try {
			userList = queryRunner.query(sql, new BeanListHandler<User>(User.class,
					new BasicRowProcessor(new GenerousBeanProcessor())){});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public User findByUsername(String username) {
		String sql = "SELECT * FROM t_user WHERE username=?";
		User user = null;
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class){}, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
