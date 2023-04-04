package com.roncoo.education.course.service.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class OfficeHourDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "office hour ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "连接")
    private String url;

    @ApiModelProperty(value = "项目ID")
    private Long programId;
}
