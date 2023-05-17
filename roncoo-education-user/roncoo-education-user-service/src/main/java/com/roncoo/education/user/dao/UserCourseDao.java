package com.roncoo.education.user.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.user.dao.impl.mapper.entity.UserCourse;
import com.roncoo.education.user.dao.impl.mapper.entity.UserCourseExample;

import java.util.List;

public interface UserCourseDao {
    int save(UserCourse record);

    int deleteById(Long id);

    int updateById(UserCourse record);

    UserCourse getById(Long id);

    Page<UserCourse> listForPage(int pageCurrent, int pageSize, UserCourseExample example);

    List<UserCourse> getCourseByUser(Long userId);
}
