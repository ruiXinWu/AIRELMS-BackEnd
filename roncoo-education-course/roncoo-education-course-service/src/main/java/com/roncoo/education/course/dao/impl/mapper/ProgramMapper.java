package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProgramMapper {
    int countByExample(ProgramExample program);

    int delete(ProgramExample program);

    int deleteByPrimaryKey(Long id);

    int insert(ProgramExample program);

    int insertSelective(ProgramExample program);

    List<Program> selectByExample(ProgramExample program);

    Program selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ProgramExample record);

    int updateByPrimaryKeySelective(ProgramExample record);

    List<Program> searchByNameOrDescription(String description);
}
