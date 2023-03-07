package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.ProgramSkill;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramSkillExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProgramSkillMapper {
    int countByExample(ProgramSkillExample program);

    int delete(ProgramSkillExample program);

    int deleteByPrimaryKey(Long id);

    int insert(ProgramSkillExample program);

    int insertSelective(ProgramSkillExample program);

    List<ProgramSkill> selectByExample(ProgramSkillExample program);

    ProgramSkill selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ProgramSkillExample record);

    int updateByPrimaryKeySelective(ProgramSkillExample record);

    List<ProgramSkill> listDistinctSkill();
}

