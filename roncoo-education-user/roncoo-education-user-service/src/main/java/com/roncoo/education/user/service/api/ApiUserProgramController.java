package com.roncoo.education.user.service.api;

import com.roncoo.education.common.core.base.BaseController;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.course.service.api.dto.ProgramListDTO;
import com.roncoo.education.user.service.api.biz.ApiUserInfoBiz;

import com.roncoo.education.user.service.api.biz.ApiUserProgramBiz;
import com.roncoo.education.user.service.api.bo.*;
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
    private ApiUserProgramBiz biz;

    @ApiOperation(value = "用户信息接口", notes = "根据用户ID得到用户拥有的项目")
    @RequestMapping(value = "/getuserprogrambyuserid", method = RequestMethod.POST)
    public Result<ProgramListDTO> getUserProgramByUserId(@RequestBody UserInfoBO userInfoBO){
        return biz.getByUserId(userInfoBO);
    }
}
