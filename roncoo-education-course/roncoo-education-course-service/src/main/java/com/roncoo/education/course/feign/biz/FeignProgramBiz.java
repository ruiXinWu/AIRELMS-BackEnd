package com.roncoo.education.course.feign.biz;

import cn.hutool.core.util.ObjectUtil;
import com.roncoo.education.common.core.base.BaseException;
import com.roncoo.education.common.core.tools.BeanUtil;
import com.roncoo.education.course.dao.ProgramDao;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
import com.roncoo.education.user.feign.interfaces.vo.LecturerExtVO;
import com.roncoo.education.user.feign.interfaces.vo.LecturerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeignProgramBiz {
    @Autowired
    private ProgramDao dao;

    public ProgramVO getById(Long id){
        System.out.println("调用FeignProgramBiz");
        if (id == null) {
            throw new BaseException("传入的program id不能为空");
        }
        Program program = dao.getById(id);
        if (ObjectUtil.isNull(program)) {
            throw new BaseException("找不到program信息");
        }
        ProgramVO programVO = BeanUtil.copyProperties(program, ProgramVO.class);
        //LecturerExt lecturerExt = lecturerExtDao.getByLecturerUserNo(record.getLecturerUserNo());
        //LecturerExtVO lecturerExtVO = BeanUtil.copyProperties(lecturerExt, LecturerExtVO.class);
        //vo.setLecturerExtVO(lecturerExtVO);
        return programVO;
    }
}
