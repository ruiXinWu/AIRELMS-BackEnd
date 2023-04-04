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

    public List<Skill> getByProgramName(String programName) {
        List<ProgramSkill> programSkillList = programSkillDao.getByProgramName(programName);
        List<Skill> skillList = new ArrayList<>();
        for(ProgramSkill programSkill : programSkillList){
            Skill skill = new Skill();
            skill.setName(programSkill.getSkillName());
            skill.setId(programSkill.getSkillId());
            skillList.add(skill);
        }
        return skillList;
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

    public Result<ProgramListDTO> getBySkillId(ProgramInfoPageBO programInfoPageBO) {
        List<ProgramSkill> programSkillList = programSkillDao.getBySkillId(programInfoPageBO.getSkillId());
        ProgramListDTO programListDTO = new ProgramListDTO();
        List<ProgramDTO> list = new ArrayList();
        for(ProgramSkill programSkill : programSkillList){
            ProgramDTO programDTO = programBiz.getProgramById(programSkill.getProgramId());
            list.add(programDTO);
        }
        programListDTO.setList(list);
        return Result.success(programListDTO);
    }

    public Result<ProgramSkillFullListDTO> getFullBySkillId(ProgramInfoPageBO programInfoPageBO) {
        List<ProgramSkill> programSkillList = programSkillDao.getBySkillId(programInfoPageBO.getSkillId());

        List<Program> programList = new ArrayList<>();
        for(ProgramSkill programSkill : programSkillList){
            Program program = programBiz.getProgramById1(programSkill.getProgramId());
            programList.add(program);
        }

        List<ProgramSkillFullDTO> list = new ArrayList<>();
        for(Program program : programList){
            List<Skill> skillList= getByProgramName(program.getProgramName());
            ProgramSkillFullDTO programSkillFullDTO = new ProgramSkillFullDTO();
            programSkillFullDTO.setProgram(program);
            programSkillFullDTO.setSkillDTO(skillList);
            list.add(programSkillFullDTO);
        }
        ProgramSkillFullListDTO programSkillFullListDTO = new ProgramSkillFullListDTO();
        programSkillFullListDTO.setList(list);
        return Result.success(programSkillFullListDTO);
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

