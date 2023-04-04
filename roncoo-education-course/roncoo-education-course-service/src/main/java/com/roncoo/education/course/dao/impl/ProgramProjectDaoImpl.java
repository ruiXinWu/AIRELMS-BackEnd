package com.roncoo.education.course.dao.impl;

import com.roncoo.education.course.dao.ProgramProjectDao;
import com.roncoo.education.course.dao.impl.mapper.ProgramProjectMapper;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgramProjectDaoImpl implements ProgramProjectDao {

    @Autowired
    private ProgramProjectMapper programProjectMapper;

    @Override
    public List<ProgramProject> getProjectByProgram(Long programId){
        return this.programProjectMapper.getProjectByProgram(programId);
    }

}

