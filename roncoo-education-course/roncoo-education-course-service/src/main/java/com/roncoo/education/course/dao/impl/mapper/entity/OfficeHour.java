package com.roncoo.education.course.dao.impl.mapper.entity;

import java.io.Serializable;

public class OfficeHour implements Serializable {
    private Long id;
    
    private String url;

    private Long lecturerId;

    private Long programId;

    private String officeHourUrl;

    private String lectureLogo;

    private String lectureName;

    private String  lectureIntroduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getOfficeHourUrl() {
        return officeHourUrl;
    }

    public void setOfficeHourUrl(String officeHourUrl) {
        this.officeHourUrl = officeHourUrl;
    }

    public String getLectureLogo() {
        return lectureLogo;
    }

    public void setLectureLogo(String lectureLogo) {
        this.lectureLogo = lectureLogo;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureIntroduction() {
        return lectureIntroduction;
    }

    public void setLectureIntroduction(String lectureIntroduction) {
        this.lectureIntroduction = lectureIntroduction;
    }

    @Override
    public String toString() {
        return "OfficeHour{" +
                "id=" + id +
                ", lecturerId=" + lecturerId +
                ", programId=" + programId +
                ", officeHourUrl='" + officeHourUrl + '\'' +
                ", lectureLogo='" + lectureLogo + '\'' +
                ", lectureName='" + lectureName + '\'' +
                ", lectureIntroduction='" + lectureIntroduction + '\'' +
                '}';
    }
}
