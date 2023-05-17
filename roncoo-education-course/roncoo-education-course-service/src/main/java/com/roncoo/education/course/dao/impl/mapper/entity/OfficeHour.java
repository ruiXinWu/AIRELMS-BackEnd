package com.roncoo.education.course.dao.impl.mapper.entity;

import java.io.Serializable;

public class OfficeHour implements Serializable {
    private Long id;

    private Long lecturerId;

    private Long programId;

    private String officeHourUrl;

    private String headImgUrl;

    private String lecturerName;

    private String  introduce;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "OfficeHour{" +
                "id=" + id +
                ", lecturerId=" + lecturerId +
                ", programId=" + programId +
                ", officeHourUrl='" + officeHourUrl + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}