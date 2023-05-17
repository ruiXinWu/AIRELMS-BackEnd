package com.roncoo.education.course.service.api.biz;

import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.tools.BeanUtil;
import com.roncoo.education.course.dao.ProgramProjectDao;
import com.roncoo.education.course.dao.ProjectDao;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramProject;
import com.roncoo.education.course.dao.impl.mapper.entity.Project;
import com.roncoo.education.course.service.api.bo.ProgramInfoPageBO;
import com.roncoo.education.course.service.api.bo.ProjectBO;
import com.roncoo.education.course.service.api.dto.ProgramListDTO;
import com.roncoo.education.course.service.api.dto.ProjectDTO;
import com.roncoo.education.course.service.api.dto.ProjectListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiProjectBiz {
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ProgramProjectDao programProjectDao;

    public Result<ProjectDTO> searchByProjectId(ProjectBO projectBO){
        Long projectId = projectBO.getProjectId();
        System.out.println("测试Biz有没有接收到projectId: "+projectId);
        Project project = projectDao.searchByProjectId(projectId);
        ProjectDTO projectDTO = BeanUtil.copyProperties(project, ProjectDTO.class);
        return Result.success(projectDTO);
    }

    public ProjectDTO searchByProjectIdRaw(Long projectId){
        Project project = projectDao.searchByProjectId(projectId);
        ProjectDTO projectDTO = BeanUtil.copyProperties(project, ProjectDTO.class);
        return projectDTO;
    }

    public Result<ProjectListDTO> getProjectByProgram(ProgramInfoPageBO programInfoBO){
        Long programId = programInfoBO.getId();
        List<ProgramProject> programProjectList = programProjectDao.getProjectByProgram(programId);
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for(ProgramProject programProject : programProjectList){
            ProjectDTO projectDTO = this.searchByProjectIdRaw(programProject.getProjectId());
            projectDTOList.add(projectDTO);
        }
        ProjectListDTO projectListDTO = new ProjectListDTO();
        projectListDTO.setList(projectDTOList);
        return Result.success(projectListDTO);
    }



}
