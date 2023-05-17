package com.roncoo.education.user.service.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 课程信息
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProgramDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "项目ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String programName;
    /**
     * 项目LOGO
     */
    @ApiModelProperty(value = "项目LOGO")
    private String programLogo;

    /**
     * 项目描述
     */
    @ApiModelProperty(value = "项目描述")
    private String description;
}
