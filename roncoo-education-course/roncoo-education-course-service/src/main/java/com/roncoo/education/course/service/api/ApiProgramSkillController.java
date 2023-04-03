package com.roncoo.education.course.service.api;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.base.BaseController;
import com.roncoo.education.course.service.api.biz.ApiProgramSkillBiz;
import com.roncoo.education.course.service.api.bo.ProgramInfoPageBO;
import com.roncoo.education.course.service.api.dto.ProgramSkillListDTO;
import com.roncoo.education.course.service.api.dto.ProgramListDTO;
import com.roncoo.education.course.service.api.dto.ProgramSkillFullListDTO;

import com.roncoo.education.course.service.api.dto.ProgramPageDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 项目信息
 *
 * @author AIRE
 */
@RestController
@RequestMapping(value = "/course/api/programskill")
public class ApiProgramSkillController extends BaseController {

    @Autowired
    private ApiProgramSkillBiz biz;

    /**
     * 项目信息列表接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "programskill接口", notes = "根据program name列出program skill")
    @RequestMapping(value = "/getbyprogramname", method = RequestMethod.POST)
    public Result<ProgramSkillListDTO> listByProrgamName(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.getByProgramName(programInfoPageBO);
    }

    /**
     * 项目信息列表接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "programskill接口", notes = "根据skill name列出program skill")
    @RequestMapping(value = "/getbyskillname", method = RequestMethod.POST)
    public Result<ProgramListDTO> listBySkillName(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.getBySkillName(programInfoPageBO);
    }

    /**
     * 项目信息列表接口
     *
     * @param
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "list skill接口", notes = "列出skill")
    @RequestMapping(value = "/listskill", method = RequestMethod.POST)
    public Result<ProgramSkillListDTO> listDistinctSkill() {
        return biz.ListDistinctSkill();
    }

    @ApiOperation(value = "getbyskillid接口", notes = "skill id")
    @RequestMapping(value = "/getbyskillid", method = RequestMethod.POST)
    public Result<ProgramListDTO> getBySkillId(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.getBySkillId(programInfoPageBO);
    }

    @ApiOperation(value = "getfullbyskillid接口", notes = "skill id")
    @RequestMapping(value = "/getfullbyskillid", method = RequestMethod.POST)
    public Result<ProgramSkillFullListDTO> getFullBySkillId(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.getFullBySkillId(programInfoPageBO);
    }


}
