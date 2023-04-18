package com.roncoo.education.user.dao.impl;

import com.roncoo.education.common.jdbc.AbstractBaseJdbc;
import com.roncoo.education.user.dao.UserProgramDao;
import com.roncoo.education.user.dao.impl.mapper.UserProgramMapper;

import java.util.List;

public class UserProgramDaoImpl extends AbstractBaseJdbc implements UserProgramDao {
    private UserProgramMapper userProgramMapper;

    public List<Long> getByUserId(long userId){
        return this.userProgramMapper.selectUserProgramByUserId(userId);
    }


}
