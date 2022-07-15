package cn.tiakon.service.impl;

import cn.tiakon.dao.impl.DiaryTypeDaoImpl;
import cn.tiakon.entity.DiaryType;
import cn.tiakon.service.DiaryTypeService;
import cn.tiakon.dao.DiaryTypeDao;
import cn.tiakon.utils.JdbcUtil;

import java.sql.Connection;
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
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            diaryTypeList = diaryTypeDao.diaryTypeCountList(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return diaryTypeList;
    }

    @Override
    public int diaryTypeDelete(int diaryTypeIdParam) throws SQLException {
        connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryTypeDao.diaryTypeDelete(connection, diaryTypeIdParam);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }

        return lineNumber;
    }

    @Override
    public int diaryTypeAdd(String diaryTypeNameInput) throws SQLException {
        connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryTypeDao.diaryTypeAdd(connection, diaryTypeNameInput);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return lineNumber;
    }

    @Override
    public int diaryTypeUpdate(DiaryType diaryType) throws SQLException {
        connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryTypeDao.diaryTypeUpdate(connection, diaryType);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return lineNumber;
    }
}
