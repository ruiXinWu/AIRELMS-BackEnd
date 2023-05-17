package com.roncoo.education.user.dao.impl.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class UserCourse implements Serializable {

    private long id;

    private long userId;

    private long courseId;

    private int courseStatus;


    private static final long serialVersionUID = 1L;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public int getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(int courseStatus) {
        this.courseStatus = courseStatus;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", courseStatus=" + courseStatus +
                '}';
    }
}
