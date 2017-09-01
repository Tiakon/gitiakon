package com.tiakon.service;

import com.tiakon.entity.Diary;
import com.tiakon.entity.DiaryType;
import com.tiakon.entity.PageBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/11.
 */
public interface DiaryService {

    List<Diary> diaryList(PageBean pageBean,Diary diaryParam) throws Exception;

    int diaryCount(Diary diaryParam) throws SQLException;

//    List<DiaryType> diaryTypeList() throws SQLException;

    List<Diary> diaryDateList() throws SQLException;

    Diary diaryShow(String diaryIdParam) throws SQLException;

    int diaryAdd(Diary diaryInput) throws SQLException;

    int diaryDelete(String diaryIdParam) throws SQLException;

    int diaryUpdate(Diary diaryInput) throws SQLException;

}
