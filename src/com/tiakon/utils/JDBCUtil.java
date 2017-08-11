package com.tiakon.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static Properties prop = new Properties();

    static {
        try {

            // 加载驱动
            Class.forName(PropertiesUtil.getValue("driverClassName"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(PropertiesUtil.getValue("url"),
                    PropertiesUtil.getValue("user"),PropertiesUtil.getValue("password"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
