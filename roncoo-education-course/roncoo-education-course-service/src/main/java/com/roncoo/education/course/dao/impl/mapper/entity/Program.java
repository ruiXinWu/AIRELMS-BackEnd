package com.roncoo.education.course.dao.impl.mapper.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Program implements Serializable {
    private Long id;

    private Integer sort;

    private String programName;

    private String programLogo;


    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getProgramLogo() {
        return programLogo;
    }

    public void setProgramLogo(String programLogo) {
        this.programLogo = programLogo == null ? null : programLogo.trim();
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName == null ? null : programName.trim();
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", sort=" + sort +
                ", programName='" + programName + '\'' +
                ", programLogo='" + programLogo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}

