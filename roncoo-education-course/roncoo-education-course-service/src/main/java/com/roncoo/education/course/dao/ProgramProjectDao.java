package com.roncoo.education.course.dao;

import com.roncoo.education.course.dao.impl.mapper.entity.ProgramProject;

import java.util.List;

public interface ProgramProjectDao {
    public List<ProgramProject> getProjectByProgram(Long programId);
}
