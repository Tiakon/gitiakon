package com.tiakon.service.impl;

import com.tiakon.dao.DiaryTypeDao;
import com.tiakon.dao.impl.DiaryTypeDaoImpl;
import com.tiakon.entity.DiaryType;
import com.tiakon.service.DiaryTypeService;
import com.tiakon.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/20.
 */
public class DiaryTypeServiceImpl implements DiaryTypeService {
    private DiaryTypeDao diaryTypeDao = new DiaryTypeDaoImpl();
    private List<DiaryType> diaryTypeList = null;

    private Connection connection = null;
    private int lineNumber = 0;

    @Override
    public List<DiaryType> diaryTypeCountList() throws SQLException {

        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            diaryTypeList = diaryTypeDao.diaryTypeCountList(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, null, connection);
        }
        return diaryTypeList;
    }

    @Override
    public int diaryTypeDelete(int diaryTypeIdParam) throws SQLException {
        connection = JDBCUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryTypeDao.diaryTypeDelete(connection, diaryTypeIdParam);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, null, connection);
        }

        return lineNumber;
    }

    @Override
    public int diaryTypeAdd(String diaryTypeNameInput) throws SQLException {
        connection = JDBCUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryTypeDao.diaryTypeAdd(connection, diaryTypeNameInput);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, null, connection);
        }
        return lineNumber;
    }

    @Override
    public int diaryTypeUpdate(DiaryType diaryType) throws SQLException {
        connection = JDBCUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryTypeDao.diaryTypeUpdate(connection, diaryType);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, null, connection);
        }
        return lineNumber;
    }
}
