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
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "programId")
    private Long id;
    /**
     * 排序
     */
    @ApiModelProperty(value = "programName")
    private String categoryName;

    public void set(Long id, String categoryName){
        this.id = id;
        this.categoryName = categoryName;
    }

}


