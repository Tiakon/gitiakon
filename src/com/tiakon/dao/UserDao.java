package com.tiakon.dao;

import com.tiakon.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Hoictas on 2017/8/8.
 */
public interface UserDao {
    User login(Connection connection, User user) throws SQLException;
}
