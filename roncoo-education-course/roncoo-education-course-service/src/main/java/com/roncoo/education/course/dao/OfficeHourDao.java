package com.roncoo.education.course.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.course.dao.impl.mapper.entity.OfficeHour;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramExample;

import java.util.List;

public interface OfficeHourDao {
    public List<OfficeHour> searchByProgramId(Long programId);


}
