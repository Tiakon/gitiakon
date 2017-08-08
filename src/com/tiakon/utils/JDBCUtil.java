package com.tiakon.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private static Properties prop = new Properties();
	private static ThreadLocal<Connection> tcl = new ThreadLocal<Connection>();
	static {
		try {
			prop.load(JDBCUtil.class
					.getResourceAsStream("/com/tiakon/conf/jdbc.properties"));
			// 加载驱动
			Class.forName(prop.getProperty("driverClassName"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		Connection conn = tcl.get();
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("user"), prop.getProperty("password"));
				tcl.set(conn);
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return conn;
	}

	public static void close(ResultSet rs, PreparedStatement pstm,
			Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		if (pstm != null)
			try {
				pstm.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		if (conn != null)
			try {
				tcl.remove();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
}
