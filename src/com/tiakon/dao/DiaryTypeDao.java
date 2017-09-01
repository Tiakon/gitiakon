package com.tiakon.dao;

import com.tiakon.entity.DiaryType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/20.
 */
public interface DiaryTypeDao {


    List<DiaryType> diaryTypeCountList(Connection connection) throws SQLException;

    int diaryTypeDelete(Connection connection, int diaryTypeIdParam) throws SQLException;

    int diaryTypeAdd(Connection connection, String diaryTypeNameInput) throws SQLException;

    int diaryTypeUpdate(Connection connection, DiaryType diaryType) throws SQLException;

}
