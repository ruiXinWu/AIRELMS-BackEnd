package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.CourseUserStudyLog;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseUserStudyLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseUserStudyLogMapper {
    int countByExample(CourseUserStudyLogExample example);

    int deleteByExample(CourseUserStudyLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseUserStudyLog record);

    int insertSelective(CourseUserStudyLog record);

    List<CourseUserStudyLog> selectByExample(CourseUserStudyLogExample example);

    CourseUserStudyLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseUserStudyLog record, @Param("example") CourseUserStudyLogExample example);

    int updateByExample(@Param("record") CourseUserStudyLog record, @Param("example") CourseUserStudyLogExample example);

    int updateByPrimaryKeySelective(CourseUserStudyLog record);

    int updateByPrimaryKey(CourseUserStudyLog record);
}
