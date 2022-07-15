package cn.tiakon.service.impl;

import cn.tiakon.service.UserService;
import cn.tiakon.dao.UserDao;
import cn.tiakon.dao.impl.UserDaoImpl;
import cn.tiakon.entity.User;
import cn.tiakon.utils.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Hoictas on 2017/8/8.
 */
public class UserServiceImpl implements UserService {
    private Connection connection = JdbcUtil.getConnection();
    private UserDao userDao = new UserDaoImpl();
    private User resultSetUser = null;

    private boolean flag = false;

    @Override
    public User login(User user) throws SQLException {
        try {
            connection.setAutoCommit(false);
            resultSetUser = userDao.login(connection, user);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return resultSetUser;
    }

    @Override
    public User userPreSave(User currentUser) throws SQLException, IOException {
        try {
            connection.setAutoCommit(false);
            resultSetUser = userDao.userPreSave(connection, currentUser);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return resultSetUser;
    }

    @Override
    public boolean userSave(User modUser) throws SQLException {
        try {
            connection.setAutoCommit(false);
            flag = userDao.userSave(connection, modUser);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return flag;
    }
}
