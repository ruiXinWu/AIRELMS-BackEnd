package com.roncoo.education.user.service.api.biz;

import com.roncoo.education.common.core.base.BaseBiz;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.tools.BeanUtil;

import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
//import com.roncoo.education.course.service.api.biz.ApiProgramBiz;
import com.roncoo.education.course.feign.interfaces.IFeignProgram;
//import com.roncoo.education.course.service.api.dto.*;

import com.roncoo.education.user.dao.UserProgramDao;
import com.roncoo.education.user.dao.impl.mapper.entity.UserProgram;
import com.roncoo.education.user.service.api.bo.UserInfoBO;
import com.roncoo.education.user.service.api.dto.ProgramDTO;
import com.roncoo.education.user.service.api.dto.ProgramDateDTO;
import com.roncoo.education.user.service.api.dto.ProgramDateListDTO;
import com.roncoo.education.user.service.api.dto.ProgramListDTO;
import io.micrometer.core.instrument.binder.BaseUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiUserProgramBiz extends BaseBiz {
    @Autowired
    private UserProgramDao userProgramDao;
    private ApiUserInfoBiz userInfoBiz;
    @Autowired
    private IFeignProgram iFeignProgram;
    public Result<ProgramListDTO> getByUserId(Long userId){
        System.out.println("second");
        List<Long> programIdList = userProgramDao.getByUserId(userId);
        System.out.println("third");
        ProgramListDTO programListDTO = new ProgramListDTO();
        List<ProgramDTO> list = new ArrayList();
        for(Long programId : programIdList){
            System.out.println(programId);
            ProgramVO programVO = iFeignProgram.getById(programId);
            if (StringUtils.isEmpty(programVO)) {
                return Result.error("根据用户编号没找到对应的项目信息!");
            }
            list.add(BeanUtil.copyProperties(programVO, ProgramDTO.class));
            //list.add(BeanUtil.copyProperties(ProgramDTO.class, programVO));
            //ProgramDTO programDTO = apiProgramBiz.getProgramById(programId);
            //list.add(programDTO);
        }
        programListDTO.setList(list);
        return Result.success(programListDTO);
    }

    public Result<ProgramDateListDTO> getDateByUserId(UserInfoBO userInfoBO){
        Long userId = userInfoBO.getUserId();
        List<UserProgram> programDateList = userProgramDao.getDateByUserId(userId);
        List<ProgramDateDTO> list = new ArrayList<>();
        for (UserProgram userProgram: programDateList){
            list.add(BeanUtil.copyProperties(userProgram,ProgramDateDTO.class));
        }
        ProgramDateListDTO programDateListDTO = new ProgramDateListDTO();
        programDateListDTO.setList(list);
        return Result.success(programDateListDTO);
    }
}
