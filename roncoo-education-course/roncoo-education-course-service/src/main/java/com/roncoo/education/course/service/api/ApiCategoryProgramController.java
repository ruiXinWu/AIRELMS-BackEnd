package com.roncoo.education.course.service.api;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.base.BaseController;
import com.roncoo.education.course.service.api.biz.ApiCategoryProgramBiz;
import com.roncoo.education.course.service.api.bo.CategoryProgramBO;
import com.roncoo.education.course.service.api.bo.ProgramInfoPageBO;
import com.roncoo.education.course.service.api.dto.CategoryListDTO;
import com.roncoo.education.course.service.api.dto.ProgramListDTO;

import com.roncoo.education.course.service.api.dto.ProgramPageDTO;
import com.roncoo.education.course.service.api.dto.ProgramSkillFullListDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 项目信息
 *
 * @author AIRE
 */
@RestController
@RequestMapping(value = "/course/api/CategoryProgram")
public class ApiCategoryProgramController extends BaseController {

    @Autowired
    private ApiCategoryProgramBiz biz;

    /**
     * 项目信息列表接口
     *
     * @param programInfoPageBO
     * @return
     * @author AIRE
     */
    @ApiOperation(value = "CategoryProgram接口", notes = "根据program name列出program skill")
    @RequestMapping(value = "/getbycategoryid", method = RequestMethod.POST)
    public Result<ProgramSkillFullListDTO> listBycategoryId(@RequestBody CategoryProgramBO categoryProgramBO) {
        return biz.getByCategoryId(categoryProgramBO);
    }


    @ApiOperation(value = "list category", notes = "list category")
    @RequestMapping(value = "/listcategory", method = RequestMethod.POST)
    public Result<CategoryListDTO> listByProrgamName() {
        return biz.list();
    }


}
