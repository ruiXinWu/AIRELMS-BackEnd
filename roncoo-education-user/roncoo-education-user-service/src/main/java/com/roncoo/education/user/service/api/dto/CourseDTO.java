package com.roncoo.education.user.service.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.roncoo.education.user.dao.impl.mapper.entity.UserCourse;
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
public class CourseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "项目ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;

    private Integer courseStatus;

    public void setCourseId(UserCourse userCourse){
        this.courseId = userCourse.getCourseId();
        this.courseStatus = userCourse.getCourseStatus();
    }
    /**
     * 排序
     */

}