package com.roncoo.education.course.feign.biz;

import cn.hutool.core.util.ObjectUtil;
import com.roncoo.education.common.core.base.BaseException;
import com.roncoo.education.common.core.tools.BeanUtil;
import com.roncoo.education.course.dao.OfficeHourDao;
import com.roncoo.education.course.dao.impl.mapper.entity.OfficeHour;
import com.roncoo.education.course.dao.impl.mapper.entity.Program;
import com.roncoo.education.course.feign.interfaces.vo.OfficeHourVO;
import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignOfficeHourBiz {
    @Autowired
    private OfficeHourDao dao;

    public OfficeHourVO getByProgramId(Long id){
        if (id == null) {
            throw new BaseException("传入的program id不能为空");
        }
        System.out.println(id);
        List<OfficeHour> officeHourList = dao.searchByProgramId(id);
        OfficeHour officeHour = new OfficeHour();
        if(officeHourList.isEmpty()){
            officeHour = null;
        }
        else {
            officeHour = officeHourList.get(0);
        }
        if (ObjectUtil.isNull(officeHour)) {
            throw new BaseException("找不到office hour信息");
        }
        OfficeHourVO officeHourVO = BeanUtil.copyProperties(officeHour, OfficeHourVO.class);
        return officeHourVO;
    }

}
