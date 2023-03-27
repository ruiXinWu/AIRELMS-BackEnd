package com.roncoo.education.course.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramExample;

import java.util.List;

public interface ProgramDao {
    int save(ProgramExample program);

    int deleteById(Long id);

    int updateById(ProgramExample record);

    Program getById(Long id);

    Page<Program> listForPage(int pageCurrent, int pageSize, ProgramExample program);

    public List<Program> searchByProgramNameOrDescription(String description);

    public List<Program> listProgram();
}
