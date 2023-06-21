package com.roncoo.education.user.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProgramLectureListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "program - lecture集合")
    private List<ProgramLectureDTO> list = new ArrayList<>();
}
