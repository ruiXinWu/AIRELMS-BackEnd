package com.roncoo.education.user.dao;

import com.roncoo.education.user.dao.impl.mapper.entity.UserProgram;

import java.util.List;

public interface UserProgramDao {
    List<Long> getByUserId(Long userId);

    List<UserProgram> getDateByUserId(Long userId);
}
