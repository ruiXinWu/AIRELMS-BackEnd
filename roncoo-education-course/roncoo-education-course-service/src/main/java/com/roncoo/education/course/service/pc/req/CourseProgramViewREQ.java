package com.roncoo.education.course.service.pc.req;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CourseProgramViewREQ implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "当前页", required = true)
    private int pageCurrent = 1;

    @ApiModelProperty(value = "每页记录数", required = true)
    private int pageSize = 20;

    @ApiModelProperty(value = "program_id", required = false)
    private Long programId;

    public Long getProgramId() {
        return programId;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }




}
