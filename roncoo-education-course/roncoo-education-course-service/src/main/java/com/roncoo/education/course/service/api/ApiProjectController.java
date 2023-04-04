package com.roncoo.education.course.service.api;

import com.roncoo.education.common.core.base.BaseController;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.course.service.api.biz.ApiProjectBiz;
import com.roncoo.education.course.service.api.bo.ProgramInfoPageBO;
import com.roncoo.education.course.service.api.bo.ProjectBO;
import com.roncoo.education.course.service.api.dto.ProgramSkillFullDTO;
import com.roncoo.education.course.service.api.dto.ProjectDTO;
import com.roncoo.education.course.service.api.dto.ProjectListDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course/api/project")
public class ApiProjectController extends BaseController {
    @Autowired
    private ApiProjectBiz biz;


    /**
     * 项目信息列表接口
     *
     * @param projectBO
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "project接口", notes = "根据project id 得到详细的project id 信息")
    @RequestMapping(value = "/searchbyprojectid", method = RequestMethod.POST)
    public Result<ProjectDTO> getProjectByProjectId(@RequestBody ProjectBO projectBO) {
        return biz.searchByProjectId(projectBO);
    }

    @ApiOperation(value = "project接口", notes = "根据program id 得到详细的project id 信息")
    @RequestMapping(value = "/getprojectbyprogram", method = RequestMethod.POST)
    public Result<ProjectListDTO> getProjectByProgram(@RequestBody ProgramInfoPageBO programInfoBO) {
        return biz.getProjectByProgram(programInfoBO);
    }


}
