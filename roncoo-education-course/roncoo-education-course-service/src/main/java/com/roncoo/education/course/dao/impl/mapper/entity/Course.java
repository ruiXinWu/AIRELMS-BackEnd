package com.roncoo.education.course.dao.impl.mapper.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Course implements Serializable {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer statusId;

    private Integer sort;

    private Long lecturerUserNo;

    private Long categoryId1;

    private Long categoryId2;

    private Long categoryId3;

    private String courseName;

    private String courseLogo;

    private Long introduceId;

    private Integer isFree;

    private BigDecimal courseOriginal;

    private BigDecimal courseDiscount;

    private Integer isPutaway;

    private Integer courseSort;

    private Integer countBuy;

    private Integer countStudy;

    private Integer periodTotal;

    private String quiz;

    private Long programId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public void setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo == null ? null : courseLogo.trim();
    }

    public Long getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public BigDecimal getCourseOriginal() {
        return courseOriginal;
    }

    public void setCourseOriginal(BigDecimal courseOriginal) {
        this.courseOriginal = courseOriginal;
    }

    public BigDecimal getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(BigDecimal courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public Integer getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(Integer courseSort) {
        this.courseSort = courseSort;
    }

    public Integer getCountBuy() {
        return countBuy;
    }

    public void setCountBuy(Integer countBuy) {
        this.countBuy = countBuy;
    }

    public Integer getCountStudy() {
        return countStudy;
    }

    public void setCountStudy(Integer countStudy) {
        this.countStudy = countStudy;
    }

    public Integer getPeriodTotal() {
        return periodTotal;
    }

    public void setPeriodTotal(Integer periodTotal) {
        this.periodTotal = periodTotal;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz == null ? null : quiz.trim();
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", statusId=" + statusId +
                ", sort=" + sort +
                ", lecturerUserNo=" + lecturerUserNo +
                ", categoryId1=" + categoryId1 +
                ", categoryId2=" + categoryId2 +
                ", categoryId3=" + categoryId3 +
                ", courseName='" + courseName + '\'' +
                ", courseLogo='" + courseLogo + '\'' +
                ", introduceId=" + introduceId +
                ", isFree=" + isFree +
                ", courseOriginal=" + courseOriginal +
                ", courseDiscount=" + courseDiscount +
                ", isPutaway=" + isPutaway +
                ", courseSort=" + courseSort +
                ", countBuy=" + countBuy +
                ", countStudy=" + countStudy +
                ", periodTotal=" + periodTotal +
                ", quiz='" + quiz + '\'' +
                ", programId=" + programId +
                '}';
    }

}
