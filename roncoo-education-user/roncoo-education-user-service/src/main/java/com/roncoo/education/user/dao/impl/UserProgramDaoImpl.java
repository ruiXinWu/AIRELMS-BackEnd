package com.roncoo.education.user.dao.impl;

import com.roncoo.education.common.jdbc.AbstractBaseJdbc;
import com.roncoo.education.user.dao.UserProgramDao;
import com.roncoo.education.user.dao.impl.mapper.UserProgramMapper;
import com.roncoo.education.user.dao.impl.mapper.entity.UserProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserProgramDaoImpl extends AbstractBaseJdbc implements UserProgramDao {
    @Autowired
    private UserProgramMapper userProgramMapper;

    public List<Long> getByUserId(Long userId){
        System.out.println("test");
        List<Long> programIdList = new ArrayList<>();
        List<UserProgram> userProgramList = this.userProgramMapper.selectUserProgramByUserId(userId);
        for(UserProgram userProgram: userProgramList){
            Long programId = userProgram.getProgramId();
            programIdList.add(programId);
        }
        //return this.userProgramMapper.selectUserProgramByUserId(userId);
        return programIdList;
    }

    public List<UserProgram> getDateByUserId(Long userId){
        System.out.println("test1");
        List<UserProgram> userProgramList = this.userProgramMapper.getProgramDateByUserId(userId);
        return userProgramList;
    }






}
