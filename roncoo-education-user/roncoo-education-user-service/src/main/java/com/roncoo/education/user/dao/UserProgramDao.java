package com.roncoo.education.user.dao;

import java.util.List;

public interface UserProgramDao {
    List<Long> getByUserId(Long userId);
}
