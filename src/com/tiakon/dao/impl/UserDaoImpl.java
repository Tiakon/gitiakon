package com.tiakon.dao.impl;

import com.tiakon.dao.UserDao;
import com.tiakon.entity.User;
import com.tiakon.utils.JDBCUtil;
import com.tiakon.utils.MD5Util;
import com.tiakon.utils.PropertiesUtil;

import java.io.IOException;
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

    private boolean flag = false;

    @Override
    public User login(Connection connection, User user) throws Exception {
        try {
            String sql_query = "SELECT * FROM t_user WHERE username=? AND password =?";
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, MD5Util.getEncoderStrByMD5(user.getPassword()));
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSetUser = new User();
                resultSetUser.setUserId(resultSet.getInt("user_id"));
                resultSetUser.setUserName(resultSet.getString("username"));
                resultSetUser.setPassword(resultSet.getString("password"));
                resultSetUser.setNickName(resultSet.getString("nickname"));
                resultSetUser.setImageName(PropertiesUtil.getValue("userImage") + resultSet.getString("imagename"));
                resultSetUser.setMood(resultSet.getString("mood"));
            }
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, null);
        }
        return resultSetUser;
    }

    @Override
    public User userPreSave(Connection connection, User currentUser) throws SQLException, IOException {
        try {
            String sql = "SELECT * FROM t_user WHERE user_id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, currentUser.getUserId());
            resultSet = preparedStatement.executeQuery();
            resultSetUser = new User();
            if (resultSet.next()) {
                resultSetUser.setUserId(resultSet.getInt("user_id"));
                resultSetUser.setUserName(resultSet.getString("username"));
                resultSetUser.setPassword(resultSet.getString("password"));
                resultSetUser.setNickName(resultSet.getString("nickname"));
                resultSetUser.setImageName(PropertiesUtil.getValue("userImage") + resultSet.getString("imagename"));
                resultSetUser.setMood(resultSet.getString("mood"));
            }
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, null);
        }
        return resultSetUser;
    }

    @Override
    public boolean userSave(Connection connection, User modUser) throws SQLException {
        try {

            String sql = "UPDATE t_user SET nickname=?,imagename=?,mood=? WHERE user_id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, modUser.getNickName());
            preparedStatement.setString(2, modUser.getImageName());
            preparedStatement.setString(3, modUser.getMood());
            preparedStatement.setInt(4, modUser.getUserId());
            int lineNumber = preparedStatement.executeUpdate();

            if (lineNumber > 0) {
                flag = true;
            }
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, null);
        }
        return flag;
    }
}
