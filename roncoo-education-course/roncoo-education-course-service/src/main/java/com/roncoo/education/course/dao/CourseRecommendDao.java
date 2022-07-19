package com.roncoo.education.course.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseRecommend;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseRecommendExample;

import java.util.List;

public interface CourseRecommendDao {
    int save(CourseRecommend record);

    int deleteById(Long id);

    int updateById(CourseRecommend record);

    CourseRecommend getById(Long id);

    Page<CourseRecommend> listForPage(int pageCurrent, int pageSize, CourseRecommendExample example);

    /**
     * 根据分类ID、状态获取推荐课程信息
     *
     * @param categoryId
     * @param StatusId
     * @author kyh
     */
    List<CourseRecommend> listByCategoryIdAndStatusId(Long categoryId, Integer StatusId);

    /**
     * 根据分类ID、课程ID获取推荐课程信息
     *
     * @param categoryId
     * @param courseId
     * @return
     */
    CourseRecommend getByCategoryIdAndCourseId(Long categoryId, Long courseId);

}
