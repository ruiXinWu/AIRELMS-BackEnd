package com.roncoo.education.course.dao.impl.mapper.entity;

import java.io.Serializable;

public class OfficeHour implements Serializable {
    private Long id;
    private String url;
    private long programId;

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

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    @Override
    public String toString() {
        return "OfficeHour{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", programId=" + programId +
                '}';
    }


}
