package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.CategoryProgram;
import com.roncoo.education.course.dao.impl.mapper.entity.CategoryProgramExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryProgramMapper {
    int countByExample(CategoryProgramExample program);

    int delete(CategoryProgramExample program);

    int deleteByPrimaryKey(Long id);

    int insert(CategoryProgramExample program);

    int insertSelective(CategoryProgramExample program);

    List<CategoryProgram> selectByExample(CategoryProgramExample program);

    CategoryProgram selectByPrimaryKey(Long id);

    int updateByPrimaryKey(CategoryProgramExample record);

    int updateByPrimaryKeySelective(CategoryProgramExample record);

    List<CategoryProgram> listDistinctSkill();

    List<CategoryProgram> list();
}

