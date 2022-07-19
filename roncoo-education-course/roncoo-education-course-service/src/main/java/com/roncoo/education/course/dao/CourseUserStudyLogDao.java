package com.roncoo.education.course.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseUserStudyLog;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseUserStudyLogExample;

import java.util.List;

public interface CourseUserStudyLogDao {
    int save(CourseUserStudyLog record);

    int deleteById(Long id);

    int updateById(CourseUserStudyLog record);

    CourseUserStudyLog getById(Long id);

    Page<CourseUserStudyLog> listForPage(int pageCurrent, int pageSize, CourseUserStudyLogExample example);

    CourseUserStudyLog getByUserNoAndPeriodId(Long userNo, Long periodId);

    /**
     * 分页-课程播放量排行榜
     *
     * @param qo
     * @return
     * @author YZJ
     */
    Page<CourseUserStudyLog> courseList(int pageCurrent, int pageSize, String beginGmtCreate, String endGmtCreate);

    /**
     * 根据时间取得前五播放量的课程
     *
     * @param qo
     * @return
     * @author YZJ
     */
    List<CourseUserStudyLog> countCourseIdByGmtCreate(String beginGmtCreate, String endGmtCreate);

    /**
     * 分页-课时播放量排行榜
     *
     * @param qo
     * @return
     * @author YZJ
     */
    Page<CourseUserStudyLog> periodList(Long courseId, int pageCurrent, int pageSize, String beginGmtCreate, String endGmtCreate);

    /**
     * 根据时间和课程ID取得前五播放量的课时
     *
     * @param qo
     * @return
     * @author YZJ
     */
    List<CourseUserStudyLog> countPeriodNoByCourseIdAndGmtCreate(Long courseId, String beginGmtCreate, String endGmtCreate);
}
