package com.roncoo.education.course.service.api.biz;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.tools.BeanUtil;
import com.roncoo.education.course.dao.*;
import com.roncoo.education.course.dao.impl.mapper.entity.*;
import com.roncoo.education.course.service.api.bo.CategoryProgramBO;
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
public class ApiCategoryProgramBiz {

    @Autowired
    private CategoryProgramDao CategoryProgramDao;

    @Autowired
    private ApiProgramBiz programBiz;


    /**
     * 项目信息列表接口
     *
     * @param CategoryProgramBO
     * @return
     * @author AIRE
     */
    public Result<ProgramSkillFullListDTO> getByCategoryId(CategoryProgramBO categoryProgramBO){
        List<CategoryProgram> categoryProgramList = CategoryProgramDao.getByCategoryId(categoryProgramBO.getCategoryId());
        List<Program> programList = new ArrayList();
        for(CategoryProgram categoryProgram : categoryProgramList){
            Program program = programBiz.getProgramById1(categoryProgram.getProgramId());
            programList.add(program);
        }
        return Result.success(programBiz.programToSkillFullList(programList));

    }
    public Result<CategoryListDTO> list(){
        List<CategoryProgram> categoryProgramList = CategoryProgramDao.list();
        List<CategoryDTO> categoryDTOList = new ArrayList();
        for(CategoryProgram categoryProgram : categoryProgramList){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.set(categoryProgram.getCategoryId(),categoryProgram.getCategoryName());

            categoryDTOList.add(categoryDTO);
        }
        CategoryListDTO categoryListDTO = new CategoryListDTO();
        categoryListDTO.setList(categoryDTOList);
        return Result.success(categoryListDTO);

    }


}

