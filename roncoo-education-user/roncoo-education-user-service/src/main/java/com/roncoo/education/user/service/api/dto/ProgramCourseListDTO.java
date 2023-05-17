package com.roncoo.education.user.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * program list with course list under each program
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProgramCourseListDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 项目集合
     */
    @ApiModelProperty(value = "program list with course list under each program")
    private List<ProgramCourseDTO> programCourseDTOList = new ArrayList();
}