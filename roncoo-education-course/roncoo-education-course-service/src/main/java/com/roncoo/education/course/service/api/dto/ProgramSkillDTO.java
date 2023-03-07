package com.roncoo.education.course.service.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ProgramSkill信息
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProgramSkillDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "ProgramSkillID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 排序
     */
    @ApiModelProperty(value = "ProgramID")
    private Long programId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "SkillID")
    private Long skillId;
    /**
     * 项目LOGO
     */
    @ApiModelProperty(value = "Program名称")
    private String programName;

    /**
     * 项目描述
     */
    @ApiModelProperty(value = "skill名称")
    private String skillName;
}

