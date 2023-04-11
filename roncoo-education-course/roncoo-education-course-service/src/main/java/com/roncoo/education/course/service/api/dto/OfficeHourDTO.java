package com.roncoo.education.course.service.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class OfficeHourDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "教授id")
    private Long lecturerId;

    @ApiModelProperty(value = "项目ID")
    private Long programId;

    @ApiModelProperty(value = "连接")
    private String officeHourUrl;

    @ApiModelProperty(value = "logo连接")
    private String lectureLogo;

    @ApiModelProperty(value = "课程名称")
    private String lectureName;

    @ApiModelProperty(value = "课程介绍")
    private String lectureIntroduction;


}
