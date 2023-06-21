package com.roncoo.education.course.feign.interfaces.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class OfficeHourVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long lecturerId;

    private Long programId;

    private String officeHourUrl;

    private String headImgUrl;

    private String lecturerName;

    private String  introduce;
}
