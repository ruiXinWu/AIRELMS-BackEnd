package com.roncoo.education.user.dao.impl;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.common.core.tools.IdWorker;
import com.roncoo.education.user.dao.UserCourseDao;
import com.roncoo.education.user.dao.impl.mapper.UserCourseMapper;
import com.roncoo.education.user.dao.impl.mapper.entity.UserCourse;
import com.roncoo.education.user.dao.impl.mapper.entity.UserCourseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCourseDaoImpl implements UserCourseDao {
    @Autowired
    private UserCourseMapper UserCourseMapper;

    @Override
    public int save(UserCourse record) {
        record.setId(IdWorker.getId());
        return this.UserCourseMapper.insertSelective(record);
    }

    @Override
    public int deleteById(Long id) {
        return this.UserCourseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(UserCourse record) {
        return this.UserCourseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public UserCourse getById(Long id) {
        return this.UserCourseMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<UserCourse> listForPage(int pageCurrent, int pageSize, UserCourseExample example) {
        int count = this.UserCourseMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<UserCourse>(count, totalPage, pageCurrent, pageSize,
                this.UserCourseMapper.selectByExample(example));
    }

    @Override
    public List<UserCourse> getCourseByUser(Long userId) {
        return this.UserCourseMapper.getCourseByUser(userId);
    }
}
