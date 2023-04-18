package com.roncoo.education.user.service.api.biz;

import com.roncoo.education.common.core.base.BaseBiz;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.dao.impl.mapper.entity.ProgramSkill;
import com.roncoo.education.course.service.api.biz.ApiProgramBiz;
import com.roncoo.education.user.dao.UserProgramDao;
import com.roncoo.education.user.service.api.bo.UserInfoBO;
import org.springframework.stereotype.Component;
import com.roncoo.education.course.service.api.dto.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiUserProgramBiz extends BaseBiz {
    private UserProgramDao userProgramDao;
    private ApiUserInfoBiz userInfoBiz;
    private ApiProgramBiz apiProgramBiz;

    public Result<ProgramListDTO> getByUserId(UserInfoBO userInfoBO){
        List<Long> programIdList = userProgramDao.getByUserId(userInfoBO.getUserId());
        ProgramListDTO programListDTO = new ProgramListDTO();
        List<ProgramDTO> list = new ArrayList();
        for(Long programId : programIdList){
            ProgramDTO programDTO = apiProgramBiz.getProgramById(programId);
            list.add(programDTO);
        }
        programListDTO.setList(list);
        return Result.success(programListDTO);
    }
}
