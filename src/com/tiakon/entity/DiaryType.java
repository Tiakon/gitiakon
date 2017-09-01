package com.tiakon.entity;

import java.io.Serializable;

/**
 * Created by Hoictas on 2017/8/14.
 */
public class DiaryType implements Serializable {
    private int diaryTypeID;
    private String typeName;
    private int diaryTypeCount;

    public DiaryType() {
    }

    public DiaryType(int diaryTypeID, String typeName, int diaryTypeCount) {
        this.diaryTypeID = diaryTypeID;
        this.typeName = typeName;
        this.diaryTypeCount = diaryTypeCount;
    }

    public DiaryType(int diaryTypeID, String typeName) {
        this.diaryTypeID = diaryTypeID;
        this.typeName = typeName;
    }

    public int getDiaryTypeID() {
        return diaryTypeID;
    }

    public void setDiaryTypeID(int diaryTypeID) {
        this.diaryTypeID = diaryTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getDiaryTypeCount() {
        return diaryTypeCount;
    }

    public void setDiaryTypeCount(int diaryTypeCount) {
        this.diaryTypeCount = diaryTypeCount;
    }

    @Override
    public String toString() {
        return "DiaryType{" +
                "diaryTypeID=" + diaryTypeID +
                ", typeName='" + typeName + '\'' +
                ", diaryTypeCount=" + diaryTypeCount +
                '}';
    }
}
