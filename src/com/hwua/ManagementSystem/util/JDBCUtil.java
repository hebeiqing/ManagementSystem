package com.hwua.ManagementSystem.util;

import java.sql.Connection;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	// 创建c3p0连接，整个项目有一个连接池就可以了，设为static只要实例化一次
	// 自动加载src目录下c3p0的配置文件【c3p0-config.xml】
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return dataSource;
	}

	// 创建DButils常用工具类QueryRunner的对象
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}

	//通过c3p0的数据源获取数据库连接对象
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
