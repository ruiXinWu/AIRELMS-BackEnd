package com.roncoo.education.course.service.api.biz;

import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.tools.BeanUtil;
import com.roncoo.education.course.dao.ProjectDao;
import com.roncoo.education.course.dao.impl.mapper.entity.Project;
import com.roncoo.education.course.service.api.bo.ProjectBO;
import com.roncoo.education.course.service.api.dto.ProgramListDTO;
import com.roncoo.education.course.service.api.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiProjectBiz {
    @Autowired
    private ProjectDao projectDao;

    public ApiProjectBiz(){

    }

    public Result<ProjectDTO> searchByProjectId(ProjectBO projectBO){
        Long projectId = projectBO.getProjectId();
        System.out.println("测试Biz有没有接收到projectId: "+projectId);
        Project project = projectDao.searchByProjectId(projectId);
        ProjectDTO projectDTO = BeanUtil.copyProperties(project, ProjectDTO.class);
        return Result.success(projectDTO);
    }

}
