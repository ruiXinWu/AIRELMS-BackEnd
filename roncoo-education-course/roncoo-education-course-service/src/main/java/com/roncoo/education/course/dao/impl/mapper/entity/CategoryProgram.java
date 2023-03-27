package com.roncoo.education.course.dao.impl.mapper.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
public class CategoryProgram implements Serializable{
    private Long id;

    private Long categoryId;

    private String categoryName;

    private Long programId;

    @Override
    public String toString() {
        return "CategoryProgram{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", programId=" + programId +
                ", programName='" + programName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    private String programName;


}
