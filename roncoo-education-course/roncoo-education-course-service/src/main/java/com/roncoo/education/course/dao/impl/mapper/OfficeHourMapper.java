package com.roncoo.education.course.dao.impl.mapper;

import com.roncoo.education.course.dao.impl.mapper.entity.OfficeHour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfficeHourMapper {
    List<OfficeHour> selectByProgramId(Long program_id);
}
