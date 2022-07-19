package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.DicList;
import com.roncoo.education.course.dao.impl.mapper.entity.DicListExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DicListMapper {
    int countByExample(DicListExample example);

    int deleteByExample(DicListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DicList record);

    int insertSelective(DicList record);

    List<DicList> selectByExample(DicListExample example);

    DicList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DicList record, @Param("example") DicListExample example);

    int updateByExample(@Param("record") DicList record, @Param("example") DicListExample example);

    int updateByPrimaryKeySelective(DicList record);

    int updateByPrimaryKey(DicList record);
}
