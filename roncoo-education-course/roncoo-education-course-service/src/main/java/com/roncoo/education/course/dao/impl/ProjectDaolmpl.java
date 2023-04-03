package com.roncoo.education.course.dao.impl;

import com.roncoo.education.course.dao.ProjectDao;
import com.roncoo.education.course.dao.impl.mapper.ProjectMapper;
import com.roncoo.education.course.dao.impl.mapper.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaolmpl implements ProjectDao {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Project searchByProjectId(Long project_id){
        return this.projectMapper.selectByProjectId(project_id);
    }

}
