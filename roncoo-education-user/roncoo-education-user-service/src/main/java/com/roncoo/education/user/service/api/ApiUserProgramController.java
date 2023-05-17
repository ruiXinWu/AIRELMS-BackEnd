package com.roncoo.education.user.service.api;

import com.roncoo.education.common.core.base.BaseController;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.course.feign.interfaces.IFeignProgram;

import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
import com.roncoo.education.course.feign.interfaces.IFeignProgram;

import com.roncoo.education.user.service.api.biz.ApiUserInfoBiz;
import com.roncoo.education.user.service.api.biz.ApiUserProgramBiz;
import com.roncoo.education.user.service.api.bo.*;
import com.roncoo.education.user.service.api.dto.ProgramCourseListDTO;
import com.roncoo.education.user.service.api.dto.ProgramDateListDTO;
import com.roncoo.education.user.service.api.dto.ProgramListDTO;
import com.roncoo.education.user.service.api.dto.UserLoginDTO;
import com.roncoo.education.user.service.auth.bo.UserUpdateBO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/api/userprogram")
public class ApiUserProgramController extends BaseController{
    @Autowired
    private ApiUserProgramBiz apiUserProgramBiz;

    @Autowired
    private IFeignProgram iFeignProgram;

    @ApiOperation(value = "用户信息接口", notes = "根据用户ID得到用户拥有的项目")
    @RequestMapping(value = "/getuserprogrambyuserid", method = RequestMethod.POST)
    public Result<ProgramListDTO> getUserProgramByUserId(@RequestBody UserInfoBO userInfoBO){
        System.out.println("Begin");
        System.out.println(userInfoBO.getUserId());
        return apiUserProgramBiz.getByUserId(userInfoBO.getUserId());
    }

    @ApiOperation(value = "用户项目时间接口", notes = "根据用户ID得到用户拥有的项目和项目时间")
    @RequestMapping(value = "/getprogramdatebyuserid", method = RequestMethod.POST)
    public Result<ProgramDateListDTO> getProgramDateByUserId(@RequestBody UserInfoBO userInfoBO){
        System.out.println("controller5.11");
        return apiUserProgramBiz.getDateByUserId(userInfoBO);
    }

    @ApiOperation(value = "用户program_course接口", notes = " user->program list -> course list")
    @RequestMapping(value = "/getprogramcoursebyuserid", method = RequestMethod.POST)
    public Result<ProgramCourseListDTO> getProgramCourseByUserId(@RequestBody UserInfoBO userInfoBO){
        return apiUserProgramBiz.getProgramCourseStatusByUserId(userInfoBO);
    }
}
