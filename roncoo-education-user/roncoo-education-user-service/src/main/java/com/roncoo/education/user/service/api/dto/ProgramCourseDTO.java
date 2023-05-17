package com.roncoo.education.user.service.api.dto;

import com.roncoo.education.user.service.api.dto.CourseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Course List for a specific program
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProgramCourseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Course List under this program")
    private Long programId;

    @ApiModelProperty(value = "Course List under this program")
    private String programName;

    @ApiModelProperty(value = "Course List under this program")
    private CourseListDTO courseListDTO;

    public ProgramCourseDTO(Long programId, String programName, CourseListDTO courseListDTO){
        this.programId = programId;
        this.programName = programName;
        this.courseListDTO = courseListDTO;
    }
}