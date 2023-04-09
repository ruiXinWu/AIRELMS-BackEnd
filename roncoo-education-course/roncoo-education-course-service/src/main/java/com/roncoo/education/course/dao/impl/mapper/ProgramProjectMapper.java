package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.ProgramProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProgramProjectMapper {
    List<ProgramProject> getProjectByProgram(Long program_id);
}
