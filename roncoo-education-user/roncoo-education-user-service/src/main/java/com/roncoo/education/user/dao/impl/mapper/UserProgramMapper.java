package com.roncoo.education.user.dao.impl.mapper;

import com.roncoo.education.user.dao.impl.mapper.entity.UserProgram;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserProgramMapper {
    List<UserProgram> selectUserProgramByUserId(Long id);

    List<UserProgram> getProgramDateByUserId(Long id);



}
