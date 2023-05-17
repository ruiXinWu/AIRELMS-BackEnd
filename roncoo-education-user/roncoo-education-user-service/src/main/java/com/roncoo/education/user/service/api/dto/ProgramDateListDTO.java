package com.roncoo.education.user.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProgramDateListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目时间集合")
    private List<ProgramDateDTO> list = new ArrayList<>();
}
