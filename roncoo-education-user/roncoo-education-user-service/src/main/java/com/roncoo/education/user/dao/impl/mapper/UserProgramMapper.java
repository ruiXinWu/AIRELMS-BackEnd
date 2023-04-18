package com.roncoo.education.user.dao.impl.mapper;

import java.util.List;

public interface UserProgramMapper {
    List<Long> selectUserProgramByUserId(Long id);
}
