package com.roncoo.education.user.dao.impl.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class UserProgram implements Serializable {
    private Long id;
    private Long userId;
    private Long programId;
    private Date sliceDate;

    public Date getSliceDate() {
        return sliceDate;
    }

    public void setSliceDate(Date sliceDate) {
        this.sliceDate = sliceDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProgramId() {
        return programId;
    }

    @Override
    public String toString() {
        return "UserProgram{" +
                "id=" + id +
                ", userId=" + userId +
                ", programId=" + programId +
                ", sliceDate=" + sliceDate +
                '}';
    }
}
