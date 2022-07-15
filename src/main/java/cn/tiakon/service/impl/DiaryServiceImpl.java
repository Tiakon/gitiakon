package cn.tiakon.service.impl;

import cn.tiakon.entity.Diary;
import cn.tiakon.entity.DiaryType;
import cn.tiakon.entity.PageBean;
import cn.tiakon.service.DiaryService;
import cn.tiakon.dao.DiaryDao;
import cn.tiakon.dao.impl.DiaryDaoImpl;
import cn.tiakon.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/11.
 */
public class DiaryServiceImpl implements DiaryService {
    private Connection connection = null;
    private List<Diary> diaryList = null;
    private List<DiaryType> diaryTypeList = null;
    private DiaryDao diaryDao = new DiaryDaoImpl();
    private int totalNumber = 0;
    private int lineNumber = 0;
    private int flag = -1;
    private Diary diary = null;

    @Override
    public List<Diary> diaryList(PageBean pageBean, Diary diaryParam) throws SQLException {
        try {
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            diaryList = diaryDao.diaryList(pageBean, connection, diaryParam);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return diaryList;
    }

    @Override
    public int diaryCount(Diary diaryParam) throws SQLException {
        try {
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            totalNumber = diaryDao.diaryCount(connection, diaryParam);
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }

        return totalNumber;
    }

/*    @Override
    public List<DiaryType> diaryTypeList() throws SQLException {

        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            diaryTypeList = diaryDao.diaryTypeList(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, null, connection);
        }
        return diaryTypeList;
    }*/

    @Override
    public List<Diary> diaryDateList() throws SQLException {

        try {
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            diaryList = diaryDao.diaryDateList(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }

        return diaryList;
    }

    @Override
    public Diary diaryShow(String diaryIdParam) throws SQLException {
        connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            diary = diaryDao.diaryShow(connection, diaryIdParam);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return diary;
    }

    @Override
    public int diaryAdd(Diary diaryInput) throws SQLException {
        connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            flag = diaryDao.diaryAdd(connection, diaryInput);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();

        } finally {
            JdbcUtil.close(null, null, connection);
        }
        return flag;
    }

    @Override
    public int diaryDelete(String diaryIdParam) throws SQLException {
        connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryDao.diaryDelete(connection, diaryIdParam);
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
    public int diaryUpdate(Diary diaryInput) throws SQLException {
        connection = JdbcUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            lineNumber = diaryDao.diaryUpdate(connection, diaryInput);
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
