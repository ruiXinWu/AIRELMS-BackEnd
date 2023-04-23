package com.roncoo.education.course.feign.interfaces.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProgramVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer sort;

    private String programName;

    private String programLogo;


    private String description;
}
