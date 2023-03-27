package com.roncoo.education.course.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.course.dao.impl.mapper.entity.CategoryProgram;
import com.roncoo.education.course.dao.impl.mapper.entity.CategoryProgramExample;

import java.util.List;

public interface CategoryProgramDao {
    int save(CategoryProgramExample program);

    int deleteById(Long id);

    int updateById(CategoryProgramExample record);

    CategoryProgram getById(Long id);

    Page<CategoryProgram> listForPage(int pageCurrent, int pageSize, CategoryProgramExample program);

    public List<CategoryProgram> getByProgramName(String programName);

    public List<CategoryProgram> getByCategoryId(Long id);

    public List<CategoryProgram> list();

    public List<CategoryProgram> listDistinctSkill();
}
