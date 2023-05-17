package com.roncoo.education.user.service.api;

import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.user.service.api.biz.ApiUserCourseBiz;
import com.roncoo.education.user.service.api.bo.UserInfoBO;
import com.roncoo.education.user.service.api.dto.CourseListDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 行政区域表
 *
 * @author wujing
 */
@RestController
@RequestMapping(value = "/user/api/UserCourse/")
public class ApiUserCourseController {

    @Autowired
    private ApiUserCourseBiz biz;

    /**
     * 区域列出接口
     */
    @ApiOperation(value = "区域列出接口", notes = "根据级别获取区域列出信息")
    @RequestMapping(value = "/getcoursebyuser", method = RequestMethod.POST)
    public Result<CourseListDTO> getCourseByUser(@RequestBody UserInfoBO userInfoBO) {
        return biz.getCourseByUser(userInfoBO);

}}
