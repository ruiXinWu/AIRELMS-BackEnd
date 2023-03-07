package com.roncoo.education.course.service.api.biz;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.tools.BeanUtil;
import com.roncoo.education.course.dao.*;
import com.roncoo.education.course.dao.impl.mapper.entity.*;
import com.roncoo.education.course.service.api.bo.ProgramInfoPageBO;
import com.roncoo.education.course.service.api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目信息
 *
 * @author AIRE
 */
@Component
public class ApiProgramSkillBiz {

    @Autowired
    private ProgramSkillDao programSkillDao;

    @Autowired
    private ApiProgramBiz programBiz;

    /**
     * 项目信息列表接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    public Result<ProgramSkillListDTO> getByProgramName(ProgramInfoPageBO programInfoPageBO) {
        List<ProgramSkill> programSkillList = programSkillDao.getByProgramName(programInfoPageBO.getProgramName());
        ProgramSkillListDTO programSkillListDTO = new ProgramSkillListDTO();
        List<ProgramSkillDTO> list = new ArrayList();
        for(ProgramSkill programSkill : programSkillList){
            ProgramSkillDTO programSkillDTO = BeanUtil.copyProperties(programSkill,ProgramSkillDTO.class);
            list.add(programSkillDTO);
        }
        programSkillListDTO.setList(list);
        return Result.success(programSkillListDTO);
    }

    public Result<ProgramListDTO> getBySkillName(ProgramInfoPageBO programInfoPageBO) {
        List<ProgramSkill> programSkillList = programSkillDao.getBySkillName(programInfoPageBO.getSkillName());
        ProgramListDTO programListDTO = new ProgramListDTO();
        List<ProgramDTO> list = new ArrayList();
        for(ProgramSkill programSkill : programSkillList){
            ProgramDTO programDTO = programBiz.getProgramById(programSkill.getProgramId());
            list.add(programDTO);
        }
        programListDTO.setList(list);
        return Result.success(programListDTO);
    }

    public Result<ProgramSkillListDTO> ListDistinctSkill() {
        List<ProgramSkill> programSkillList = programSkillDao.listDistinctSkill();
        ProgramSkillListDTO programSkillListDTO = new ProgramSkillListDTO();
        List<ProgramSkillDTO> list = new ArrayList();
        for(ProgramSkill programSkill : programSkillList){
            ProgramSkillDTO programSkillDTO = BeanUtil.copyProperties(programSkill,ProgramSkillDTO.class);
            list.add(programSkillDTO);
        }
        programSkillListDTO.setList(list);
        return Result.success(programSkillListDTO);
    }

}

