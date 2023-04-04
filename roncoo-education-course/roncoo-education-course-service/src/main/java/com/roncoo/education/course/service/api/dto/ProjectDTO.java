package com.roncoo.education.course.service.api.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProjectDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "project ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long projectId;

    @ApiModelProperty(value = "名称")
    private String projectName;

    @ApiModelProperty(value = "描述")
    private String projectDescription;

    @ApiModelProperty(value = "链接")
    private String projectUrl;

    @ApiModelProperty(value = "图片")
    private String projectPicture;


}
