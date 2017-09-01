package com.tiakon.dao;

import com.tiakon.entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Hoictas on 2017/8/8.
 */
public interface UserDao {
    User login(Connection connection, User user) throws Exception;

    User showUser(Connection connection,User currentUser) throws SQLException, IOException;

}
