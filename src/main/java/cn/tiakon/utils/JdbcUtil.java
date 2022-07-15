package cn.tiakon.utils;

import java.sql.*;

/**
 * @author tiankai.me@gmail.com on 2022/7/16 1:11.
 */
public class JdbcUtil {

    static {
        try {
            Class.forName(PropertiesUtil.getValue("driverClassName"));
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    private JdbcUtil() {
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            final String url = PropertiesUtil.getValue("url");
            final String user = PropertiesUtil.getValue("user");
            final String password = PropertiesUtil.getValue("password");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
