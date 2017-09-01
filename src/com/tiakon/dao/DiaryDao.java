package com.tiakon.dao;

import com.tiakon.entity.Diary;
import com.tiakon.entity.DiaryType;
import com.tiakon.entity.PageBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/11.
 */
public interface DiaryDao {

    List<Diary> diaryList(PageBean pageBean, Connection connection,Diary diaryParam) throws Exception;

    int diaryCount(Connection connection,Diary diaryParam) throws SQLException;

//    List<DiaryType> diaryTypeList(Connection connection) throws SQLException;

    List<Diary> diaryDateList(Connection connection) throws SQLException;

    Diary diaryShow(Connection connection,String diaryIdParam) throws SQLException;

    int diaryAdd(Connection connection,Diary diaryInput) throws SQLException;

    int diaryDelete(Connection connection, String diaryIdParam) throws SQLException;

    int diaryUpdate(Connection connection, Diary diaryInput) throws SQLException;
}
