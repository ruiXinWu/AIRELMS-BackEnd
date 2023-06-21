package com.roncoo.education.user.service.api.biz;

import com.roncoo.education.common.core.base.BaseBiz;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.tools.BeanUtil;

//import com.roncoo.education.course.dao.impl.mapper.entity.Course;
import com.roncoo.education.course.dao.impl.mapper.entity.OfficeHour;
import com.roncoo.education.course.feign.interfaces.IFeignOfficeHour;
import com.roncoo.education.course.feign.interfaces.vo.OfficeHourVO;
import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
//import com.roncoo.education.course.service.api.biz.ApiProgramBiz;
import com.roncoo.education.course.feign.interfaces.IFeignProgram;
import com.roncoo.education.course.feign.interfaces.IFeignCourse;
//import com.roncoo.education.course.service.api.dto.*;

import com.roncoo.education.user.dao.UserProgramDao;
import com.roncoo.education.user.dao.UserCourseDao;
import com.roncoo.education.user.dao.impl.mapper.entity.UserCourse;
import com.roncoo.education.user.dao.impl.mapper.entity.UserProgram;
import com.roncoo.education.user.service.api.bo.UserInfoBO;
import com.roncoo.education.user.service.api.dto.*;
import io.micrometer.core.instrument.binder.BaseUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.roncoo.education.course.feign.interfaces.vo.CourseVO;
import com.roncoo.education.course.feign.interfaces.vo.CourseListVO;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ApiUserProgramBiz extends BaseBiz {
    @Autowired
    private UserProgramDao userProgramDao;

    @Autowired
    private UserCourseDao userCourseDao;

    @Autowired
    private IFeignProgram iFeignProgram;

    @Autowired
    private IFeignOfficeHour iFeignOfficeHour;

    @Autowired
    private IFeignCourse iFeignCourse;

    public Result<ProgramLectureListDTO> getByUserId(Long userId){
        System.out.println("second");
        List<Long> programIdList = userProgramDao.getByUserId(userId);

        System.out.println("third");
        ProgramLectureListDTO programLectureListDTO = new ProgramLectureListDTO();
        List<ProgramLectureDTO> list = new ArrayList();
        for(Long programId : programIdList){
            System.out.println(programId);
            ProgramVO programVO = iFeignProgram.getById(programId);
            OfficeHourVO officeHourVO = iFeignOfficeHour.getByProgramId(programId);

            ProgramLectureDTO programLectureDTO = new ProgramLectureDTO();
            programLectureDTO.setId(programVO.getId());
            programLectureDTO.setSort(programVO.getSort());
            programLectureDTO.setProgramName(programVO.getProgramName());
            programLectureDTO.setProgramLogo(programVO.getProgramLogo());
            programLectureDTO.setDescription(programVO.getDescription());
            programLectureDTO.setLectureId(officeHourVO.getLecturerId());
            programLectureDTO.setLecturerName(officeHourVO.getLecturerName());
            programLectureDTO.setHeadImgUrl(officeHourVO.getHeadImgUrl());

            if (StringUtils.isEmpty(programVO)) {
                return Result.error("根据用户编号没找到对应的项目信息!");
            }
            list.add(programLectureDTO);
            //list.add(BeanUtil.copyProperties(programVO, ProgramDTO.class));
            //list.add(BeanUtil.copyProperties(ProgramDTO.class, programVO));
            //ProgramDTO programDTO = apiProgramBiz.getProgramById(programId);
            //list.add(programDTO);
        }
        programLectureListDTO.setList(list);
        return Result.success(programLectureListDTO);
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

    public Result<ProgramCourseListDTO> getProgramCourseStatusByUserId(UserInfoBO userInfoBO){
        Long userId = userInfoBO.getUserId();
        List<UserCourse> courseList = userCourseDao.getCourseByUser(userId);
        HashMap<Long,Integer> courseStatus = new HashMap();
        //record course that the user is studying or finish studying
        for(UserCourse userCourse : courseList){
            courseStatus.put(userCourse.getCourseId(),userCourse.getCourseStatus());
        }
        List<Long> programIdList = userProgramDao.getByUserId(userId);
        List<ProgramCourseDTO> programCourseDTOList = new ArrayList();
        //Under each program for a user
        for(Long programId : programIdList){
            CourseListVO courseListVO = iFeignCourse.getCourseByProgramId(programId);
            ProgramVO programVO = iFeignProgram.getById(programId);
            List<CourseVO> courseVOList = courseListVO.getCourseVOList();
            List<CourseDTO> courseDTOList = new ArrayList();
            // Under each course for a program
            for(CourseVO courseVO : courseVOList){
                CourseDTO courseDTO = new CourseDTO();
                //status 0 means have not studied, 1 means in progress, 2 means complete.
                Integer status = courseStatus.getOrDefault(courseVO.getId(),0);
                courseDTO.setCourse(courseVO.getId(),status,courseVO.getCourseName());
                courseDTOList.add(courseDTO);
            }
            CourseListDTO courseListDTO = new CourseListDTO();
            courseListDTO.setCourseList(courseDTOList);
            ProgramCourseDTO programCourseDTO = new ProgramCourseDTO(programId,programVO.getProgramName(),courseListDTO);
            programCourseDTOList.add(programCourseDTO);
        }
        ProgramCourseListDTO programCourseListDTO = new ProgramCourseListDTO();
        programCourseListDTO.setProgramCourseDTOList(programCourseDTOList);
        return Result.success(programCourseListDTO);
    }
}
