package com.roncoo.education.course.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目集合
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProjectListDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 项目集合
     */
    @ApiModelProperty(value = "Project集合")
    private List<ProjectDTO> list = new ArrayList<>();
}
