package com.roncoo.education.course.service.api.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目信息
 *
 * @author AIRE
 */
@Data
@Accessors(chain = true)
public class ProgramInfoPageBO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 当前页
     */
    private int pageCurrent = 1;
    /**
     * 每页记录数
     */
    private int pageSize = 20;

    /**
     * program名称
     */
    private String programName;

    /**
     * 课程ID
     */
    private long id;


    /**
     * skill名称
     */
    private String skillName;


    public String getProgramName() {
        return programName;
    }

    public String getSkillName() {
        return skillName;
    }
}
