package com.roncoo.education.course.service.api.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.dao.impl.mapper.entity.Skill;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import com.roncoo.education.common.core.tools.BeanUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 课程信息
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProgramSkillFullDTO implements Serializable {

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

    @ApiModelProperty(value = "list of skill")
    private List<SkillDTO> skillDTOList;

    public void setProgram(Program program){
        this.id = program.getId();
        this.sort = program.getSort();
        this.programName = program.getProgramName();
        this.programLogo = program.getProgramLogo();
        this.description = program.getDescription();
    }
    public void setSkillDTO(List<Skill> skillList){
        List<SkillDTO> curSkillDTOList = new ArrayList();
        for(Skill skill : skillList){
        SkillDTO skillDTO = BeanUtil.copyProperties(skill,SkillDTO.class);
        curSkillDTOList.add(skillDTO);
        }
        this.skillDTOList = curSkillDTOList;
    }
}

