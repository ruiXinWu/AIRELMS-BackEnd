package com.roncoo.education.user.dao.impl.mapper;

import com.roncoo.education.user.dao.impl.mapper.entity.LecturerProfit;
import com.roncoo.education.user.dao.impl.mapper.entity.LecturerProfitExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LecturerProfitMapper {
    int countByExample(LecturerProfitExample example);

    int deleteByExample(LecturerProfitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LecturerProfit record);

    int insertSelective(LecturerProfit record);

    List<LecturerProfit> selectByExample(LecturerProfitExample example);

    LecturerProfit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LecturerProfit record, @Param("example") LecturerProfitExample example);

    int updateByExample(@Param("record") LecturerProfit record, @Param("example") LecturerProfitExample example);

    int updateByPrimaryKeySelective(LecturerProfit record);

    int updateByPrimaryKey(LecturerProfit record);
}
