package com.roncoo.education.course.dao.impl;

import com.roncoo.education.course.dao.CategoryProgramDao;
import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.course.dao.impl.mapper.CategoryProgramMapper;
import com.roncoo.education.course.dao.impl.mapper.entity.CategoryProgram;
import com.roncoo.education.course.dao.impl.mapper.entity.CategoryProgramExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryProgramDaoImpl implements CategoryProgramDao {
    @Autowired
    private CategoryProgramMapper CategoryProgramMapper;

    public int save(CategoryProgramExample record) {
        return this.CategoryProgramMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.CategoryProgramMapper.deleteByPrimaryKey(id);
    }

    public int updateById(CategoryProgramExample record) {
        return this.CategoryProgramMapper.updateByPrimaryKeySelective(record);
    }

    public CategoryProgram getById(Long id) {
        return this.CategoryProgramMapper.selectByPrimaryKey(id);
    }

    public Page<CategoryProgram> listForPage(int pageCurrent, int pageSize, CategoryProgramExample example) {
        int count = this.CategoryProgramMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);

        Page<CategoryProgram> debug = new Page<CategoryProgram>(count, totalPage, pageCurrent, pageSize, this.CategoryProgramMapper.selectByExample(example));

        System.out.print(debug);

        return new Page<CategoryProgram>(count, totalPage, pageCurrent, pageSize, this.CategoryProgramMapper.selectByExample(example));
    }

    public List<CategoryProgram> getByProgramName(String programName){
        CategoryProgramExample example = new CategoryProgramExample();
        CategoryProgramExample.Criteria c = example.createCriteria();
        c.andProgramNameEqualTo(programName);
        return this.CategoryProgramMapper.selectByExample(example);
    }

    public List<CategoryProgram> getByCategoryId(Long id){
        CategoryProgramExample example = new CategoryProgramExample();
        CategoryProgramExample.Criteria c = example.createCriteria();
        c.andCategoryIdEqualTo(id);
        return this.CategoryProgramMapper.selectByExample(example);
    }

    public List<CategoryProgram> list(){
        return this.CategoryProgramMapper.list();
    }

    public List<CategoryProgram> listDistinctSkill(){
        return this.CategoryProgramMapper.listDistinctSkill();
    }




}

