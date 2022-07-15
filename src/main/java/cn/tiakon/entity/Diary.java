package cn.tiakon.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hoictas on 2017/8/11.
 */
public class Diary implements Serializable {
    private int diaryId;
    private String title;
    private String content;
    private int typeId = -1;
    private String typeName;
    private Date release_date;
    private String release_dateStr;
    private int diaryDateCount;

    public Diary() {
    }

    public Diary(String title, String content, int typeId) {
        this.title = title;
        this.content = content;
        this.typeId = typeId;
    }

    public Diary(int diaryId, String title, String content, int typeId, String typeName, Date release_date, String release_dateStr, int diaryDateCount) {
        this.diaryId = diaryId;
        this.title = title;
        this.content = content;
        this.typeId = typeId;
        this.typeName = typeName;
        this.release_date = release_date;
        this.release_dateStr = release_dateStr;
        this.diaryDateCount = diaryDateCount;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getRelease_dateStr() {
        return release_dateStr;
    }

    public void setRelease_dateStr(String release_dateStr) {
        this.release_dateStr = release_dateStr;
    }

    public int getDiaryDateCount() {
        return diaryDateCount;
    }

    public void setDiaryDateCount(int diaryDateCount) {
        this.diaryDateCount = diaryDateCount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "diaryId=" + diaryId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", release_date=" + release_date +
                ", release_dateStr='" + release_dateStr + '\'' +
                ", diaryDateCount=" + diaryDateCount +
                '}';
    }
}
