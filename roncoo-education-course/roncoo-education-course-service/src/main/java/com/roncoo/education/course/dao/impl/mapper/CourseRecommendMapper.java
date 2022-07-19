package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.CourseRecommend;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseRecommendExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseRecommendMapper {
    int countByExample(CourseRecommendExample example);

    int deleteByExample(CourseRecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseRecommend record);

    int insertSelective(CourseRecommend record);

    List<CourseRecommend> selectByExample(CourseRecommendExample example);

    CourseRecommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseRecommend record, @Param("example") CourseRecommendExample example);

    int updateByExample(@Param("record") CourseRecommend record, @Param("example") CourseRecommendExample example);

    int updateByPrimaryKeySelective(CourseRecommend record);

    int updateByPrimaryKey(CourseRecommend record);
}
