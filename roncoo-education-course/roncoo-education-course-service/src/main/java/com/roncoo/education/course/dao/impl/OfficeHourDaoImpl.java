package com.roncoo.education.course.dao.impl;

import com.roncoo.education.course.dao.OfficeHourDao;
import com.roncoo.education.course.dao.ProgramDao;
import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.course.dao.impl.mapper.OfficeHourMapper;
import com.roncoo.education.course.dao.impl.mapper.ProgramMapper;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseExample;
import com.roncoo.education.course.dao.impl.mapper.entity.OfficeHour;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfficeHourDaoImpl implements OfficeHourDao {
    @Autowired
    private OfficeHourMapper officeHourMapper;


    @Override
    public List<OfficeHour> searchByProgramId(Long programId) {
        return this.officeHourMapper.selectByProgramId(programId);
    }
}

