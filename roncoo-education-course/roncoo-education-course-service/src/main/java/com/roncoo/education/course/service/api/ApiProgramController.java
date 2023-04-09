package com.roncoo.education.course.service.api;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.base.BaseController;
import com.roncoo.education.course.service.api.biz.ApiProgramBiz;
import com.roncoo.education.course.service.api.bo.ProgramInfoPageBO;
import com.roncoo.education.course.service.api.dto.*;

import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/course/api/program")
public class ApiProgramController extends BaseController {

    @Autowired
    private ApiProgramBiz biz;

    /**
     * 项目信息列表接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "项目列表接口", notes = "根据条件分页列出项目信息")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<ProgramSkillFullListDTO> list() {
        return biz.listProgram();
    }

    /**
     * 项目信息接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "项目接口", notes = "根据项目ID得到项目详细信息")
    @RequestMapping(value = "/searchbyid", method = RequestMethod.POST)
    public Result<ProgramSkillFullDTO> getProgramById(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.getProgramById(programInfoPageBO);
    }

    /**
     * 项目搜索接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "项目搜索接口", notes = "根据项目名搜索符合条件的全名")
    @RequestMapping(value = "/searchbyname", method = RequestMethod.POST)
    public Result<ProgramListDTO> searchByProgramNameOrDescription(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.searchByProgramNameOrDescription(programInfoPageBO);
    }

    @ApiOperation(value = "getofficehourbyprogramid接口", notes = "program id")
    @RequestMapping(value = "/getofficehourbyprogramid", method = RequestMethod.POST)
    public Result<OfficeHourListDTO> getOfficeHourByProgramId(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.getOfficeHourByProgramId(programInfoPageBO);}
        
    @ApiOperation(value = "full项目搜索接口", notes = "根据项目名搜索项目并返回skill list field")
    @RequestMapping(value = "/searchfullbyname", method = RequestMethod.POST)
    public Result<ProgramSkillFullListDTO> searchFullByProgramName(@RequestBody ProgramInfoPageBO programInfoPageBO) {
        return biz.searchFullByProgramName(programInfoPageBO);
    }
}
