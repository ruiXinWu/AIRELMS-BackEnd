package com.roncoo.education.course.service.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目信息
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProgramPageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "项目ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String programName;
    /**
     * 项目封面
     */
    @ApiModelProperty(value = "项目LOGO")
    private String programLogo;
    /**
     * 课程编号
     */
    @ApiModelProperty(value = "课程ID")
    private String courseId;
    /**
     * 项目描述
     */
    @ApiModelProperty(value = "项目描述")
    private String description;


}
