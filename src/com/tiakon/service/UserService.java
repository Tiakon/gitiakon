package com.tiakon.service;

import com.tiakon.entity.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Hoictas on 2017/8/8.
 */
public interface UserService {
    User login(User user) throws SQLException;

    User showUser(User currentUser) throws SQLException, IOException;
}
