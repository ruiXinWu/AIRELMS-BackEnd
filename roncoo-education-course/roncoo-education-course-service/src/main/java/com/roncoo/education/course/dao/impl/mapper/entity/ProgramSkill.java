package com.roncoo.education.course.dao.impl.mapper.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
public class ProgramSkill implements Serializable{
    private Long id;

    private Long programId;

    private Long skillId;


    private String programName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    private String skillName;

    public Long getId() {
        return id;
    }

    public Long getProgramId() {
        return programId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public String getProgramName() {
        return programName;
    }

    public String getSkillName() {
        return skillName;
    }
    @Override
    public String toString() {
        return "ProgramSkill{" +
                "id=" + id +
                ", programId=" + programId +
                ", skillId=" + skillId +
                ", programName='" + programName + '\'' +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
