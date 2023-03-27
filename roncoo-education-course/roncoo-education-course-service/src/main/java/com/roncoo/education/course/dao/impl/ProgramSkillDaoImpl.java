package com.roncoo.education.course.dao.impl;

import com.roncoo.education.course.dao.ProgramSkillDao;
import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.course.dao.impl.mapper.ProgramSkillMapper;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramSkill;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramSkillExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgramSkillDaoImpl implements ProgramSkillDao {
    @Autowired
    private ProgramSkillMapper programSkillMapper;

    public int save(ProgramSkillExample record) {
        return this.programSkillMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.programSkillMapper.deleteByPrimaryKey(id);
    }

    public int updateById(ProgramSkillExample record) {
        return this.programSkillMapper.updateByPrimaryKeySelective(record);
    }

    public ProgramSkill getById(Long id) {
        return this.programSkillMapper.selectByPrimaryKey(id);
    }

    public Page<ProgramSkill> listForPage(int pageCurrent, int pageSize, ProgramSkillExample example) {
        int count = this.programSkillMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);

        Page<ProgramSkill> debug = new Page<ProgramSkill>(count, totalPage, pageCurrent, pageSize, this.programSkillMapper.selectByExample(example));

        System.out.print(debug);

        return new Page<ProgramSkill>(count, totalPage, pageCurrent, pageSize, this.programSkillMapper.selectByExample(example));
    }

    public List<ProgramSkill> getByProgramName(String programName){
        ProgramSkillExample example = new ProgramSkillExample();
        ProgramSkillExample.Criteria c = example.createCriteria();
        c.andProgramNameEqualTo(programName);
        return this.programSkillMapper.selectByExample(example);
    }

    public List<ProgramSkill> getBySkillName(String skillName){
        ProgramSkillExample example = new ProgramSkillExample();
        ProgramSkillExample.Criteria c = example.createCriteria();
        c.andSkillNameEqualTo(skillName);
        return this.programSkillMapper.selectByExample(example);
    }

    public List<ProgramSkill> getBySkillId(Long skillId){
        ProgramSkillExample example = new ProgramSkillExample();
        ProgramSkillExample.Criteria c = example.createCriteria();
        c.andSkillIdEqualTo(skillId);
        return this.programSkillMapper.selectByExample(example);
    }

    public List<ProgramSkill> listDistinctSkill(){
        return this.programSkillMapper.listDistinctSkill();
    }




}
