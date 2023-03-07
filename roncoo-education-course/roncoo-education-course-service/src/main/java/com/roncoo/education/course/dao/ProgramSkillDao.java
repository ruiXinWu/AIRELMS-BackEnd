package com.roncoo.education.course.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramSkill;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramSkillExample;

import java.util.List;

public interface ProgramSkillDao {
    int save(ProgramSkillExample program);

    int deleteById(Long id);

    int updateById(ProgramSkillExample record);

    ProgramSkill getById(Long id);

    Page<ProgramSkill> listForPage(int pageCurrent, int pageSize, ProgramSkillExample program);

    public List<ProgramSkill> getByProgramName(String programName);

    public List<ProgramSkill> getBySkillName(String skillName);

    public List<ProgramSkill> listDistinctSkill();
}
