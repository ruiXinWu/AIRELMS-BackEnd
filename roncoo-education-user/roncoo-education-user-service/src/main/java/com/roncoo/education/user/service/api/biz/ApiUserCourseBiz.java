package com.roncoo.education.user.service.api.biz;

import cn.hutool.core.collection.CollectionUtil;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.user.dao.UserCourseDao;
import com.roncoo.education.user.dao.impl.mapper.entity.UserCourse;
import com.roncoo.education.user.service.api.dto.CourseListDTO;
import com.roncoo.education.user.service.api.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.roncoo.education.user.service.api.bo.UserInfoBO;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户基本信息
 *
 * @author wujing
 */
@Component
public class ApiUserCourseBiz {

    @Autowired
    private UserCourseDao userCourseDao;

    public Result<CourseListDTO> getCourseByUser(UserInfoBO userInfoBO) {
        Long userId = userInfoBO.getUserId();
        System.out.println(1111);
        System.out.println(userId);
        List<UserCourse> userCourseList = this.userCourseDao.getCourseByUser(userId);
        List<CourseDTO> courseDTOList = new ArrayList();
        for(UserCourse userCourse : userCourseList){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourseId(userCourse);
            courseDTOList.add(courseDTO);
        }
        CourseListDTO courseListDTO = new CourseListDTO();
        courseListDTO.setCourseList(courseDTOList);
        return Result.success(courseListDTO);
    }

}
