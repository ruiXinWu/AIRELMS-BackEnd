package com.roncoo.education.course.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Accessors(chain = true)
public class OfficeHourListDTO implements Serializable {

    private  static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "officehour集合")
    private List<OfficeHourDTO> list = new ArrayList<>();

}
