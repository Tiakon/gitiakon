package com.tiakon.dao.impl;

import com.tiakon.dao.UserDao;
import com.tiakon.entity.User;
import com.tiakon.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Hoictas on 2017/8/8.
 */
public class UserDaoImpl implements UserDao {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private User resultSetUser = null;

    @Override
    public User login(Connection connection, User user) throws SQLException {
        try {
            String sql_query = "SELECT * FROM t_user WHERE username=? AND password =?";
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSetUser = new User();
                resultSetUser.setUserName(resultSet.getString("username"));
                resultSetUser.setPassword(resultSet.getString("password"));
            }
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, null);
        }
        return resultSetUser;
    }
}
