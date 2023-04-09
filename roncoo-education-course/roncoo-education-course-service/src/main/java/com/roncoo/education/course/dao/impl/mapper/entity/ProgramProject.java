package com.roncoo.education.course.dao.impl.mapper.entity;

import java.io.Serializable;

public class ProgramProject implements Serializable {
    private Long id;
    private Long programId;
    private Long projectId;

    @Override
    public String toString() {
        return "ProgramProject{" +
                "id=" + id +
                ", programId=" + programId +
                ", projectId=" + projectId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}