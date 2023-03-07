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
public class ApiProgramBiz {

    @Autowired
    private ProgramDao programDao;

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

    public Result<ProgramDTO> getProgramById(ProgramInfoPageBO programInfoBO){
        Long id = programInfoBO.getId();
        Program program = programDao.getById(id);
        ProgramDTO programDTO = BeanUtil.copyProperties(program, ProgramDTO.class);
        return Result.success(programDTO);
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


}
