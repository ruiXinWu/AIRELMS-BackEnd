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
import com.roncoo.education.course.service.api.biz.ApiProgramSkillBiz;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目信息
 *
 * @author AIRE
 */
@Component
public class ApiProgramBiz {

    @Autowired
    private ProgramDao programDao;

    @Autowired
    private ApiProgramSkillBiz apiProgramSkillBiz;

    /**
     * 项目信息列表接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    public Result<Page<ProgramPageDTO>> list(ProgramInfoPageBO programInfoPageBO) {
        ProgramExample example = new ProgramExample();
        example.setOrderByClause(" sort desc, id desc ");
        Page<Program> page = programDao.listForPage(programInfoPageBO.getPageCurrent(), programInfoPageBO.getPageSize(), example);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(page);

        return Result.success(PageUtil.transform(page, ProgramPageDTO.class));
    }

    public Result<ProgramSkillFullDTO> getProgramById(ProgramInfoPageBO programInfoBO){
        Long id = programInfoBO.getId();
        Program program = programDao.getById(id);
        ProgramSkillFullDTO programSkillFullDTO = new ProgramSkillFullDTO();
        List<Skill> skillList = apiProgramSkillBiz.getByProgramName(program.getProgramName());
        programSkillFullDTO.setProgram(program);
        programSkillFullDTO.setSkillDTO(skillList);
        return Result.success(programSkillFullDTO);
    }

    public Result<ProgramListDTO> searchByProgramNameOrDescription(ProgramInfoPageBO programInfoBO){
        String programName = programInfoBO.getProgramName();
        ProgramListDTO programListDTO = new ProgramListDTO();
        List<Program> programList = programDao.searchByProgramNameOrDescription(programName);
        List<ProgramDTO> programDTOList = new ArrayList();
        for(Program program : programList){
            ProgramDTO programDTO = BeanUtil.copyProperties(program,ProgramDTO.class);
            programDTOList.add(programDTO);
        }
        programListDTO.setList(programDTOList);
        return Result.success(programListDTO);

    }

    public ProgramDTO getProgramById(Long id){
        Program program = programDao.getById(id);
        ProgramDTO programDTO = BeanUtil.copyProperties(program, ProgramDTO.class);
        return programDTO;
    }

    public Program getProgramById1(Long id){
        Program program = programDao.getById(id);
        return program;
    }

    public Result<ProgramSkillFullListDTO> listProgram(){
        List<Program> programList = programDao.listProgram();
        ProgramSkillFullListDTO programSkillFullListDTO = programToSkillFullList((programList));
        return Result.success(programSkillFullListDTO);
    }

    public ProgramSkillFullListDTO programToSkillFullList(List<Program> programList){
        List<ProgramSkillFullDTO> list = new ArrayList<>();
        for(Program program : programList){
            List<Skill> skillList= apiProgramSkillBiz.getByProgramName(program.getProgramName());
            ProgramSkillFullDTO programSkillFullDTO = new ProgramSkillFullDTO();
            programSkillFullDTO.setProgram(program);
            programSkillFullDTO.setSkillDTO(skillList);
            list.add(programSkillFullDTO);
        }
        ProgramSkillFullListDTO programSkillFullListDTO = new ProgramSkillFullListDTO();
        programSkillFullListDTO.setList(list);
        return programSkillFullListDTO;
    }

    public Result<ProgramSkillFullListDTO> searchFullByProgramName(ProgramInfoPageBO programInfoBO){
        String programName = programInfoBO.getProgramName();
        List<Program> programList = programDao.searchByProgramNameOrDescription(programName);

        List<ProgramSkillFullDTO> list = new ArrayList<>();
        for(Program program : programList){
            List<Skill> skillList= apiProgramSkillBiz.getByProgramName(program.getProgramName());
            ProgramSkillFullDTO programSkillFullDTO = new ProgramSkillFullDTO();
            programSkillFullDTO.setProgram(program);
            programSkillFullDTO.setSkillDTO(skillList);
            list.add(programSkillFullDTO);
        }
        ProgramSkillFullListDTO programSkillFullListDTO = new ProgramSkillFullListDTO();
        programSkillFullListDTO.setList(list);
        return Result.success(programSkillFullListDTO);
    }

}
