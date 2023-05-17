package com.roncoo.education.user.service.api.dto;

import com.roncoo.education.user.service.api.dto.CourseDTO;
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
public class CourseListDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 项目集合
     */
    @ApiModelProperty(value = "项目集合")
    private List<CourseDTO> courseList = new ArrayList();
}