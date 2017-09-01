package com.tiakon.dao.impl;

import com.tiakon.dao.DiaryTypeDao;
import com.tiakon.entity.DiaryType;
import com.tiakon.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/20.
 */
public class DiaryTypeDaoImpl implements DiaryTypeDao {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private List<DiaryType> diaryTypeList = null;
    private DiaryType diaryType = null;
    private int lineNumber = 0;

    @Override
    public List<DiaryType> diaryTypeCountList(Connection connection) throws SQLException {
        String sql = "SELECT t_diarytype.`diary_typeid`,  t_diarytype.`typename`,  COUNT(t_diary.`title`) AS `count` FROM  t_diary  RIGHT JOIN t_diarytype ON t_diary.`typeid` = t_diarytype.`diary_typeid` GROUP BY t_diarytype.`typename` ORDER BY diary_typeid DESC";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        diaryTypeList = new ArrayList<DiaryType>();
        while (resultSet.next()) {
            diaryType = new DiaryType();
            diaryType.setDiaryTypeID(resultSet.getInt("diary_typeid"));
            diaryType.setTypeName(resultSet.getString("typename"));
            diaryType.setDiaryTypeCount(resultSet.getInt("count"));
            diaryTypeList.add(diaryType);
        }
        return diaryTypeList;
    }

    @Override
    public int diaryTypeDelete(Connection connection, int diaryTypeIdParam) throws SQLException {
        String sql = " DELETE FROM t_diarytype WHERE diary_typeid = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, diaryTypeIdParam);
            lineNumber = preparedStatement.executeUpdate();

        } finally {
            JDBCUtil.close(resultSet, preparedStatement, null);
        }

        return lineNumber;
    }

    @Override
    public int diaryTypeAdd(Connection connection, String diaryTypeNameInput) throws SQLException {
        String sql = " INSERT INTO t_diarytype(typename) VALUE (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diaryTypeNameInput);
            lineNumber = preparedStatement.executeUpdate();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, null);
        }

        return lineNumber;
    }

    @Override
    public int diaryTypeUpdate(Connection connection, DiaryType diaryType) throws SQLException {
        String sql = " UPDATE t_diarytype SET typename=? WHERE diary_typeid=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diaryType.getTypeName());
            preparedStatement.setInt(2, diaryType.getDiaryTypeID());
            lineNumber = preparedStatement.executeUpdate();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, null);
        }

        return lineNumber;
    }
}
