package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.FileStorage;
import com.roncoo.education.course.dao.impl.mapper.entity.FileStorageExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileStorageMapper {
    int countByExample(FileStorageExample example);

    int deleteByExample(FileStorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileStorage record);

    int insertSelective(FileStorage record);

    List<FileStorage> selectByExample(FileStorageExample example);

    FileStorage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileStorage record, @Param("example") FileStorageExample example);

    int updateByExample(@Param("record") FileStorage record, @Param("example") FileStorageExample example);

    int updateByPrimaryKeySelective(FileStorage record);

    int updateByPrimaryKey(FileStorage record);
}
