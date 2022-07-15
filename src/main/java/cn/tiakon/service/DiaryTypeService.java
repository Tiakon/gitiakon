package cn.tiakon.service;

import cn.tiakon.entity.DiaryType;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/20.
 */
public interface DiaryTypeService {

    List<DiaryType> diaryTypeCountList() throws SQLException;

    int diaryTypeDelete(int diaryTypeIdParam) throws SQLException;

    int diaryTypeAdd(String diaryTypeNameInput) throws SQLException;

    int diaryTypeUpdate(DiaryType diaryType) throws SQLException;

}
