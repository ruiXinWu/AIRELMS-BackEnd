package com.roncoo.education.course.dao.impl;

import com.roncoo.education.course.dao.ProgramDao;
import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.course.dao.impl.mapper.ProgramMapper;
import com.roncoo.education.course.dao.impl.mapper.entity.CourseExample;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgramDaoImpl implements ProgramDao {
    @Autowired
    private ProgramMapper programMapper;

    public int save(ProgramExample record) {
        return this.programMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.programMapper.deleteByPrimaryKey(id);
    }

    public int updateById(ProgramExample record) {
        return this.programMapper.updateByPrimaryKeySelective(record);
    }

    public Program getById(Long id) {
        return this.programMapper.selectByPrimaryKey(id);
    }

    public Page<Program> listForPage(int pageCurrent, int pageSize, ProgramExample example) {
        int count = this.programMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);

        Page<Program> debug = new Page<Program>(count, totalPage, pageCurrent, pageSize, this.programMapper.selectByExample(example));

        System.out.print(debug);

        return new Page<Program>(count, totalPage, pageCurrent, pageSize, this.programMapper.selectByExample(example));
    }

    public List<Program> searchByProgramNameOrDescription(String description){
        return this.programMapper.searchByNameOrDescription(description);
    }
}
