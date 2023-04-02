package com.roncoo.education.course.dao;

import com.roncoo.education.course.dao.impl.mapper.entity.Project;

public interface ProjectDao {
    public Project searchByProjectId(Long projectId);
}
