package com.roncoo.education.system.dao.impl.mapper;

import com.roncoo.education.system.dao.impl.mapper.entity.Sys;
import com.roncoo.education.system.dao.impl.mapper.entity.SysExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMapper {
    int countByExample(SysExample example);

    int deleteByExample(SysExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sys record);

    int insertSelective(Sys record);

    List<Sys> selectByExample(SysExample example);

    Sys selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sys record, @Param("example") SysExample example);

    int updateByExample(@Param("record") Sys record, @Param("example") SysExample example);

    int updateByPrimaryKeySelective(Sys record);

    int updateByPrimaryKey(Sys record);
}
