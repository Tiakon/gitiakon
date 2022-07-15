package cn.tiakon.dao.impl;

import cn.tiakon.entity.Diary;
import cn.tiakon.entity.DiaryType;
import cn.tiakon.entity.PageBean;
import cn.tiakon.dao.DiaryDao;
import cn.tiakon.utils.DateUtil;
import cn.tiakon.utils.JdbcUtil;
import cn.tiakon.utils.StringUtil;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Hoictas on 2017/8/11.
 */
public class DiaryDaoImpl implements DiaryDao {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private StringBuffer stringBuffer = null;
    private ArrayList<Diary> diarieList = null;
    private ArrayList<DiaryType> diaryTypeList = null;
    private int totalNumber = 0;
    private int lineNumber = 0;
    private Diary diary = null;

    @Override
    public List<Diary> diaryList(PageBean pageBean, Connection connection, Diary diaryParam) throws Exception {

        try {
            connection = JdbcUtil.getConnection();
            stringBuffer = new StringBuffer("SELECT * FROM t_diary td,t_diarytype tdt WHERE td.`typeid`=tdt.`diary_typeid` ");
            //根据条件查询显示的记录数
            if (StringUtil.isNotEmpty(diaryParam.getTitle())) {
                stringBuffer.append("and td.`title` LIKE '%" + diaryParam.getTitle() + "%'");
            }
            if (diaryParam.getTypeId() != -1) {
                stringBuffer.append("and td.`typeid`='" + diaryParam.getTypeId() + "'");
            }
            if (StringUtil.isNotEmpty(diaryParam.getRelease_dateStr())) {
                stringBuffer.append("and DATE_FORMAT(`release_date`,'%Y年%m月') ='" + diaryParam.getRelease_dateStr() + "'");
            }
            stringBuffer.append(" ORDER BY release_date DESC ");
            if (pageBean != null) {
                stringBuffer.append(" LIMIT " + pageBean.getStart() + "," + pageBean.getPageSize());
            }
            preparedStatement = connection.prepareStatement(stringBuffer.toString());
            resultSet = preparedStatement.executeQuery();
            diarieList = new ArrayList<>();

            while (resultSet.next()) {
                Diary diary = new Diary();
                diary.setDiaryId(resultSet.getInt("diaryid"));
                diary.setTitle(resultSet.getString("title"));
                diary.setContent(resultSet.getString("content"));
                diary.setTypeId(resultSet.getInt("typeid"));
                diary.setRelease_date(DateUtil.formatString(resultSet.getString("release_date"), "yyyy-MM-dd HH:mm:ss"));
                diarieList.add(diary);
            }
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, null);
        }

        return diarieList;
    }

    @Override
    public int diaryCount(Connection connection, Diary diaryParam) throws SQLException {
        try {
            connection = JdbcUtil.getConnection();
            stringBuffer = new StringBuffer("SELECT count(*) as totalNumber FROM t_diary td,t_diarytype tdt WHERE td.`typeid`=tdt.`diary_typeid` ");
            //根据条件查询记录数
            if (StringUtil.isNotEmpty(diaryParam.getTitle())) {
                stringBuffer.append("and td.`title` LIKE '%" + diaryParam.getTitle() + "%'");
            }
            if (diaryParam.getTypeId() != -1) {
                stringBuffer.append("and td.`typeid`='" + diaryParam.getTypeId() + "'");
            }
            if (StringUtil.isNotEmpty(diaryParam.getRelease_dateStr())) {
                stringBuffer.append("and DATE_FORMAT(`release_date`,'%Y年%m月') ='" + diaryParam.getRelease_dateStr() + "'");
            }

            preparedStatement = connection.prepareStatement(stringBuffer.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                totalNumber = resultSet.getInt("totalNumber");
            }
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, null);
        }
        return totalNumber;
    }

   /* @Override
    public List<DiaryType> diaryTypeList(Connection connection) throws SQLException {
        String sql = "SELECT t_diarytype.`diary_typeid`,  t_diarytype.`typename`,  COUNT(t_diary.`title`) AS `count` FROM  t_diary  RIGHT JOIN t_diarytype ON t_diary.`typeid` = t_diarytype.`diary_typeid` GROUP BY t_diarytype.`typename` ORDER BY diary_typeid DESC";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        diaryTypeList = new ArrayList<DiaryType>();
        while (resultSet.next()) {
            DiaryType diaryType = new DiaryType();
            diaryType.setDiaryTypeID(resultSet.getInt("diary_typeid"));
            diaryType.setTypeName(resultSet.getString("typename"));
            diaryType.setDiaryTypeCount(resultSet.getInt("count"));
            diaryTypeList.add(diaryType);
        }
        return diaryTypeList;
    }*/

    @Override
    public List<Diary> diaryDateList(Connection connection) throws SQLException {
        String sql = "SELECT DATE_FORMAT(`release_date`,'%Y年%m月') AS 'release_date_str' ,COUNT(*) AS dairyDateCount FROM t_diary GROUP BY release_date_str  ORDER BY release_date_str DESC";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            diarieList = new ArrayList<>();
            while (resultSet.next()) {
                Diary diary = new Diary();
                diary.setRelease_dateStr(resultSet.getString("release_date_str"));
                diary.setDiaryDateCount(resultSet.getInt("dairyDateCount"));
                diarieList.add(diary);
            }
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, null);
        }

        return diarieList;
    }

    @Override
    public Diary diaryShow(Connection connection, String diaryIdParam) throws SQLException {
        String sql = "SELECT * FROM t_diary td,t_diarytype tdt WHERE td.`typeid`=tdt.`diary_typeid` AND td.`diaryid`=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diaryIdParam);
            resultSet = preparedStatement.executeQuery();
            diary = new Diary();
            while (resultSet.next()) {
                diary.setDiaryId(resultSet.getInt("diaryid"));
                diary.setTitle(resultSet.getString("title"));
                diary.setContent(resultSet.getString("content"));
                diary.setTypeId(resultSet.getInt("typeid"));
                diary.setTypeName(resultSet.getString("typename"));
                Timestamp release_date = resultSet.getTimestamp("release_date");
                Date dateUtil = new java.util.Date(release_date.getTime());
                //System.out.println("release_date:" + release_date);
                //System.out.println("dateUtil:" + dateUtil);
                diary.setRelease_dateStr(DateUtil.formatDate(dateUtil, "yyyy-MM-dd HH:mm:ss"));
                diary.setRelease_date(dateUtil);
                //System.out.println("Release_date:" + diary.getRelease_date());
                //System.out.println("Release_dateStr:" + diary.getRelease_dateStr());
            }
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, null);
        }
        return diary;
    }

    @Override
    public int diaryAdd(Connection connection, Diary diaryInput) throws SQLException {
        int lineNumber = 0;
        String sql = "INSERT INTO db_diary.t_diary(title,content,typeid,release_date) VALUES(?,?,?,now())";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diaryInput.getTitle());
            preparedStatement.setString(2, diaryInput.getContent());
            preparedStatement.setInt(3, diaryInput.getTypeId());
            lineNumber = preparedStatement.executeUpdate();
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, null);
        }
        return lineNumber;
    }

    @Override
    public int diaryDelete(Connection connection, String diaryIdParam) throws SQLException {
        String sql = "DELETE  FROM t_diary WHERE diaryid =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(diaryIdParam));
            lineNumber = preparedStatement.executeUpdate();
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, null);
        }
        return lineNumber;
    }

    @Override
    public int diaryUpdate(Connection connection, Diary diaryInput) throws SQLException {
        String sql = "UPDATE t_diary SET title=?,content=?,typeid=? WHERE diaryid=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diaryInput.getTitle());
            preparedStatement.setString(2, diaryInput.getContent());
            preparedStatement.setInt(3, diaryInput.getTypeId());
            preparedStatement.setInt(4, diaryInput.getDiaryId());
            lineNumber = preparedStatement.executeUpdate();
        } finally {
            JdbcUtil.close(resultSet, preparedStatement, null);
        }
        return lineNumber;
    }
}
